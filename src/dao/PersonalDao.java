package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Personal;

public class PersonalDao {

	private static Session session;
	private Transaction tx;

	private static PersonalDao dao = null;

	protected PersonalDao() {}

	public static PersonalDao getInstancia() {
		if (dao == null) {
			dao = new PersonalDao();
		}
		return dao;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Personal objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Personal objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	// devuelve Cocinero o Cajero segun corresponda
	public Personal traer(long idPersonal) {
		Personal objeto = null;
		try {
			iniciaOperacion();
			objeto = (Personal) session.get(Personal.class, idPersonal);
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Personal> traer() {
		List<Personal> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Personal p order by p.apellido asc, p.nombre asc",
					Personal.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

	// consulta responsables a cargo de mas de una unidad,
	// con su tipo concreto (Cocinero/Cajero), cantidad de unidades
	// y superficie total que administran
	public List<Object[]> responsablesConMasDeUnaUnidad() {
	    List<Object[]> lista = null;
	    try {
	        iniciaOperacion();
	        String hql = "select r.nombre, r.apellido, type(r), "
	                + "count(u.id), sum(u.superficieM2) "
	                + "from UnidadDeVenta u join u.responsable r "
	                + "group by r.id, r.nombre, r.apellido, type(r) "
	                + "having count(u.id) > 1 "
	                + "order by sum(u.superficieM2) desc";
	        lista = session.createQuery(hql, Object[].class).getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
}
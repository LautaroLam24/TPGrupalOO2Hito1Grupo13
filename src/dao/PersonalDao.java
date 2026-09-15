package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;
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

	// entry point: unico lugar donde se recibe un id crudo,
	// porque todavia no existe el objeto en memoria
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

	// consulta: dado un festival, listar sus unidades de venta
	// junto con el responsable a cargo de cada una (nombre, apellido, tipo)
	public List<Object[]> responsablesPorFestival(Festival festival) {
		List<Object[]> lista = null;
		try {
			iniciaOperacion();
			String hql = "select u.nombreComercial, r.nombre, r.apellido, type(r) "
					+ "from UnidadDeVenta u join u.responsable r "
					+ "where u.festival = :festival "
					+ "order by u.nombreComercial asc";
			lista = session.createQuery(hql, Object[].class)
					.setParameter("festival", festival)
					.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public Festival traerFestivalCompleto(long idFestival) {
	    Festival festival = null;
	    try {
	        iniciaOperacion();
	        festival = (Festival) session.get(Festival.class, idFestival);
	    } finally {
	        session.close();
	    }
	    return festival;
	}
}
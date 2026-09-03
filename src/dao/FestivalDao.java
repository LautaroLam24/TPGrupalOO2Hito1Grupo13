package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;

public class FestivalDao {
	private static Session session;
	private Transaction tx;

	private static FestivalDao dao = null;

	protected FestivalDao() {}

	public static FestivalDao getInstancia() {
		if (dao == null) {
			dao = new FestivalDao();
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

	public int agregar(Festival objeto) {
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

	public void actualizar(Festival objeto) {
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


	public Festival traer(long idFestival) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			objeto = (Festival) session.get(Festival.class, idFestival);
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Festival> traer() {
		List<Festival> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Festival p order by p.nombre asc, p.temporada desc",
					Festival.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

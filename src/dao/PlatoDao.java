package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Plato;

public class PlatoDao {
	
	private static Session session;	
	private Transaction tx;
	
	private static PlatoDao dao = null;
	
	protected PlatoDao() {}
	
	public static PlatoDao getInstancia() {
		if (dao == null) {
			dao = new PlatoDao();
		}
		return dao;
	}
	
	private void iniciaOperacion()throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion (HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Plato objeto) {
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

	public void actualizar(Plato objeto) {
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

	public Plato traer(long idPlato) {
		Plato objeto = null;
		try {
			iniciaOperacion();
			objeto = (Plato) session.get(Plato.class, idPlato);
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Plato> traer() {
		List<Plato> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Plato p order by p.nombre asc", Plato.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.UnidadDeVenta;

public class UnidadDeVentaDao {

	private static Session session;
	private Transaction tx;

	private static UnidadDeVentaDao dao = null;

	protected UnidadDeVentaDao() {}

	public static UnidadDeVentaDao getInstancia() {
		if (dao == null) {
			dao = new UnidadDeVentaDao();
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


	public int agregar(UnidadDeVenta objeto) {
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

	public void actualizar(UnidadDeVenta objeto) {
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

	public void eliminar(UnidadDeVenta objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	//devuelve FoodTruck o PuestoDesarmable segun corresponda
		public UnidadDeVenta traer(long idUnidad) {
			UnidadDeVenta objeto = null;
			try {
				iniciaOperacion();
				objeto = (UnidadDeVenta) session.get(UnidadDeVenta.class, idUnidad);
			} finally {
				session.close();
			}
			return objeto;
		}
	
		public List<UnidadDeVenta> traer() {
			List<UnidadDeVenta> lista = null;
			try {
				iniciaOperacion();
				lista = session.createQuery("from UnidadDeVenta u order by u.nombreComercial asc",
						UnidadDeVenta.class).list();
			} finally {
				session.close();
			}
			return lista;
		}

		public UnidadDeVenta traerUnidadYPlatos(long idUnidad) throws HibernateException {
		    UnidadDeVenta objeto = null;
		    try {
		        iniciaOperacion();
		        String hql = "from UnidadDeVenta u where u.id = :idUnidad";
		        objeto = (UnidadDeVenta) session.createQuery(hql)
		                .setParameter("idUnidad", idUnidad)
		                .uniqueResult();
		        Hibernate.initialize(objeto.getPlatos());
		    } finally {
		        session.close();
		    }
		    return objeto;
		}
}	
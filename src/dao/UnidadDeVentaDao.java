package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.UnidadDeVenta;

import datos.Plato;
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
		
		public Object[] estadisticaPlatosDeUnidad(UnidadDeVenta unidad) {
		    Object[] fila = null;
		    try {
		        iniciaOperacion();
		        String hql = "select count(p.id), "
		                   + "       avg(p.precioVenta), "
		                   + "       avg(p.precioVenta - p.costoProduccion), "
		                   + "       max(p.precioVenta), "
		                   + "       min(p.precioVenta) "
		                   + "from UnidadDeVenta u join u.platos p "
		                   + "where u.id = :idUnidad";
		        fila = (Object[]) session.createQuery(hql)
		                .setParameter("idUnidad", unidad.getId())
		                .uniqueResult();
		    } finally {
		        session.close();
		    }
		    return fila;
		}
		
		public List<Object[]> rankingUnidadesPorGanancia() {
		    List<Object[]> lista = null;
		    try {
		        iniciaOperacion();
		        String hql = "select u.nombreComercial, "
		                   + "       count(p.id), "
		                   + "       avg(p.precioVenta - p.costoProduccion) "
		                   + "from UnidadDeVenta u join u.platos p "
		                   + "group by u.id, u.nombreComercial "
		                   + "order by avg(p.precioVenta - p.costoProduccion) desc";
		        lista = session.createQuery(hql, Object[].class).getResultList();
		    } finally {
		        session.close();
		    }
		    return lista;
		}
		
		public List<Plato> platosDestacadosDeUnidad(UnidadDeVenta unidad) {
		    List<Plato> lista = null;
		    try {
		        iniciaOperacion();
		        String hql = "select p from Plato p "
		                   + "where p.unidad.id = :idUnidad "
		                   + "  and p.precioVenta > (select avg(p2.precioVenta) "
		                   + "                       from Plato p2 "
		                   + "                       where p2.unidad.id = :idUnidad) "
		                   + "order by p.precioVenta desc";
		        lista = session.createQuery(hql, Plato.class)
		                .setParameter("idUnidad", unidad.getId())
		                .getResultList();
		    } finally {
		        session.close();
		    }
		    return lista;
		}
		
		public List<Object[]> rankingFoodTrucksPorCantidadPlatos(long idFestival) {
			List<Object[]> lista = null;
			try {
				iniciaOperacion();
				String hql =
						"select ft.nombreComercial, ft.patente, count(p.id) "
					  + "from FoodTruck ft "
					  + "join ft.platos p "
					  + "where ft.festival.id = :idFestival "
					  + "group by ft.id, ft.nombreComercial, ft.patente "
					  + "order by count(p.id) desc";
				lista = session.createQuery(hql, Object[].class)
						.setParameter("idFestival", idFestival)
						.getResultList();
			} finally {
				session.close();
			}
			return lista;
		}
}
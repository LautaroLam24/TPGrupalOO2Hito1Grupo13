package dao;

import java.time.LocalDate;
import java.util.List;

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

	// devuelve FoodTruck o PuestoDesarmable segun corresponda
	public UnidadDeVenta traer(int idUnidad) {
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

	public List<UnidadDeVenta> traerRankingUnidades(LocalDate desde, LocalDate hasta, String temporada,
			long minPlatosVendidos, LocalDate ingresoMaximoCocinero) {
		List<UnidadDeVenta> lista = null;
		try {
			iniciaOperacion();
			String hql = "select u from Pedido p "
					+ "     join p.festival f "
					+ "     join p.unidad u "
					+ "     join p.items i "
					+ "     join i.plato pl "
					+ "where f.temporada = :temporada "
					+ "  and p.fechaTransaccion between :desde and :hasta "
					+ "  and exists (select c.id from Cocinero c "
					+ "              where c.unidad = u "
					+ "                and c.fechaIngreso <= :ingresoMaximo) "
					+ "group by u.id "
					+ "having sum(i.cantidad) >= :minPlatos "
					+ "order by sum(i.cantidad * (pl.precioVenta - pl.costoProduccion)) desc";
			lista = session.createQuery(hql, UnidadDeVenta.class)
					.setParameter("temporada", temporada)
					.setParameter("desde", desde)
					.setParameter("hasta", hasta)
					.setParameter("ingresoMaximo", ingresoMaximoCocinero)
					.setParameter("minPlatos", minPlatosVendidos)
					.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Object[]> buscarPlatosFoodTrucks(String nombreFestival, float precioMinimo,
			float precioMaximo, boolean requiereConexion) {
		List<Object[]> lista = null;
		try {
			iniciaOperacion();
			String hql = "select ft.nombreComercial, "
					+ "ft.patente, "
					+ "p.nombre, "
					+ "p.precioVenta, "
					+ "p.costoProduccion "
					+ "from FoodTruck ft "
					+ "join ft.platos p "
					+ "where ft.festival.nombre = :nombreFestival "
					+ "and ft.requiereConexionElectrica = :requiereConexion "
					+ "and p.precioVenta between :precioMinimo and :precioMaximo "
					+ "order by p.precioVenta asc";
			lista = session.createQuery(hql, Object[].class)
					.setParameter("nombreFestival", nombreFestival)
					.setParameter("requiereConexion", requiereConexion)
					.setParameter("precioMinimo", precioMinimo)
					.setParameter("precioMaximo", precioMaximo)
					.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}
package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;
import datos.Pedido;
import datos.Plato;
import dto.PlatoVendidoDTO;

public class PedidoDao {
	private static Session session;
	private Transaction tx;

	private static PedidoDao dao = null;

	protected PedidoDao() {}

	public static PedidoDao getInstancia() {
		if (dao == null) {
			dao = new PedidoDao();
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

	public int agregar(Pedido objeto) {
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

	public void actualizar(Pedido objeto) {
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

	public Pedido traer(long idPedido) {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (Pedido) session.get(Pedido.class, idPedido);
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Pedido> traer() {
		List<Pedido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Pedido p order by id asc",
					Pedido.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<PlatoVendidoDTO> traerTopPlatosPorFestival(Festival festival, int topN) {
	    List<PlatoVendidoDTO> resultado = null;
	    long idFestival= festival.getId();
	    try {
	        iniciaOperacion();
	        String hql = "select new dto.PlatoVendidoDTO(pl.id, pl.nombre, pl.precioVenta, sum(i.cantidad))" +
	                     "from Pedido p " +
	                     "join p.items i " +
	                     "join i.plato pl " +
	                     "where p.unidad.festival.id = :idFestival " +
	                     "group by pl.id, pl.nombre " +
	                     "order by sum(i.cantidad) desc";
	        resultado = session.createQuery(hql, PlatoVendidoDTO.class)
	                           .setParameter("idFestival", idFestival)
	                           .setMaxResults(topN)
	                           .list();
	    } finally {
	        session.close();
	    }
	    return resultado;
	}
	
	public List<Plato> traerPlatosVendidosPorPrecioYFechas(float precioMinimo, LocalDate desde, LocalDate hasta) {
	    
	    List<Plato> lista = null;
	    try {
	        iniciaOperacion();
	        String hql = "select distinct pl " +
	                     "from Pedido p " +
	                     "join p.items i " +
	                     "join i.plato pl " +
	                     "where pl.precioVenta >= :precioMinimo " +
	                     "  and p.fechaTransaccion between :desde and :hasta " +
	                     "order by pl.nombre asc";

	        lista = session.createQuery(hql, Plato.class)
	                       .setParameter("precioMinimo", precioMinimo)
	                       .setParameter("desde", desde)
	                       .setParameter("hasta", hasta)
	                       .list();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
}

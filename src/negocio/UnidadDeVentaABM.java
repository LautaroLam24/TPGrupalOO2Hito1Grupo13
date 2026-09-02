package negocio;

import java.util.List;

import datos.Plato;
import dao.UnidadDeVentaDao;
import datos.UnidadDeVenta;

public class UnidadDeVentaABM {

	private static UnidadDeVentaABM abm = null;
	private UnidadDeVentaDao dao = UnidadDeVentaDao.getInstancia();

	private UnidadDeVentaABM() {}

	public static UnidadDeVentaABM getInstancia() {
		if (abm == null) {
			abm = new UnidadDeVentaABM();
		}
		return abm;
	}

	public int agregar(UnidadDeVenta u) {
		return dao.agregar(u);
	}

	public void modificar(UnidadDeVenta u) {
		dao.actualizar(u);
	}

	public void eliminar(long idUnidad) {
		UnidadDeVenta u = dao.traer(idUnidad);
		dao.eliminar(u);
	}

	public UnidadDeVenta traer(long idUnidad) {
		return dao.traer(idUnidad);
	}

	public List<UnidadDeVenta> traer() {
		return dao.traer();
	}

	public UnidadDeVenta traerUnidadYPlatos(long idUnidad) {
		return dao.traerUnidadYPlatos(idUnidad);
	}
	
	public Object[] estadisticaPlatosDeUnidad(long idUnidad) {
	    return dao.estadisticaPlatosDeUnidad(idUnidad);
	}
	
	public List<Object[]> rankingUnidadesPorGanancia() {
	    return dao.rankingUnidadesPorGanancia();
	}
	
	public List<Plato> platosDestacadosDeUnidad(long idUnidad) {
	    return dao.platosDestacadosDeUnidad(idUnidad);
	}
}

package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.UnidadDeVentaDao;
import datos.UnidadDeVenta;
import datos.Plato;

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

	public void eliminar(int idUnidad) {
		UnidadDeVenta u = dao.traer(idUnidad);
		dao.eliminar(u);
	}

	public UnidadDeVenta traer(int idUnidad) {
		return dao.traer(idUnidad);
	}

	public List<UnidadDeVenta> traer() {
		return dao.traer();
	}

	public List<UnidadDeVenta> traerRankingUnidades(LocalDate desde, LocalDate hasta, String temporada,
			long minPlatosVendidos, int antiguedadMinimaCocinero) {
		if (desde == null || hasta == null)
			throw new IllegalArgumentException("Las fechas son obligatorias");
		if (desde.isAfter(hasta))
			throw new IllegalArgumentException("La fecha desde (" + desde + ") es posterior a hasta (" + hasta + ")");
		if (temporada == null || temporada.trim().isEmpty())
			throw new IllegalArgumentException("La temporada es obligatoria");
		if (minPlatosVendidos < 0)
			throw new IllegalArgumentException("El minimo de platos vendidos no puede ser negativo");
		if (antiguedadMinimaCocinero < 0)
			throw new IllegalArgumentException("La antiguedad minima no puede ser negativa");

		LocalDate ingresoMaximo = LocalDate.now().minusYears(antiguedadMinimaCocinero);
		return dao.traerRankingUnidades(desde, hasta, temporada, minPlatosVendidos, ingresoMaximo);
	}

	public List<Plato> buscarPlatosFoodTrucks(
			String nombreFestival,
			float precioMinimo,
			float precioMaximo,
			boolean requiereConexion) {

		return dao.buscarPlatosFoodTrucks(
				nombreFestival,
				precioMinimo,
				precioMaximo,
				requiereConexion
		);
	}
}
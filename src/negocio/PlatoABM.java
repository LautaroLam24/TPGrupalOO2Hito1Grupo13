package negocio;

import java.math.BigDecimal;
import java.util.List;

import dao.PlatoDao;
import datos.Plato;
import datos.UnidadDeVenta;

public class PlatoABM {

	private static PlatoABM abm = null;
	private PlatoDao dao = PlatoDao.getInstancia();

	private PlatoABM() {}

	public static PlatoABM getInstancia() {
		if (abm == null) {
			abm = new PlatoABM();
		}
		return abm;
	}

	public int agregar(String nombre, BigDecimal precioVenta, BigDecimal costoProduccion, UnidadDeVenta unidad) {
		Plato p = new Plato(nombre, precioVenta, costoProduccion, unidad);
		return dao.agregar(p);
	}

	public void modificar(Plato p) {
		dao.actualizar(p);
	}

	public Plato traer(long idPlato) {
		return dao.traer(idPlato);
	}

	public List<Plato> traer() {
		return dao.traer();
	}
}

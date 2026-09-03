package negocio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import dao.FestivalDao;
import datos.Festival;


public class FestivalABM {

	private static FestivalABM abm = null;
	private FestivalDao dao = FestivalDao.getInstancia();

	private FestivalABM() {}

	public static FestivalABM getInstancia() {
		if (abm == null) {
			abm = new FestivalABM();
		}
		return abm;
	}

	public int agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, BigDecimal costoPorSuperficie, BigDecimal costoPorMontaje, BigDecimal plusElectricidad, BigDecimal sueldoBase) {
		Festival f = new Festival(nombre, temporada, fechaInicio, fechaFin, costoPorSuperficie, costoPorMontaje, plusElectricidad, sueldoBase);
		return dao.agregar(f);
	}

	public void modificar(Festival f) {
		dao.actualizar(f);
	}

	public Festival traer(long idFestival) {
		return dao.traer(idFestival);
	}

	public List<Festival> traer() {
		return dao.traer();
	}

	
}
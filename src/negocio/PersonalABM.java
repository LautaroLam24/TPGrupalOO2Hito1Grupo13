package negocio;

import java.util.List;

import dao.PersonalDao;
import datos.Personal;
import datos.UnidadDeVenta;

public class PersonalABM {

	private static PersonalABM abm = null;
	private PersonalDao dao = PersonalDao.getInstancia();

	private PersonalABM() {}

	public static PersonalABM getInstancia() {
		if (abm == null) {
			abm = new PersonalABM();
		}
		return abm;
	}

	public int agregar(Personal p) {
		return dao.agregar(p);
	}

	public void modificar(Personal p) {
		dao.actualizar(p);
	}

	public Personal traer(long idPersonal) {
		return dao.traer(idPersonal);
	}

	public List<Personal> traer() {
		return dao.traer();
	}

	public List<UnidadDeVenta> unidadesConResponsableCocinero(String nombreFestival,
			String temporada, float superficieMinima) {
		return dao.unidadesConResponsableCocinero(nombreFestival, temporada, superficieMinima);
	}
}
package test;

import java.util.List;

import datos.Festival;
import datos.UnidadDeVenta;
import negocio.PersonalABM;
import negocio.UnidadDeVentaABM;

public class TestMateo {
	public static void main(String[] args) {

		// unico punto de entrada con id crudo: todavia no tenemos ningun objeto
		int idUnidadConocida = 1;
		UnidadDeVentaABM unidadAbm = UnidadDeVentaABM.getInstancia();
		UnidadDeVenta unidad = unidadAbm.traer(idUnidadConocida);

		if (unidad == null) {
			System.out.println("No existe la unidad con id " + idUnidadConocida);
			return;
		}

		PersonalABM personalAbm = PersonalABM.getInstancia();

		long idFestival = unidad.getFestival().getId(); // esto SI es seguro, no dispara el proxy
		Festival festival = personalAbm.traerFestivalCompleto(idFestival);

		List<Object[]> lista = personalAbm.responsablesPorFestival(festival);

		System.out.println("========================================================");
		System.out.println("  RESPONSABLES POR UNIDAD - FESTIVAL: " + festival.getNombre());
		System.out.println("========================================================");
		System.out.printf("%-25s %-15s %-15s %-10s%n", "Unidad", "Nombre", "Apellido", "Tipo");

		if (lista.isEmpty()) {
			System.out.println("(no hay unidades con responsable en este festival)");
		} else {
			for (Object[] fila : lista) {
				String tipo = fila[3].toString().replace("class datos.", "");
				System.out.printf("%-25s %-15s %-15s %-10s%n", fila[0], fila[1], fila[2], tipo);
			}
		}
	}
}
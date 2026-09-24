package test;

import java.util.List;

import datos.FoodTruck;
import datos.PuestoDesarmable;
import datos.UnidadDeVenta;
import negocio.PersonalABM;

/*
 * Caso de uso: unidades de venta de un festival (nombre + temporada) con
 * superficie minima dada, cuyo responsable sea del tipo Cocinero.
 * Devuelve entidades UnidadDeVenta, ordenadas por superficie descendente.
 */
public class TestMateo {
	public static void main(String[] args) {

		PersonalABM abm = PersonalABM.getInstancia();

		String nombreFestival = "Festival Otoño";
		String temporada = "2026";
		float superficieMinima = 10f;

		List<UnidadDeVenta> lista = abm.unidadesConResponsableCocinero(
				nombreFestival, temporada, superficieMinima);

		System.out.println("====================================================================");
		System.out.println("  UNIDADES CON RESPONSABLE COCINERO");
		System.out.printf("  Festival: %s | Temporada: %s | Superficie minima: %.1f m2%n",
				nombreFestival, temporada, superficieMinima);
		System.out.println("====================================================================");

		if (lista.isEmpty()) {
			System.out.println("(ninguna unidad cumple los filtros)");
			return;
		}

		for (UnidadDeVenta u : lista) {
			System.out.printf("- %-20s codigo=%s  superficie=%.1f m2",
					u.getNombreComercial(), u.getCodigo(), u.getSuperficieM2());

			if (u instanceof FoodTruck) {
				System.out.println("  [FoodTruck]");
			} else if (u instanceof PuestoDesarmable) {
				System.out.println("  [PuestoDesarmable]");
			}
		}
	}
}
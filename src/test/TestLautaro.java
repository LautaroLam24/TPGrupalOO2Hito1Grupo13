package test;

import java.time.LocalDate;
import java.util.List;

import datos.FoodTruck;
import datos.PuestoDesarmable;
import datos.UnidadDeVenta;
import negocio.UnidadDeVentaABM;

/*
 * Caso de uso: ranking de unidades de venta mas rentables.
 * Filtros: rango de fechas, temporada del festival, minimo de platos vendidos
 * y antiguedad minima de algun cocinero del staff.
 * Devuelve entidades ordenadas por ganancia (la primera es la ganadora).
 */
public class TestLautaro {

	public static void main(String[] args) {

		UnidadDeVentaABM abm = UnidadDeVentaABM.getInstancia();

		LocalDate desde = LocalDate.of(2026, 1, 1);
		LocalDate hasta = LocalDate.of(2026, 12, 31);
		String temporada = "Verano";
		long minPlatosVendidos = 10;
		int antiguedadMinimaCocinero = 5;

		List<UnidadDeVenta> ranking = abm.traerRankingUnidades(desde, hasta, temporada,
				minPlatosVendidos, antiguedadMinimaCocinero);

		System.out.println("====================================================================================");
		System.out.println("  RANKING DE UNIDADES MAS RENTABLES");
		System.out.printf("  Periodo: %s a %s | Temporada: %s%n", desde, hasta, temporada);
		System.out.printf("  Minimo %d platos vendidos | Cocinero con %d+ anios de antiguedad%n",
				minPlatosVendidos, antiguedadMinimaCocinero);
		System.out.println("====================================================================================");

		if (ranking.isEmpty()) {
			System.out.println("(ninguna unidad cumple los filtros)");
			return;
		}

		int puesto = 1;
		for (UnidadDeVenta u : ranking) {
			System.out.printf("%d) %-20s codigo=%s  superficie=%.1f m2%n",
					puesto++, u.getNombreComercial(), u.getCodigo(), u.getSuperficieM2());

			if (u instanceof FoodTruck) {
				FoodTruck ft = (FoodTruck) u;
				System.out.printf("   Food Truck | patente %s | %s conexion electrica%n",
						ft.getPatente(), ft.isRequiereConexionElectrica() ? "requiere" : "no requiere");
			} else if (u instanceof PuestoDesarmable) {
				PuestoDesarmable pd = (PuestoDesarmable) u;
				System.out.printf("   Puesto Desarmable | %d carpas | montaje %d min%n",
						pd.getCantidadCarpas(), pd.getTiempoMontajeMinutos());
			}
		}

		System.out.println();
		System.out.println("Unidad ganadora: " + ranking.get(0).getNombreComercial());
	}
}
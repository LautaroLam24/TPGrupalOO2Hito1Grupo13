package test;

import java.util.List;

import datos.Plato;
import datos.UnidadDeVenta;
import negocio.UnidadDeVentaABM;

public class TestLautaro {

	public static void main(String[] args) {

		long idUnidad = 1;
		UnidadDeVentaABM abm = UnidadDeVentaABM.getInstancia();

		// 1) Traer unidad y sus platos
		UnidadDeVenta u = abm.traerUnidadYPlatos(idUnidad);

		if (u == null) {
			System.out.println("No existe la unidad con id " + idUnidad);
			return;
		}

		System.out.println("Unidad de venta: " + u);
		System.out.println("Tipo concreto: " + u.getClass().getSimpleName());
		System.out.println("\nPlatos ofrecidos:");
		for (Plato p : u.getPlatos()) {
			System.out.println("   - " + p);
		}

		// 2) Estadistica de platos de la unidad
		Object[] est = abm.estadisticaPlatosDeUnidad(u);

		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.println("  ESTADISTICA DE PLATOS DE LA UNIDAD");
		System.out.println("--------------------------------------------------------");
		if (est == null) {
			System.out.println("La unidad no tiene platos cargados.");
		} else {
			System.out.println("Cantidad de platos : " + est[0]);
			System.out.println("Precio promedio    : " + est[1]);
			System.out.println("Ganancia promedio  : " + est[2]);
			System.out.println("Precio maximo      : " + est[3]);
			System.out.println("Precio minimo      : " + est[4]);
		}

		// 3) Ranking de unidades por ganancia promedio
		List<Object[]> ranking = abm.rankingUnidadesPorGanancia();

		System.out.println();
		System.out.println("========================================================");
		System.out.println("  RANKING DE UNIDADES POR GANANCIA PROMEDIO DE PLATOS");
		System.out.println("========================================================");
		System.out.printf("%-30s %10s %14s%n", "Unidad", "#Platos", "Gan.Prom.");
		for (Object[] fila : ranking) {
			System.out.printf("%-30s %10s %14s%n", fila[0], fila[1], fila[2]);
		}

		// 4) Platos destacados
		List<Plato> destacados = abm.platosDestacadosDeUnidad(u);

		System.out.println();
		System.out.println("Platos DESTACADOS de la unidad " + u.getId() + " (precio sobre el promedio):");
		if (destacados.isEmpty()) {
			System.out.println("   (ninguno)");
		} else {
			for (Plato p : destacados) {
				System.out.printf("   * %-25s precio=%s%n", p.getNombre(), p.getPrecioVenta());
			}
		}
	}
}
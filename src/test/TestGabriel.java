package test;

import java.util.List;

import negocio.UnidadDeVentaABM;

public class TestGabriel {

	public static void main(String[] args) {

		long idFestival = 1;

		UnidadDeVentaABM abm =
				UnidadDeVentaABM.getInstancia();

		List<Object[]> lista =
				abm.rankingFoodTrucksPorCantidadPlatos(idFestival);

		System.out.println();
		System.out.println("///////////////////////////////////////////////");
		System.out.println("        FOOD TRUCKS Y CANTIDAD DE PLATOS");
		System.out.println("///////////////////////////////////////////////");
		System.out.println();
		System.out.printf(
				"%-25s %-12s %10s%n",
				"FoodTruck",
				"Patente",
				"#Platos"
		);

		System.out.println("--------------------------------------------------------");

		if (lista.isEmpty()) {

			System.out.println("No hay FoodTrucks para este festival.");

		} else {

			for (Object[] fila : lista) {

				System.out.printf(
						"%-25s %-12s %10s%n",
						fila[0],
						fila[1],
						fila[2]
				);
			}
		}
	}
}
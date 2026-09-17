package test;

import java.util.List;
import java.util.Scanner;

import negocio.FestivalABM;
import negocio.UnidadDeVentaABM;

public class TestGabriel {

	public static void main(String[] args) {

		FestivalABM festivalABM =
				FestivalABM.getInstancia();

		UnidadDeVentaABM unidadABM =
				UnidadDeVentaABM.getInstancia();

		Scanner scanner = new Scanner(System.in);

		// Traer festivales disponibles
		List<String> festivales =
				festivalABM.traerNombresFestivales();

		System.out.println();
		System.out.println("///////////////////////////////////////////////");
		System.out.println("             FESTIVALES DISPONIBLES");
		System.out.println("///////////////////////////////////////////////");

		if (festivales.isEmpty()) {
			System.out.println("No hay festivales cargados.");
			scanner.close();
			return;
		}

		for (int i = 0; i < festivales.size(); i++) {
			System.out.println((i + 1) + " - " + festivales.get(i));
		}

		System.out.println();
		System.out.print("Seleccione un festival: ");

		int opcion = scanner.nextInt();

		if (opcion < 1 || opcion > festivales.size()) {
			System.out.println("Opcion invalida.");
			scanner.close();
			return;
		}

		// Obtengo el nombre elegido
		String nombreFestival =
				festivales.get(opcion - 1);

		System.out.println();
		System.out.println("Festival seleccionado: " + nombreFestival);

		// Consultar FoodTrucks del festival elegido
		List<Object[]> lista =
				unidadABM.rankingFoodTrucksPorCantidadPlatos(nombreFestival);

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

		scanner.close();
	}
}
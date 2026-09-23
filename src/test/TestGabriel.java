package test;

import java.util.List;
import java.util.Scanner;

import datos.Plato;
import negocio.FestivalABM;
import negocio.UnidadDeVentaABM;

public class TestGabriel {

	public static void main(String[] args) {

		FestivalABM festivalABM = FestivalABM.getInstancia();
		UnidadDeVentaABM unidadABM = UnidadDeVentaABM.getInstancia();

		Scanner scanner = new Scanner(System.in);

		// =====================================================
		// 1. MOSTRAR FESTIVALES DISPONIBLES
		// =====================================================

		List<String> festivales = festivalABM.traerNombresFestivales();

		System.out.println();
		System.out.println("===============================================");
		System.out.println("             FESTIVALES DISPONIBLES");
		System.out.println("===============================================");

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

		int opcion = Integer.parseInt(scanner.nextLine());

		if (opcion < 1 || opcion > festivales.size()) {
			System.out.println("Opcion invalida.");
			scanner.close();
			return;
		}

		String nombreFestival = festivales.get(opcion - 1);


		// =====================================================
		// 2. INGRESAR FILTROS
		// =====================================================

		System.out.print("Precio minimo: $");
		float precioMinimo =
				Float.parseFloat(scanner.nextLine().replace(',', '.'));

		System.out.print("Precio maximo: $");
		float precioMaximo =
				Float.parseFloat(scanner.nextLine().replace(',', '.'));

		if (precioMinimo > precioMaximo) {
			System.out.println("El precio minimo no puede superar al maximo.");
			scanner.close();
			return;
		}

		System.out.print(
				"¿El FoodTruck debe requerir conexion electrica? (s/n): "
		);

		String respuesta = scanner.nextLine();

		boolean requiereConexion =
				respuesta.equalsIgnoreCase("s");


		// =====================================================
		// 3. EJECUTAR CONSULTA
		// =====================================================

		List<Plato> platos =
				unidadABM.buscarPlatosFoodTrucks(
						nombreFestival,
						precioMinimo,
						precioMaximo,
						requiereConexion
				);


		System.out.println();
		System.out.println("========================================================");
		System.out.println("                  PLATOS ENCONTRADOS");
		System.out.println("========================================================");

		System.out.println("Festival: " + nombreFestival);
		System.out.printf(
				"Rango de precio: $%.2f - $%.2f%n",
				precioMinimo,
				precioMaximo
		);

		System.out.println(
				"Requiere conexion electrica: "
				+ (requiereConexion ? "SI" : "NO")
		);

		System.out.println();


		if (platos.isEmpty()) {

			System.out.println(
					"No se encontraron platos con esos criterios."
			);

			scanner.close();
			return;
		}


		// =====================================================
		// 4. LOGICA CON LOS RESULTADOS
		// =====================================================

		float sumaPrecios = 0;
		float sumaMargenes = 0;

		Plato platoMasBarato = platos.get(0);
		Plato platoMasCaro = platos.get(0);
		Plato platoMayorMargen = platos.get(0);

		System.out.printf(
				"%-25s %12s %12s %12s%n",
				"Plato",
				"Precio",
				"Costo",
				"Margen"
		);

		System.out.println(
				"--------------------------------------------------------------"
		);


		for (Plato plato : platos) {

			float precio = plato.getPrecioVenta();
			float costo = plato.getCostoProduccion();

			float margen = precio - costo;


			System.out.printf(
					"%-25s $%11.2f $%11.2f $%11.2f%n",
					plato.getNombre(),
					precio,
					costo,
					margen
			);


			// Acumular datos para los promedios
			sumaPrecios += precio;
			sumaMargenes += margen;


			// Buscar plato mas barato
			if (precio < platoMasBarato.getPrecioVenta()) {
				platoMasBarato = plato;
			}


			// Buscar plato mas caro
			if (precio > platoMasCaro.getPrecioVenta()) {
				platoMasCaro = plato;
			}


			// Buscar plato con mayor margen
			float margenMayor =
					platoMayorMargen.getPrecioVenta()
					- platoMayorMargen.getCostoProduccion();

			if (margen > margenMayor) {
				platoMayorMargen = plato;
			}
		}


		// =====================================================
		// 5. CALCULOS FINALES
		// =====================================================

		float promedioPrecio =
				sumaPrecios / platos.size();

		float promedioMargen =
				sumaMargenes / platos.size();


		System.out.println();
		System.out.println("========================================================");
		System.out.println("                 ANALISIS DE RESULTADOS");
		System.out.println("========================================================");

		System.out.println(
				"Cantidad de platos encontrados: "
				+ platos.size()
		);

		System.out.printf(
				"Precio promedio: $%.2f%n",
				promedioPrecio
		);

		System.out.printf(
				"Margen promedio: $%.2f%n",
				promedioMargen
		);

		System.out.printf(
				"Plato mas barato: %s - $%.2f%n",
				platoMasBarato.getNombre(),
				platoMasBarato.getPrecioVenta()
		);

		System.out.printf(
				"Plato mas caro: %s - $%.2f%n",
				platoMasCaro.getNombre(),
				platoMasCaro.getPrecioVenta()
		);

		float mayorMargen =
				platoMayorMargen.getPrecioVenta()
				- platoMayorMargen.getCostoProduccion();

		System.out.printf(
				"Plato con mayor margen: %s - $%.2f%n",
				platoMayorMargen.getNombre(),
				mayorMargen
		);


		scanner.close();
	}
}
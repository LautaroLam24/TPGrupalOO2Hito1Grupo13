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

		// =====================================================
		// 1. TRAER FESTIVALES
		// =====================================================

		List<String> festivales =
				festivalABM.traerNombresFestivales();

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

		String nombreFestival =
				festivales.get(opcion - 1);


		// =====================================================
		// 2. INGRESAR FILTROS
		// =====================================================

		System.out.print("Precio minimo: $");
		float precioMinimo =
				Float.parseFloat(scanner.nextLine());

		System.out.print("Precio maximo: $");
		float precioMaximo =
				Float.parseFloat(scanner.nextLine());

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
		// 3. CONSULTAR
		// =====================================================

		List<Object[]> lista =
				unidadABM.buscarPlatosFoodTrucks(
						nombreFestival,
						precioMinimo,
						precioMaximo,
						requiereConexion
				);


		System.out.println();
		System.out.println("==============================================================");
		System.out.println("                PLATOS ENCONTRADOS");
		System.out.println("==============================================================");

		System.out.println("Festival: " + nombreFestival);
		System.out.println(
				"Rango de precio: $"
				+ precioMinimo
				+ " - $"
				+ precioMaximo
		);

		System.out.println(
				"Requiere conexion electrica: "
				+ (requiereConexion ? "SI" : "NO")
		);

		System.out.println();


		if (lista.isEmpty()) {

			System.out.println(
					"No se encontraron platos con esos criterios."
			);

			scanner.close();
			return;
		}


		System.out.printf(
				"%-22s %-12s %-22s %12s %12s%n",
				"FoodTruck",
				"Patente",
				"Plato",
				"Precio",
				"Costo"
		);

		System.out.println(
				"-------------------------------------------------------------------------------"
		);


		// =====================================================
		// 4. LOGICA SOBRE LOS RESULTADOS
		// =====================================================

		float sumaPrecios = 0;
		float sumaMargenes = 0;

		Object[] platoMasBarato = lista.get(0);
		Object[] platoMasCaro = lista.get(0);


		for (Object[] fila : lista) {

			float precio =
					((Number) fila[3]).floatValue();

			float costo =
					((Number) fila[4]).floatValue();

			float margen = precio - costo;


			System.out.printf(
					"%-22s %-12s %-22s $%11.2f $%11.2f%n",
					fila[0],
					fila[1],
					fila[2],
					precio,
					costo
			);


			sumaPrecios += precio;
			sumaMargenes += margen;


			float precioBarato =
					((Number) platoMasBarato[3]).floatValue();

			if (precio < precioBarato) {
				platoMasBarato = fila;
			}


			float precioCaro =
					((Number) platoMasCaro[3]).floatValue();

			if (precio > precioCaro) {
				platoMasCaro = fila;
			}
		}


		// =====================================================
		// 5. CALCULOS FINALES
		// =====================================================

		float promedioPrecio =
				sumaPrecios / lista.size();

		float promedioMargen =
				sumaMargenes / lista.size();


		System.out.println();
		System.out.println("==============================================================");
		System.out.println("                    ANALISIS DE RESULTADOS");
		System.out.println("==============================================================");

		System.out.println(
				"Cantidad de platos encontrados: "
				+ lista.size()
		);

		System.out.printf(
				"Precio promedio: $%.2f%n",
				promedioPrecio
		);

		System.out.printf(
				"Margen promedio: $%.2f%n",
				promedioMargen
		);

		System.out.println(
				"Plato mas barato: "
				+ platoMasBarato[2]
				+ " ($"
				+ platoMasBarato[3]
				+ ")"
		);

		System.out.println(
				"Plato mas caro: "
				+ platoMasCaro[2]
				+ " ($"
				+ platoMasCaro[3]
				+ ")"
		);


		scanner.close();
	}
}
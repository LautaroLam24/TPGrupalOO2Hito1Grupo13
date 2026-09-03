package test;

import java.util.List;

import negocio.PersonalABM;

public class TestMateo {
	public static void main(String[] args) {
		PersonalABM abm = PersonalABM.getInstancia();

		List<Object[]> lista = abm.responsablesConMasDeUnaUnidad();

		System.out.println("========================================================");
		System.out.println("  RESPONSABLES A CARGO DE MAS DE UNA UNIDAD DE VENTA");
		System.out.println("========================================================");
		System.out.printf("%-15s %-15s %-10s %10s %14s%n",
				"Nombre", "Apellido", "Tipo", "#Unidades", "Superficie");

		if (lista.isEmpty()) {
			System.out.println("(ningun responsable esta a cargo de mas de una unidad)");
		} else {
			for (Object[] fila : lista) {
				System.out.printf("%-15s %-15s %-10s %10s %14s%n",
						fila[0], fila[1], fila[2], fila[3], fila[4]);
			}
		}
	}
}
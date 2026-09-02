package test;

import datos.Plato;
import datos.UnidadDeVenta;
import negocio.UnidadDeVentaABM;


public class TestTraerUnidadYPlatos {

	public static void main(String[] args) {
		long idUnidad = 1;

		UnidadDeVenta u = UnidadDeVentaABM.getInstancia().traerUnidadYPlatos(idUnidad);

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
	}
}

package test;

import datos.Plato;
import datos.UnidadDeVenta;
import negocio.UnidadDeVentaABM;


public class TestLautaro {

	public static void main(String[] args) {
		long idUnidad = 1;
		
		UnidadDeVentaABM abm = UnidadDeVentaABM.getInstancia();
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
		
		Object[] est = abm.estadisticaPlatosDeUnidad(idUnidad);
		 
		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.println("  ESTADISTICA DE PLATOS DE LA UNIDAD");
		System.out.println("--------------------------------------------------------");
		if (est == null || num(est[0]) == 0) {
			System.out.println("La unidad no tiene platos cargados.");
		} else {
			System.out.println("Cantidad de platos : " + fmtEntero(est[0]));
            System.out.println("Precio promedio    : " + fmt(est[1]));
            System.out.println("Ganancia promedio  : " + fmt(est[2])); 
            System.out.println("Precio maximo      : " + fmt(est[3]));
            System.out.println("Precio minimo      : " + fmt(est[4]));
		}
	}
	
	

    private static long num(Object o) {
        return (o == null) ? 0 : ((Number) o).longValue();
    }

    private static String fmtEntero(Object o) {
        return (o == null) ? "-" : String.valueOf(((Number) o).longValue());
    }

    private static String fmt(Object o) {
        return (o == null) ? "-" : String.format("%,.2f", ((Number) o).doubleValue());
    }
}

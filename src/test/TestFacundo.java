package test;

import java.time.LocalDate;
import java.util.List;

import datos.Festival;
import datos.Plato;
import dto.PlatoVendidoDTO;
import negocio.FestivalABM;
import negocio.PedidoABM;

public class TestFacundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FestivalABM festivalABM = FestivalABM.getInstancia();
		PedidoABM abm= PedidoABM.getInstancia();
		
		Festival festival = festivalABM.traer(1);
		
		List<PlatoVendidoDTO> topPlatos = abm.traerTopPlatosPorFestival(festival,3);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.println("               Top X Platos mas vendidos");
		System.out.println("--------------------------------------------------------");
        for (PlatoVendidoDTO fila : topPlatos) {
            System.out.println("Plato: " + fila.getNombrePlato() + " | Unidades vendidas: " + fila.getCantidadVendida());
        }
        
        float precioMinimo = 5000;
        LocalDate desde = LocalDate.of(2026, 9, 1);
        LocalDate hasta = LocalDate.of(2026, 10, 31);

        List<Plato> platos = abm.traerPlatosVendidosPorPrecioYFechas(precioMinimo, desde, hasta);

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" Platos con precio >= $" + precioMinimo + " vendidos entre " + desde + " y " + hasta);
        System.out.println("--------------------------------------------------------------------------------");

        if (platos != null && !platos.isEmpty()) {
            for (Plato p : platos) {
                System.out.println("Nombre: " + p.getNombre() + " | Precio: $" + p.getPrecioVenta());
            }
        } else {
            System.out.println("No se vendió ningún plato con ese criterio en el período indicado.");
        }
	}
	
	

}

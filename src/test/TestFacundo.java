package test;

import java.util.List;

import datos.Festival;
import negocio.FestivalABM;
import negocio.PedidoABM;

public class TestFacundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FestivalABM festivalABM = FestivalABM.getInstancia();
		PedidoABM abm= PedidoABM.getInstancia();
		
		Festival festival = festivalABM.traer(1);
		
		List<Object[]> topPlatos = abm.traerTopPlatosPorFestival(festival,3);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.println("               Top X Platos mas vendidos");
		System.out.println("--------------------------------------------------------");
        for (Object[] fila : topPlatos) {
            System.out.println("Plato: " + fila[0] + " | Unidades vendidas: " + fila[1]);
        }
	}

}

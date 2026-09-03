package test;

import java.util.List;

import negocio.PedidoABM;

public class TestFacundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PedidoABM abm= PedidoABM.getInstancia();
		List<Object[]> topPlatos = abm.traerTopPlatosPorFestival(1,3);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.println("               Top 3 Platos mas vendidos");
		System.out.println("--------------------------------------------------------");
        for (Object[] fila : topPlatos) {
            System.out.println("Plato: " + fila[0] + " | Unidades vendidas: " + fila[1]);
        }
	}

}

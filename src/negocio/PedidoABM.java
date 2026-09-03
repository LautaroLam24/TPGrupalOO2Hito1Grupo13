package negocio;

import java.util.List;

import dao.PedidoDao;
import datos.Pedido;

public class PedidoABM {
	private static PedidoABM abm = null;
	private PedidoDao dao = PedidoDao.getInstancia();

	private PedidoABM() {}

	public static PedidoABM getInstancia() {
		if (abm == null) {
			abm = new PedidoABM();
		}
		return abm;
	}

	public int agregar(Pedido p) {
		return dao.agregar(p);
	}

	public void modificar(Pedido p) {
		dao.actualizar(p);
	}

	public Pedido traer(long idPedido) {
		return dao.traer(idPedido);
	}

	public List<Pedido> traer() {
		return dao.traer();
	}
	
	public List<Object[]> traerTopPlatosPorFestival(long idFestival, int cant){
		return dao.traerTopPlatosPorFestival(idFestival, cant);
	}; 
}

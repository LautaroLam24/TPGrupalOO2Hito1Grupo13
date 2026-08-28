package datos;

public class ItemPedido {

	private long id;
	private Pedido pedido; // muchos a uno
	private Plato plato;   // muchos a uno
	private int cantidad;

	public ItemPedido() {}

	public ItemPedido(Pedido pedido, Plato plato, int cantidad) {
		this.pedido = pedido;
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", plato=" + plato + ", cantidad=" + cantidad + "]";
	}
}

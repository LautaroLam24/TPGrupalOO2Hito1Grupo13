package datos;

public class ItemPedido {

	private long id;
	private String nombre;
	private Pedido pedido;
	private Plato plato;  
	private int cantidad;

	public ItemPedido() {}

	public ItemPedido(String nombre, Pedido pedido, Plato plato, int cantidad) {
		this.nombre = nombre;
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
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "ItemPedido [id=" + id + ", nombre=" + nombre + ", plato=" + plato + ", cantidad=" + cantidad + "]";
	}
}

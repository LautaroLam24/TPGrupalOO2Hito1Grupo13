package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Pedido {

	private int id;
	private LocalDate fechaTransaccion;
	private Festival festival;
	private UnidadDeVenta unidad;
	private Set<ItemPedido> items = new HashSet<>();

	public Pedido() {}

	public Pedido(LocalDate fechaTransaccion, Festival festival, UnidadDeVenta unidad) {
		this.fechaTransaccion = fechaTransaccion;
		this.festival = festival;
		this.unidad = unidad;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public UnidadDeVenta getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadDeVenta unidad) {
		this.unidad = unidad;
	}

	public Set<ItemPedido> getItems() {
		return items;
	}

	public void setItems(Set<ItemPedido> items) {
		this.items = items;
	}

	public boolean agregarItem(Plato plato, int cantidad) {
		return items.add(new ItemPedido(this, plato, cantidad));
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fechaTransaccion=" + fechaTransaccion + "]";
	}
}
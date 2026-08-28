package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {

	private long id;
	private LocalDate fechaTransaccion;
	private Festival festival;         // muchos a uno
	private UnidadDeVenta unidad;      // muchos a uno
	private Set<ItemPedido> items;     // uno a muchos

	public Pedido() {}

	public Pedido(LocalDate fechaTransaccion, Festival festival, UnidadDeVenta unidad) {
		this.fechaTransaccion = fechaTransaccion;
		this.festival = festival;
		this.unidad = unidad;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
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

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fechaTransaccion=" + fechaTransaccion + "]";
	}
}

package datos;

import java.math.BigDecimal;
import java.util.Objects;

public class Plato {

	private long id;
	private String nombre;
	private BigDecimal precioVenta;
	private BigDecimal costoProduccion;
	private UnidadDeVenta unidad; // muchos a uno: el plato pertenece a una unidad

	public Plato() {}

	public Plato(String nombre, BigDecimal precioVenta, BigDecimal costoProduccion, UnidadDeVenta unidad) {
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.costoProduccion = costoProduccion;
		this.unidad = unidad;
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

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public BigDecimal getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(BigDecimal costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	public UnidadDeVenta getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadDeVenta unidad) {
		this.unidad = unidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Plato other = (Plato) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Plato [id=" + id + ", nombre=" + nombre + ", precioVenta=" + precioVenta
				+ ", costoProduccion=" + costoProduccion + "]";
	}
}

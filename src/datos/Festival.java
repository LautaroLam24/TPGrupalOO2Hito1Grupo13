package datos;

import java.time.LocalDate;
import java.util.Set;

public class Festival {

	private long id;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private float costoPorSuperficie;
	private float costoPorMontaje;
	private float plusElectricidad;
	private float sueldoBase;
	private Set<UnidadDeVenta> unidades;

	public Festival() {}

	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
			float costoPorSuperficie, float costoPorMontaje, float plusElectricidad,
			float sueldoBase) {
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costoPorSuperficie = costoPorSuperficie;
		this.costoPorMontaje = costoPorMontaje;
		this.plusElectricidad = plusElectricidad;
		this.sueldoBase = sueldoBase;
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

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public float getCostoPorSuperficie() {
		return costoPorSuperficie;
	}

	public void setCostoPorSuperficie(float costoPorSuperficie) {
		this.costoPorSuperficie = costoPorSuperficie;
	}

	public float getCostoPorMontaje() {
		return costoPorMontaje;
	}

	public void setCostoPorMontaje(float costoPorMontaje) {
		this.costoPorMontaje = costoPorMontaje;
	}

	public float getPlusElectricidad() {
		return plusElectricidad;
	}

	public void setPlusElectricidad(float plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public Set<UnidadDeVenta> getUnidades() {
		return unidades;
	}

	public void setUnidades(Set<UnidadDeVenta> unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "Festival [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
}

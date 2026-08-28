package datos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class Festival {

	private long id;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private BigDecimal costoPorSuperficie;
	private BigDecimal costoPorMontaje;
	private BigDecimal plusElectricidad;
	private BigDecimal sueldoBase;
	private Set<UnidadDeVenta> unidades;

	public Festival() {}

	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
			BigDecimal costoPorSuperficie, BigDecimal costoPorMontaje, BigDecimal plusElectricidad,
			BigDecimal sueldoBase) {
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

	public BigDecimal getCostoPorSuperficie() {
		return costoPorSuperficie;
	}

	public void setCostoPorSuperficie(BigDecimal costoPorSuperficie) {
		this.costoPorSuperficie = costoPorSuperficie;
	}

	public BigDecimal getCostoPorMontaje() {
		return costoPorMontaje;
	}

	public void setCostoPorMontaje(BigDecimal costoPorMontaje) {
		this.costoPorMontaje = costoPorMontaje;
	}

	public BigDecimal getPlusElectricidad() {
		return plusElectricidad;
	}

	public void setPlusElectricidad(BigDecimal plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}

	public BigDecimal getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(BigDecimal sueldoBase) {
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

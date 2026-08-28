package datos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public abstract class Personal {

	protected long id;
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected LocalDate fechaNacimiento;
	protected LocalDate fechaIngreso; 
	protected BigDecimal sueldoBase;
	protected Set<UnidadDeVenta> unidades;

	public Personal() {}

	public Personal(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, BigDecimal sueldoBase) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Personal other = (Personal) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaIngreso=" + fechaIngreso + ", sueldoBase=" + sueldoBase;
	}
}

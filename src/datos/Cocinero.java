package datos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cocinero extends Personal {

	private String especialidad;
	private BigDecimal plusPorCategoria;

	public Cocinero() {}

	public Cocinero(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, BigDecimal sueldoBase, String especialidad, BigDecimal plusPorCategoria) {
		super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
		this.especialidad = especialidad;
		this.plusPorCategoria = plusPorCategoria;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public BigDecimal getPlusPorCategoria() {
		return plusPorCategoria;
	}

	public void setPlusPorCategoria(BigDecimal plusPorCategoria) {
		this.plusPorCategoria = plusPorCategoria;
	}

	@Override
	public String toString() {
		return "Cocinero [" + super.toString() + ", especialidad=" + especialidad
				+ ", plusPorCategoria=" + plusPorCategoria + "]";
	}
}

package datos;

import java.time.LocalDate;

public class Cocinero extends Personal {

	private String especialidad;
	private float plusPorCategoria;

	public Cocinero() {}

	public Cocinero(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, float sueldoBase, String especialidad, float plusPorCategoria) {
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

	public float getPlusPorCategoria() {
		return plusPorCategoria;
	}

	public void setPlusPorCategoria(float plusPorCategoria) {
		this.plusPorCategoria = plusPorCategoria;
	}

	@Override
	public String toString() {
		return "Cocinero [" + super.toString() + ", especialidad=" + especialidad
				+ ", plusPorCategoria=" + plusPorCategoria + "]";
	}
}
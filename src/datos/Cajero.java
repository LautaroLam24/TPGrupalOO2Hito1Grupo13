package datos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cajero extends Personal {

	private String turno; 

	public Cajero() {}

	public Cajero(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, BigDecimal sueldoBase, String turno) {
		super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Cajero [" + super.toString() + ", turno=" + turno + "]";
	}
}

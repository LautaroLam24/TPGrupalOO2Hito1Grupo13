package datos;

import java.math.BigDecimal;
import datos.Festival;

public class FoodTruck extends UnidadDeVenta {

	private String patente;
	private boolean requiereConexionElectrica;

	public FoodTruck() {}

	public FoodTruck(String nombreComercial, String codigo, BigDecimal superficieM2,
			Festival festival, Personal responsable, String patente, boolean requiereConexionElectrica) {
		super(nombreComercial, codigo, superficieM2, festival, responsable);
		this.patente = patente;
		this.requiereConexionElectrica = requiereConexionElectrica;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public boolean isRequiereConexionElectrica() {
		return requiereConexionElectrica;
	}

	public void setRequiereConexionElectrica(boolean requiereConexionElectrica) {
		this.requiereConexionElectrica = requiereConexionElectrica;
	}

	@Override
	public String toString() {
		return "FoodTruck [" + super.toString() + ", patente=" + patente
				+ ", requiereConexionElectrica=" + requiereConexionElectrica + "]";
	}
}

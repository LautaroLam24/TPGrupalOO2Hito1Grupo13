package datos;

import java.math.BigDecimal;

public class PuestoDesarmable extends UnidadDeVenta {

	private int cantidadCarpas;
	private int tiempoMontajeMinutos;

	public PuestoDesarmable() {}

	public PuestoDesarmable(String nombreComercial, String codigo, BigDecimal superficieM2,
			Festival festival, Personal responsable, int cantidadCarpas, int tiempoMontajeMinutos) {
		super(nombreComercial, codigo, superficieM2, festival, responsable);
		this.cantidadCarpas = cantidadCarpas;
		this.tiempoMontajeMinutos = tiempoMontajeMinutos;
	}

	public int getCantidadCarpas() {
		return cantidadCarpas;
	}

	public void setCantidadCarpas(int cantidadCarpas) {
		this.cantidadCarpas = cantidadCarpas;
	}

	public int getTiempoMontajeMinutos() {
		return tiempoMontajeMinutos;
	}

	public void setTiempoMontajeMinutos(int tiempoMontajeMinutos) {
		this.tiempoMontajeMinutos = tiempoMontajeMinutos;
	}

	@Override
	public String toString() {
		return "PuestoDesarmable [" + super.toString() + ", cantidadCarpas=" + cantidadCarpas
				+ ", tiempoMontajeMinutos=" + tiempoMontajeMinutos + "]";
	}
}

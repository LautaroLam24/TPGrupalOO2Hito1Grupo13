package dto;

import datos.Plato;

public class PlatoVendidoDTO {
	private long idPlato;
    private String nombrePlato;
    private double precioVenta;
    private long cantidadVendida;

    public PlatoVendidoDTO() {}

    public PlatoVendidoDTO(int idPlato, String nombrePlato, float precioVenta, long cantidadVendida) {
        this.idPlato = idPlato;
        this.nombrePlato = nombrePlato;
        this.precioVenta = precioVenta;
        this.cantidadVendida = cantidadVendida;
    }

    public long getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(long idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public long getCantidadVendida() {
        return cantidadVendida;
    }

    @Override
    public String toString() {
        return "Plato: " + nombrePlato + " | Vendidos: " + cantidadVendida + " | Precio: $" + precioVenta;
    }
}

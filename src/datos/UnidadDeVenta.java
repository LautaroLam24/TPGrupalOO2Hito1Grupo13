package datos;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public abstract class UnidadDeVenta {

	protected long id;
	protected String nombreComercial;
	protected String codigo;          
	protected BigDecimal superficieM2;
	protected Festival festival;      
	protected Personal responsable;  
	protected Set<Plato> platos;      
	protected Set<Personal> staff;    

	public UnidadDeVenta() {}

	public UnidadDeVenta(String nombreComercial, String codigo, BigDecimal superficieM2,
			Festival festival, Personal responsable) {
		this.nombreComercial = nombreComercial;
		this.codigo = codigo;
		this.superficieM2 = superficieM2;
		this.festival = festival;
		this.responsable = responsable;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getSuperficieM2() {
		return superficieM2;
	}

	public void setSuperficieM2(BigDecimal superficieM2) {
		this.superficieM2 = superficieM2;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Personal getResponsable() {
		return responsable;
	}

	public void setResponsable(Personal responsable) {
		this.responsable = responsable;
	}

	public Set<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(Set<Plato> platos) {
		this.platos = platos;
	}

	public Set<Personal> getStaff() {
		return staff;
	}

	public void setStaff(Set<Personal> staff) {
		this.staff = staff;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		UnidadDeVenta other = (UnidadDeVenta) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nombreComercial=" + nombreComercial + ", codigo=" + codigo
				+ ", superficieM2=" + superficieM2;
	}
}

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TBL_PRODUCTOCL3")
@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPRODUCTOSCL3")
	private Integer idProducto;
	@Column(name = "NOMBRECL3")
	private String nomProd;
	@Column(name = "PRECIOVENTACL3")
	private Double preVent;
	@Column(name = "PRECIOCOMPCL3")
	private Double preComp;
	@Column(name = "ESTADOCL3")
	private String estado;
	@Column(name = "DESCRIPCL3")
	private String descripcion;
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public Double getPreVent() {
		return preVent;
	}
	public void setPreVent(Double preVent) {
		this.preVent = preVent;
	}
	public Double getPreComp() {
		return preComp;
	}
	public void setPreComp(Double preComp) {
		this.preComp = preComp;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

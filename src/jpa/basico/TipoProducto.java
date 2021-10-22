package jpa.basico;

import javax.persistence.*;

@Entity
@Table(name="producto")
public class Producto {
	//creamos sus respectivos atributos...
	//declaramos la variable idProducto llave primaria ... y autoincrementable
	@Id
	@Column(name="idProducto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProducto;
	
	@Column(name="precioCompra")
	private double precioCompra;
	
	@Column(name="precioVenta")
	private double precioVenta;
	
	//@ManyToMany(mappedBy="productos")
	
	public Producto()
	{
		
	}
	
	public Producto(double precioCompra, double precioVenta) {
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	public Producto(int idProducto, double precioCompra, double precioVenta) {
		this.idProducto = idProducto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	
}

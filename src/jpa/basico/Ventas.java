package jpa.basico;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="venta")
public class Ventas {

	//creamos sus respectivos atributos 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idVenta;
	@Column(name = "importe")
	 private double importe;
	@Column(name="fecha")
	 private Date fecha;
	
	@JoinTable
	(
			name="rel_venta_producto",
			joinColumns = @JoinColumn(name="FK_VENTA"),
			inverseJoinColumns = @JoinColumn(name="FK_PRODUCTO")
	)
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Producto> productos;
	
}

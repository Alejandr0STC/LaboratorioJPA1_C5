package jpa.basico;

import javax.persistence.*;

@Entity
@Table(name="departamento")

public class Departamento 
{
	
	//sus atributos 
	
	//anotaciones para su respectiva llave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartamento;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;
	
	public Departamento()
	{
	}//fin de constructor con 0 parametros
	public Departamento(int idDepartamento, String nombre, String descripcion) 
	{
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}//fin de constructor con 3 parametros
	public Departamento(String nombre, String descripcion) 
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
	}//fin de constructor con 2 parametros

	//creamos sus metodos getters y setters
	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
//fin de la clase departamento 
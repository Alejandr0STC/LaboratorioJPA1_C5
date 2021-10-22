package jpa.basico;

import javax.persistence.*;

@Entity
@Table(name = "Empleado")
public class Empleado 
{
	//creamos sus atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "sueldo")
	private double sueldo;
	
	//muchos a uno
	//joincolumn es posible para realizar las uniones con otras tablas
	@ManyToOne
	@JoinColumn(name = "departamneto")
	private Departamento departamento;
	
	public Empleado() 
	{
		
	}
	public Empleado( String nombre, String apellido, String sexo, String dni, String email,
			String telefono, double sueldo, Departamento departamento) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.sueldo = sueldo;
		this.departamento = departamento;
	}
	public Empleado(int idEmpleado, String nombre, String apellido, String sexo, String dni, String email,
			String telefono, double sueldo, Departamento departamento) 
	{
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.sueldo = sueldo;
		this.departamento = departamento;
	}
	
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
}//fin de clase empleado 

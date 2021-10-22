package jpa.basico;

import javax.persistence.*;

@Entity
@Table(name="Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdCliente")
	private int idcliente;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Apellido")
	private String apellido;
	@Column(name="Sexo")
	private String sexo;
	@Column(name="Telefono")
	private String telefono;
	@Column(name="Email")
	private String email;
	@Column(name="DNI")
	private String dni;
	
	
	
	public Cliente( String nombre, String apellido, String sexo, String telefono, String email,
			String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
	}
	public Cliente() {
	}
	
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}

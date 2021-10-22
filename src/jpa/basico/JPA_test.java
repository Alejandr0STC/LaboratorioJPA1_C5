package jpa.basico;

import java.util.List;

import javax.persistence.*;


public class JPA_test 
{
	private EntityManager manager;
	
	
	public JPA_test(EntityManager manager) 
	{
		this.manager=manager;
	}
	public static void main(String[] args)
	{
		//comenzamos a testear los respectivos metodos
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("semana_1");
		EntityManager manager= factory.createEntityManager();
		
		//instanciamos la misma clase JPA_Test
		JPA_test jpatest = new JPA_test(manager);
		EntityTransaction tx = manager.getTransaction();
		
		//iniciamos la transaccion...
		tx.begin();
		
		//llamamos al metodo CrearEmpleado
		jpatest.CrearEmpleado();
		
		//llamamos al metodo listar empleado
		List<Empleado> verList = jpatest.MostrarEmpleado();
		//creamos un bucle realizar la respectiva impresion de los empleado
		System.out.println("*********Listado de Empleado con JPQL*********");
		for(Empleado emp:verList) 
		{
			//imprimimos por pantalla... con systen
			System.out.println(
					" Nombre :" + emp.getNombre() +
					" Apellido :" + emp.getApellido() + " Sexo :" + emp.getSexo() +
					" DNI :" + emp.getDni() + " Email : " + emp.getEmail()
					);
		}
		//imprimimos empleado por codigo
		System.out.println("*********mostramos empleado por codigo*********");
		List<Empleado> buscarEmpleado = jpatest.BuscarEmpleado(4);
		//aplicamos bucle
		for(Empleado emp:buscarEmpleado) 
		{
			System.out.println(
			" Nombre :" + emp.getNombre() +
			" Apellido :" + emp.getApellido() + " Sexo :" + emp.getSexo() +
			" DNI :" + emp.getDni() + " Email : " + emp.getEmail()
					);
		}
		System.out.println("*********Comprobamos Actualizar Empleado*********");
		
		jpatest.ActualizarEmpleado(4, "Abby", "Rosenberg", "Masculino", "78945635", "Abyy2@gmail.com", "91236548", 850.00, 2);
		
		
		System.out.println("*********Comprobamos Eliminar Empleado*********");
		
		jpatest.EliminarEmpleado(4);
		
		System.out.println("*********llamamos al metodo insertar cliente*********");
		
		jpatest.InsertCliente();
		
		
		
		System.out.println("*********llamamos al metodo listar cliente*********");
		
		List<Cliente> implista=jpatest.ListarClientes();
		
		System.out.println("*********Listamos Cliente*********");
		for(Cliente list:implista) 
		{
			System.out.println(list.getNombre()+" | "+list.getApellido()+" | "+list.getSexo()+" | "+list.getTelefono()+" | "+list.getEmail()+" | "+list.getDni());
		}
		System.out.println("*********Actualizamos Cliente *********");
		
		jpatest.ActulizarCliente(4, "Kely", "Palomino", "F", "910911665", "Quelily@hotmail.com", "04563548");		//tx.commit();
		
		
	}//fin del metodo principal
	
	//crear un metodo para generar empleado...
	public void CrearEmpleado() 
	{
		//instanciar la clase de departamento...
		Departamento departamento = new Departamento("Administracion","Parte fundamental de la empresa");
		Departamento departamento2 = new Departamento("Sistemas","Parte Tegnologica de la empresa");
		Departamento departamento3 = new Departamento("Contabilidad","Encargado de la sunat con la empresa");
		Departamento departamento4 = new Departamento("Almacen","Encargado de la logistica de la empresa");
		
		//el metodo persis permite almacenar valores en la BD mySQL...
		manager.persist(departamento);
		manager.persist(departamento2);
		manager.persist(departamento3);
		manager.persist(departamento4);
	
		//instancia la clase empleado
		Empleado empleado = new Empleado("Jesus", "Barreta","Masculino", "77889965", "JesusB@hotmail.com", "9169165936", 5950.00,departamento );
		Empleado empleado2 = new Empleado("Maria", "Sanchez","Femenino", "73568936", "SanchezMaria@hotmail.com", "935594354", 3050.00,departamento2 );
		Empleado empleado3 = new Empleado("Jose", "Cortes","Masculino", "35449565", "joselito_1300@hotmail.com", "965324489", 1850.00,departamento3 );
		Empleado empleado4 = new Empleado("Juan", "Barco","Masculino", "12696874", "JuanBarcoXD@hotmail.com", "935487495", 1250.00,departamento4 );
		
		manager.persist(empleado);
		manager.persist(empleado2);
		manager.persist(empleado3);
		manager.persist(empleado4);
	}
	//Consulta dinamica de JPQL
	//Crear un metodo lista empleados
	
	public List<Empleado> MostrarEmpleado()
	{
		//declaramos una variable
		//recuperar datos de la base de datos
		String consulta="select e from Empleado e";
		
		//aplicamos la interfaz query
		Query listado=manager.createQuery(consulta,Empleado.class);
		
		//almacenamos esos valores en la variable listadoEmpleado
		List<Empleado> listadoEmpleado=listado.getResultList();
		
		//retornamos listadoEmpleado
		return listadoEmpleado;
	}
	//crear metodo buscar empleado por codigo...
	public List<Empleado> BuscarEmpleado(int cod) 
	{
		//declaramos una variable de tipo cadena 
		//paramaetros dinamicos por nombre...sintaxis:nombre...
		String buscar="select e from Empleado e where e.idEmpleado=:codigo";
		
		//aplicamos interfaz query
		Query buscarEmpleado=manager.createQuery(buscar,Empleado.class).setParameter("codigo", cod);
		
		
		List<Empleado> listEmple=buscarEmpleado.getResultList();
		//retornamos el valor mostrado 
		return listEmple;
	}
	//crear el metodo actualizar empleado
	public void ActualizarEmpleado(int cod,String nom,String ape,
			String sex,String dni, String email,String tel,double sue,int codepa) 
	{
		String cadena="update Empleado e set e.nombre=:nom,e.apellido=:ape,e.sexo=:sex,"
				+ "e.dni=:dni,e.email=:email,e.telefono=:tel,e.sueldo=:sue,e.departamento.idDepartamento=:codepa"
				+ " where e.idEmpleado=:cod";
		
		Query consulta = manager.createQuery(cadena);
		consulta.setParameter("nom",nom );
		consulta.setParameter("ape",ape );
		consulta.setParameter("sex",sex );
		consulta.setParameter("dni",dni );
		consulta.setParameter("email",email );
		consulta.setParameter("tel",tel );
		consulta.setParameter("sue",sue );
		consulta.setParameter("codepa",codepa );
		consulta.setParameter("cod",cod );
		int num= consulta.executeUpdate();
		if (num>0)
		{
			System.out.println("Empleado actualizado correctamente");
		}
		else 
		{
			System.out.println("Empleado NO Actualizado");
		}
	}
	public void EliminarEmpleado(int cod) 
	{
		String cadena="delete from Empleado e where e.idEmpleado=:codEmple";
		Query eliminarEmple = manager.createQuery(cadena);
		eliminarEmple.setParameter("codEmple", cod);
		int n =eliminarEmple.executeUpdate();
		if (n>0) 
		{
			System.out.println("Empleado eliminado de la BD");
		}
		else 
		{
			System.out.println("No se puede eliminar el Empleado");
		}
	}
	public void InsertCliente()
	{
		Cliente cliente1 = new Cliente("Rodrigo","Minaya","M","987654789","rodrim2999@hotmail.com","75315964");
		Cliente cliente2 = new Cliente("Alejo","Canci","M","951684325","alejoj200@hotmail.com","45865237");
		Cliente cliente3 = new Cliente("Carmen","Cansin","F","957668435","carmensitatupascion@hotmail.com","35759465");
		Cliente cliente4 = new Cliente("Sara","Loves","F","986356125","Saraloves@hotmail.com","35468921");
		Cliente cliente5 = new Cliente("Alexis","Texas","F","984684356","alexistex@hotmail.com","68438597");
		
		manager.persist(cliente5);
		manager.persist(cliente4);
		manager.persist(cliente3);
		manager.persist(cliente2);
		manager.persist(cliente1);
	}
	public List<Cliente> ListarClientes() 
	{
		String cadena ="select c from Cliente c";
		Query queryConsul = manager.createQuery(cadena,Cliente.class);
		List<Cliente> listado = queryConsul.getResultList();
		return listado;
	}
	public void ActulizarCliente(int cod,String nombre,String apellido, String sexo,String telefono,String email,String dni) 
	{
		String cadena="update Cliente c set c.nombre=:nombre,c.apellido=:apellido,c.sexo=:sexo,c.telefono=:telefono,c.email=:email,c.dni=:dni where c.idcliente=:cod";
		Query queryActu = manager.createQuery(cadena);
		queryActu.setParameter("cod", cod);
		queryActu.setParameter("nombre",nombre );
		queryActu.setParameter("apellido",apellido );
		queryActu.setParameter("sexo",sexo );
		queryActu.setParameter("telefono",telefono );
		queryActu.setParameter("email",email );
		queryActu.setParameter("dni",dni );
		int x = queryActu.executeUpdate();
		if(x>0)
		{
			System.out.println("Cliente actualizado correctamemnte");
		}
		else
		{
			System.out.println("Cliente no actualizado en la Base de Datos");
		}
	}
}

package clases;
/**
 * 
 * @author Zeque
 * @class Restaurante
 * @param
 * nombre
 * nombre del restaurante
 * @param
 * direccion
 * direccion del local 
 *
 */


public class Restaurante {
	
	
	private String nombre;
	private String direccion;
	private BaseDatosAL<Mozo>listadoDeMozos;
	private BaseDatosHM<Integer,Mesa>listadoDeMesas;
	private BaseDatosHM<Integer,Producto>listadoDeProductos;
	private BaseDatosAL<Cuenta>cuentasActivas;
	private BaseDatosAL<Cuenta>historialDeCuentas;
	
	public Restaurante(String nombre, String direccion){
		setDireccion(direccion);
		setNombre(nombre);
		listadoDeMozos = new BaseDatosAL<Mozo>();
		listadoDeMesas = new BaseDatosHM<Integer, Mesa>();
		listadoDeProductos = new BaseDatosHM<Integer, Producto>();
		cuentasActivas = new BaseDatosAL<Cuenta>();
		historialDeCuentas = new BaseDatosAL<Cuenta>();
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

	/*public double devolverTotal()
	{
		double total = 0;
		
	}*/
	
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	///////////////////	CUENTA	//////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	
/*	public boolean crearCuenta(Cuenta c)
	{
		boolean flag = false;
		if(listadoDeMesas.existe(c))
			if(!listadoDeMesas.buscar(nroMesa).isOcupadoONO())
			{
				flag = true;
				Cuenta cuenta = new Cuenta(nroMozo,nroMesa);
				cuentasActivas.agregar(cuenta);
				listadoDeMesas.buscar(nroMesa).setOcupadoONO(true);
			}
			return flag;
			
	}*/
	
	public boolean agregarCuentaActiva (Cuenta c){
		boolean flag=false;
		if(listadoDeMesas.existe(c.getIdMesa())){
			if(!listadoDeMesas.buscar(c.getIdMesa()).isOcupadoONO()){
				cuentasActivas.agregar(c);
				listadoDeMesas.buscar(c.getIdMesa()).ocuparMesa();;
			}
		}
		return flag;
	}
	
	public boolean eliminarCuentaActiva (Cuenta c){
		boolean flag=false;
		if(listadoDeMesas.existe(c.getIdMesa())){
			if(listadoDeMesas.buscar(c.getIdMesa()).isOcupadoONO()){
				cuentasActivas.borrar(c);
				listadoDeMesas.buscar(c.getIdMesa()).desocuparMesa();
			}
		}
		return flag;
	}
	

	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	/////////////////	MOZOS	//////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	
	public boolean agregarMozo(Mozo m){
		boolean flag=false;
		if(!listadoDeMozos.existe(m)){
			listadoDeMozos.agregar(m);
			flag=true;
		}
		return flag;
	}
	public boolean eliminarMozo(Mozo m){
		boolean flag=false;
		if(listadoDeMozos.existe(m)){
			listadoDeMozos.borrar(m);
			flag=true;
		}
		return flag;
	}
	
	
	public String listarMozos(){
		return listadoDeMozos.listar();
	}
	
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	//////////////////// MESAS	//////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	
	public String listarMesas(){
		String listarmesas;
		listarmesas=listadoDeMesas.listar();
		return listarmesas;
	}
	
	public boolean agregarMesa (Mesa m){
		boolean flag=false;
		if(!listadoDeMesas.existe(m.getNumeroDeMesa())){
			listadoDeMesas.agregar(m.getNumeroDeMesa(), m);
			flag=true;
		}
		return flag;
	}
	public boolean eliminarMesa (Mesa m){
		boolean flag=false;
		if(listadoDeMesas.existe(m.getNumeroDeMesa())){
			listadoDeMesas.borrar(m.getNumeroDeMesa());
			flag=true;
		}
		return flag;
	}
	
	
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	///////////////////	PRUDUCTOS	//////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	public String listarProductos(){
		String listarproductos;
		listarproductos=listadoDeProductos.listar();
		return listarproductos;
	}
	
	
@Override
	public String toString() {
		
		return "El establecimiento es :" + getNombre()+ " y se encuenta en : "+getDireccion()+" \r\n Vengan con su familia Los Esperamos";
	}
}

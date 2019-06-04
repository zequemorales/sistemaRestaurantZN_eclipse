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
	
	public double devolverTotal()
	{
		double total = 0;
		
	}
	
	public boolean crearCuenta(int nroMesa, int nroMozo)
	{
		boolean flag = false;
		if(listadoDeMesas.existe(nroMesa))
			if(!listadoDeMesas.buscar(nroMesa).isOcupadoONO())
			{
				flag = true;
				Cuenta cuenta = new Cuenta(nroMozo,nroMesa);
				cuentasActivas.agregar(cuenta);
				listadoDeMesas.buscar(nroMesa).setOcupadoONO(true);
				
			}
			return flag;
			
			
			
	}
	
	@Override
	public String toString() {
		
		return "El establecimiento es :" + getNombre()+ " y se encuenta en : "+getDireccion()+" \r\n Vengan con su familia Los Esperamos";
	}
}
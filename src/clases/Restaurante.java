package clases;

/**
 * Clase Restaurante
 * 
 * @author Zeque
 * 
 * @param nombre
 *            nombre del restaurante
 * @param direccion
 *            direccion del local
 * 
 * @param listadoDeMozos
 *            Base de datos de tipo ArrayList con los mozos cargados en el
 *            sitema. Almacena objetos de tipo Mozo.
 * @param listadoDeMesas
 *            Base de datos de tipo HashMap con las mesas cargadas en el sitema.
 *            Almacena obejtos de tipo Mesa, con su ID para identificarlas.
 * @param listadoDeProductos
 *            Base de datos de tipo HashMap con los productos cargados en el
 *            sitema. Almacena objetos de tipo Producto, con su Id para
 *            identificarlos.
 * @param cuentasActivas
 *            Base de datos de tipo ArrayList, con las Cuentas que se encuentran
 *            ABIERTAS en el sitema. Siempre que se crean se guardan en esta
 *            lista.
 * @param historialDeCuentas
 *            Base de datos de tipo ArrayList, con las cuentas que se encuentrar
 *            cerradas, una vez que se cobra la cuenta, se elimina de
 *            CuentasActivas y se almacenan en Historial Cuentas
 *
 * 
 */

public class Restaurante {

	private String nombre;
	private String direccion;
	private BaseDatosAL<Mozo> listadoDeMozos;
	private BaseDatosHM<Integer, Mesa> listadoDeMesas;
	private BaseDatosHM<Integer, Producto> listadoDeProductos;
	private BaseDatosAL<Cuenta> cuentasActivas;
	private BaseDatosAL<Cuenta> historialDeCuentas;

	public Restaurante(String nombre, String direccion) {
		setDireccion(direccion);
		setNombre(nombre);
		listadoDeMozos = new BaseDatosAL<Mozo>();
		listadoDeMesas = new BaseDatosHM<Integer, Mesa>();
		listadoDeProductos = new BaseDatosHM<Integer, Producto>();
		cuentasActivas = new BaseDatosAL<Cuenta>();
		historialDeCuentas = new BaseDatosAL<Cuenta>();

	}

	/**
	 * Obtiene el nombre del Restaurante
	 * @return String con el nombre del restaurante
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setea el nombre del Restaurante
	 * @param nombre
	 * Recibie el nombre a setear
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la direccion del Restaurante
	 * @return String con la direccion del Restaurante
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Setea la direccion del Restaurante
	 * @param direccion
	 * Recibe la direccion a setear
	 */

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	/////////////////// CUENTA //////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////

	/**
	 * crearCuentaActiva
	 * 
	 * Metodo que crea una cuenta y la agrega al listado de cuentas activas
	 * 
	 * @param idMozo
	 *            el Mozo pone su id,
	 * @param idMesa
	 *            y el numero de mesa en la que abre la cuenta
	 * @return true si se crea correctamente. Y false si no se pudo agregar
	 */

	public boolean crearCuentaActiva(int idMozo, int idMesa) {
		Cuenta c = new Cuenta(idMozo, idMesa);

		boolean flag = false;
		if (listadoDeMesas.existe(c.getIdMesa())) {
			if (!listadoDeMesas.buscar(c.getIdMesa()).isOcupadoONO()) {
				cuentasActivas.agregar(c);
				listadoDeMesas.buscar(c.getIdMesa()).ocuparMesa();
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * Elimina de la lista cuentaAtivas y la guarda en HistorialdeCuentas. 
	 * @param idMesa Id de la mesa a borrar.
	 * @return true si se elimino correctamente. False si no se elimino o hubo algun error.
	 * 
	 */
	public boolean eliminarCuentaActiva(int idMesa) {
		boolean flag = false;
		
		
		
		for(int i=0;i<cuentasActivas.tamanioLista();i++){
			//busca la mesa a eliminar
			if(cuentasActivas.getindice(i).getIdMesa()==idMesa){
				
				creaCuentaEnHistorialCuentas(idMesa);
				listadoDeMesas.buscar(idMesa).desocuparMesa();
				cuentasActivas.borrar(cuentasActivas.getindice(i));
				flag=true;
			}
		}
		return flag;
	}
	
	/**
	 * Agrega una cuenta en histotial de cuentas.
	 * @param idMesa
	 * @return
	 */
	public boolean creaCuentaEnHistorialCuentas(int idMesa){
		boolean flag=false;
	
		if(historialDeCuentas.agregar(devuelveCuenta(idMesa))){
			
			flag=true;
		}
		return flag;
		
	}
	public String listarCuentasActivas(){
		return cuentasActivas.listar();
	}
	public String listarHistorialCuentas(){
		return historialDeCuentas.listar();
	}
	public Cuenta devuelveCuenta(int idMesa){
		Cuenta copia=new Cuenta(0, 0);
		
		for(int i=0;i<cuentasActivas.tamanioLista();i++){
			if(cuentasActivas.getindice(i).getIdMesa()==idMesa){
				copia=cuentasActivas.getindice(i);
			}
		}
		
		return copia;
	}
	


	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	///////////////////// MOZOS //////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////

	public boolean crearMozo(String nombre, String apellido, int idMozo) {
		Mozo m = new Mozo(nombre, apellido, idMozo);
		boolean flag = false;
		if (!listadoDeMozos.existe(m)) {
			listadoDeMozos.agregar(m);
			flag = true;
		}
		return flag;
	}

	public boolean eliminarMozo(Mozo m) {
		boolean flag = false;
		if (listadoDeMozos.existe(m)) {
			listadoDeMozos.borrar(m);
			flag = true;
		}
		return flag;
	}

	public String listarMozos() {
		return listadoDeMozos.listar();
	}

	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	//////////////////// MESAS //////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////

	public String listarMesas() {
		
		return listadoDeMesas.listar();
	}

	public boolean agregarMesa(Mesa m) {
		boolean flag = false;
		if (!listadoDeMesas.existe(m.getNumeroDeMesa())) {
			listadoDeMesas.agregar(m.getNumeroDeMesa(), m);
			flag = true;
		}
		return flag;
	}

	public boolean eliminarMesa(Mesa m) {
		boolean flag = false;
		if (listadoDeMesas.existe(m.getNumeroDeMesa())) {
			listadoDeMesas.borrar(m.getNumeroDeMesa());
			flag = true;
		}
		return flag;
	}
	
	public Mesa devuelveMesa(int idMesa){
		return listadoDeMesas.buscar((Integer)idMesa);
	}

	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	/////////////////// PRUDUCTOS //////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	public String listarProductos() {
		
		return listadoDeProductos.listar();
	}

	@Override
	public String toString() {

		return "El establecimiento es :" + getNombre() + " y se encuenta en : " + getDireccion()
				+ " \r\n Vengan con su familia Los Esperamos";
	}
}

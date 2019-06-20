package clases;

import java.awt.Component;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import jdk.nashorn.internal.parser.JSONParser;

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
	 * 
	 * @return String con el nombre del restaurante
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setea el nombre del Restaurante
	 * 
	 * @param nombre
	 *            Recibie el nombre a setear
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la direccion del Restaurante
	 * 
	 * @return String con la direccion del Restaurante
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Setea la direccion del Restaurante
	 * 
	 * @param direccion
	 *            Recibe la direccion a setear
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
	 * 
	 * @param idMesa
	 *            Id de la mesa a borrar.
	 * @return true si se elimino correctamente. False si no se elimino o hubo
	 *         algun error.
	 * 
	 */
	public boolean eliminarCuentaActiva(int idMesa) {
		boolean flag = false;

		for (int i = 0; i < cuentasActivas.tamanioLista(); i++) {
			// busca la mesa a eliminar
			if (cuentasActivas.getindice(i).getIdMesa() == idMesa) {

				creaCuentaEnHistorialCuentas(idMesa);
				listadoDeMesas.buscar(idMesa).desocuparMesa();
				cuentasActivas.borrar(cuentasActivas.getindice(i));
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * Agrega una cuenta en histotial de cuentas.
	 * 
	 * @param idMesa
	 * @return true si se creo la cuenta y false si no.
	 */
	public boolean creaCuentaEnHistorialCuentas(int idMesa) {
		boolean flag = false;

		if (historialDeCuentas.agregar(cuentasActivas.getindice(devuelveIndiceCuenta(idMesa)))) {

			flag = true;
		}
		return flag;

	}
	
	//Necesario para pasar de archivos a historial 
	/**
	 * Crea una cuenta en el historial de cuentas
	 * @param cuenta
	 * @return
	 */
	public boolean creaCuentaEnHistorialCuentas(Cuenta cuenta) {
		boolean flag = false;

		if(historialDeCuentas.agregar(cuenta)); 
			flag = true;
		return flag;

	}
	/**
	 * Calcula el total de la cuenta
	 * @param idMesa
	 * @return el total
	 */
	public double calcularTotal(int idMesa) {
		Cuenta cuenta = null;
		double total = 0;
		if (compruebaCuenta(idMesa)) {
			cuenta = devuelveCuenta(idMesa);
			HashMap<Integer, Integer> listaC = cuenta.devolverLista();
			for (HashMap.Entry<Integer, Integer> entry : listaC.entrySet())
				total += (listadoDeProductos.buscar(entry.getKey()).getPrecioProducto()) * entry.getValue();
		}

		return total;
	}
	/**
	 * Producto en cuentas
	 * @param c
	 * @return productos en cuentas
	 */
	public ArrayList devuelveProductosEnCuenta(Cuenta c) {
		ArrayList productosEnCuenta = new ArrayList();
		int i =0;

		HashMap<Integer, Integer> listaC = c.devolverLista();
		for (HashMap.Entry<Integer, Integer> entry : listaC.entrySet()) {
			productosEnCuenta.add(listadoDeProductos.buscar(entry.getKey()));
			i++;
		}
		return productosEnCuenta;
	}
	/**
	 * Calcula importe
	 * @param cantidad
	 * @param precio
	 * @return el resultado de la cantidad x el precio
	 */
	public double calcularImporte(int cantidad, double precio) {
		return cantidad * precio;
	}
	/**
	 * Cuentas Activas
	 * @return devuelve un string con las cuentas activas
	 */
	public String listarCuentasActivas() {
		return cuentasActivas.listar();
	}
	/**
	 * Historial de cuentas
	 * @return devuelve un string con el historial de cuentas
	 */
	public String listarHistorialCuentas() {
		return historialDeCuentas.listar();
	}
	/**
	 * Indice en Cuentas
	 * @param idMesa
	 * @return
	 */
	public int devuelveIndiceCuenta(int idMesa) {
		// Cuenta copia=new Cuenta(0, 0);
		int index = 0;
		for (int i = 0; i < cuentasActivas.tamanioLista(); i++) {
			if (cuentasActivas.getindice(i).getIdMesa() == idMesa) {
				index = i;
			}
		}

		return index;
	}
	/**
	 * Listado de cuentas activas
	 * @return cuentas activas
	 */
	public BaseDatosAL<Cuenta> devuelveListadoCuentasActivas() {
		return cuentasActivas;
	}
	/**
	 * Devuelve cuentas
	 * @param idMesa
	 * @return
	 */
	public Cuenta devuelveCuenta(int idMesa) {
		return cuentasActivas.getindice(devuelveIndiceCuenta(idMesa));
	}
	/**
	 * Devuelve nombre del producto
	 * @param idProducto
	 * @return devuelve un String con nombre del producto
	 */
	public String devuelveNombreProducto(int idProducto) {
		Producto p = null;
		p = listadoDeProductos.buscar(idProducto);
		return p.getNombreProducto();
	}
	/**
	 * Devuelve producto
	 * @param idProducto
	 * @return
	 */
	public Producto devuelveProducto(int idProducto) {

		return listadoDeProductos.buscar(idProducto);

	}
	/**
	 * Comprueba cuenta
	 * @param idMesa
	 * @return
	 */
	public boolean compruebaCuenta(int idMesa) {
		boolean flag = false;
		for (int i = 0; i < cuentasActivas.tamanioLista(); i++) {
			if (cuentasActivas.getindice(i).getIdMesa() == idMesa) {
				flag = true;
			}
		}

		return flag;
	}
	/**
	 * Agrega productos a la cuenta
	 * @param idMesa
	 * @param idProducto
	 * @param cant
	 * @return
	 */
	public boolean agregaProductoAlaCuenta(int idMesa, int idProducto, int cant) {
		boolean flag = false;
		for (int i = 0; i < cuentasActivas.tamanioLista(); i++)
			if (cuentasActivas.getindice(i).getIdMesa() == idMesa) {
				cuentasActivas.getindice(i).ponerEnCuenta(idProducto, cant);
				flag = true;
			}
		return flag;
	}

	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	///////////////////// MOZOS //////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////

	/**
	 * Crear Mozo
	 * @param nombre
	 * @param apellido
	 * @param idMozo
	 * @return true si se agrego y false si no.
	 */
	public boolean crearMozo(String nombre, String apellido, int idMozo) {
		
		boolean flag = false;
		
		if (!compruebaMozo(idMozo)){
			Mozo m = new Mozo(nombre, apellido, idMozo);
			listadoDeMozos.agregar(m);
			flag = true;
		}
		
		return flag;
	}
	/**
	 * Elimimar Mozo
	 * @param m
	 * @return true si lo elimina y false si no.
	 */
	public boolean eliminarMozo(Mozo m) {
		boolean flag = false;
		if (listadoDeMozos.existe(m)) {
			listadoDeMozos.borrar(m);
			flag = true;
		}
		return flag;
	}
	/**
	 * Listar Mozo
	 * @return
	 */
	public String listarMozos() {
		return listadoDeMozos.listar();
	}
	/**
	 * Comprueba si ese mozo ya existe
	 * @param idMozo
	 * @return true si ya existe y false si no.
	 */
	public boolean compruebaMozo(int idMozo) {
		boolean flag = false;
		for (int i = 0; i < listadoDeMozos.tamanioLista(); i++) {
			if (listadoDeMozos.getindice(i).getIdMozo() == idMozo) {
				flag = true;
			}
		}

		return flag;
	}

	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	//////////////////// MESAS //////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////

	/**
	 * Devuelve Mesas
	 * @return mesas
	 */
	public ArrayList devuelveArrayMesas(){
		
		ArrayList mesas = new ArrayList();
		int i =0;

		HashMap<Integer, Mesa> listamesas = listadoDeMesas.devolverLista();
		for (HashMap.Entry<Integer, Mesa> entry : listamesas.entrySet()) {
			mesas.add(listadoDeMesas.buscar(entry.getKey()));
			i++;
		}
		return mesas;
	}
	/**
	 * Lista las mesas del Restaurante
	 * 
	 * @return devuelve un string con las "MESAS".
	 */
	public String listarMesas() {

		return listadoDeMesas.listar();
	}

	/**
	 * Crea y Agrega una mesa al Restaurante.
	 * 
	 * @param nromesa
	 *            Recibe el numero de mesa.
	 * @return devuelve
	 */

	public boolean agregarMesa(int nromesa) {
		Mesa m = new Mesa(nromesa);
		boolean flag = false;
		if (!listadoDeMesas.existe(m.getNumeroDeMesa())) {
			listadoDeMesas.agregar(m.getNumeroDeMesa(), m);
			flag = true;
		}
		return flag;
	}
	/**
	 * Eliminar Mesa
	 * @param m
	 * @return true si lo elimina y false si no.
	 */
	public boolean eliminarMesa(Mesa m) {
		boolean flag = false;
		if (listadoDeMesas.existe(m.getNumeroDeMesa())) {
			listadoDeMesas.borrar(m.getNumeroDeMesa());
			flag = true;
		}
		return flag;
	}
	/**
	 * Devuelve mesa
	 * @param idMesa
	 * @return
	 */
	public Mesa devuelveMesa(int idMesa) {
		return listadoDeMesas.buscar((Integer) idMesa);
	}
	/**
	 * La mesa esta esta ocupada
	 * @param idMesa
	 * @return devueleve si la mesa esta ocupada
	 */
	public boolean mesaIsOcupada(int idMesa) {
		boolean ocupado = false;
		if (listadoDeMesas.existe(idMesa)) {
			ocupado = listadoDeMesas.buscar(idMesa).isOcupadoONO();

		}
		return ocupado;
	}

	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	/////////////////// PRUDUCTOS //////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	/**
	 * Listar Producto
	 * @return Devuelve un String con el listado de productos
	 */
	public String listarProductos() {

		return listadoDeProductos.listar();
	}
	/**
	 * Listar Comidas
	 * @return devuelve un String con el listado de comidas
	 */
	public String listarComidas() {
		StringBuilder str = new StringBuilder();
		HashMap<Integer, Producto> listaC = listadoDeProductos.devolverLista();
		for (HashMap.Entry<Integer, Producto> entry : listaC.entrySet())
			if (entry.getValue() instanceof Comida)
				str.append(entry.toString() + " \r\n");

		return str.toString();
	}
	/**
	 * Listar Bebidas
	 * @return devuelve un String con el listado de bebidas
	 */
	public String listarBebidas() {
		StringBuilder str = new StringBuilder();
		HashMap<Integer, Producto> listaC = listadoDeProductos.devolverLista();
		for (HashMap.Entry<Integer, Producto> entry : listaC.entrySet())
			if (entry.getValue() instanceof Bebida)
				str.append(entry.toString() + " \r\n");

		return str.toString();
	}

	/**
	 * Crea y agrega comida a la listaDeProductos
	 * 
	 * @param idProducto
	 * @param nombreProducto
	 * @param precioProducto
	 * @param tipoDePlato
	 * @param caliente
	 * @return true si se agrego y false si no.
	 */
	public boolean agregarProducto(int idProducto, String nombreProducto, double precioProducto, String tipoDePlato,
			boolean caliente) {
		boolean flag = false;
		Comida comida = new Comida(idProducto, nombreProducto, precioProducto, tipoDePlato, caliente);
		if (!listadoDeProductos.existe(comida.getIdProducto())) {
			listadoDeProductos.agregar(comida.getIdProducto(), comida);
			flag = true;
		}
		return flag;
	}

	/**
	 * Crea y agrega bebida a la listaDeProductos
	 * 
	 * @param idProducto
	 * @param nombreProducto
	 * @param precioProducto
	 * @param tipoDeBebida
	 * @param tamanioML
	 * @return true si se agrego y false si no.
	 */
	public boolean agregarProducto(int idProducto, String nombreProducto, double precioProducto, String tipoDeBebida,
			int tamanioML) {
		boolean flag = false;
		Bebida bebida = new Bebida(idProducto, nombreProducto, precioProducto, tipoDeBebida, tamanioML);
		if (!listadoDeProductos.existe(bebida.getIdProducto())) {
			listadoDeProductos.agregar(bebida.getIdProducto(), bebida);
			flag = true;
		}
		return flag;
	}
	/**
	 * @return devuelve un String con los datos del establecimiento
	 */
	@Override
	public String toString() {

		return "El establecimiento es :" + getNombre() + " y se encuenta en : " + getDireccion()
				+ " \r\n Vengan con su familia Los Esperamos";
	}
	
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	/////////////////// JSON /////////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	
	/**
	 * Lee un Archivo JSON y lo agrega al Historial de Cuentas.
	 * @return
	 */
	public boolean JsonReader ()
	{	boolean flag = false;

		JSONArray array;
		try {
			array = new JSONArray(JsonUtiles.leer());
			Cuenta cuenta = new Cuenta();
			for (int i = 0;i<array.length();i++)
			{
				JSONObject jsonObject = array.getJSONObject(i);
				cuenta.setIdMesa(jsonObject.getInt("IdMesa"));
				cuenta.setIdMozo(jsonObject.getInt("IdMozo"));
				cuenta.setFecha(jsonObject.getString("Fecha"));
				JSONArray listaCuenta = jsonObject.getJSONArray("Cuenta");
				for(int x = 0 ; x<listaCuenta.length();x++)
				{
					JSONObject key = listaCuenta.getJSONObject(x);
					JSONObject value = listaCuenta.getJSONObject(x);
					int key_cuenta = key.getInt("Key");
					int value_Cuenta = value.getInt("Value");
					cuenta.ponerEnCuenta(key_cuenta,value_Cuenta);
				}
				//agregar cuenta a historial cuenta.
				creaCuentaEnHistorialCuentas(cuenta);
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}


		
}


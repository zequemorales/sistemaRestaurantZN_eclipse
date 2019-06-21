package clases;

import java.awt.Component;
import java.awt.TextField;
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
	
	
	public boolean agregarMesa(int nromesa, Boolean ocupado) {
		Mesa m = new Mesa(nromesa,ocupado);
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
	 * Agrega comida
	 * @param meal
	 * @return
	 */
	public boolean agregarProducto(Comida meal) {
		boolean flag = false;
		Comida comida = new Comida(meal);
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
	 * Agrega bebida
	 * @param drink
	 * @return
	 */
	public boolean agregarProducto(Bebida drink) {
		boolean flag = false;
		Bebida bebida = new Bebida(drink);
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
	 * Graba las mesas del HashMap de mesas a un archivo con JSONArray
	 * @return true si se pudo hacer la operacion false sino
	 */
	public boolean grabarMesa()
	{
		boolean flag = false;
		JSONArray array = new JSONArray();
		HashMap<Integer, Mesa> listaC = listadoDeMesas.devolverLista();
		for (HashMap.Entry<Integer, Mesa> entry : listaC.entrySet())
		{
			Mesa mesa = entry.getValue();
			array.put(mesa.getFormatoJson());
			flag = true;
		}
		JsonUtiles.grabar(array,"mesas.txt");
		return flag;
	}
	
	
	/**
	 * Guarda en archivo un JSONArray de los mozos en la listaMozo
	 * @return
	 */
	public boolean grabarMozo()
	{
		boolean flag = false;
		JSONArray array = new JSONArray();
		for(int i = 0; i<listadoDeMozos.tamanioLista(); i++)
		{
				Mozo mozo = listadoDeMozos.getindice(i);
				array.put(mozo.getFormatoJson());
				flag = true;
		}
		JsonUtiles.grabar(array, "mozos.txt");
		return flag;
	}
	
	/**
	 * Graba bebidas
	 * @return true si se pudo completar false sino.
	 */
	
	public boolean grabarComida ()
	{
		boolean flag = false;
		JSONArray array = new JSONArray();
		HashMap<Integer, Producto> listaC = listadoDeProductos.devolverLista();
		for (HashMap.Entry<Integer, Producto> entry : listaC.entrySet())
			{	
			
				Producto producto = entry.getValue();
				if(producto instanceof Comida) 
				{
					array.put(producto.getFormatoJSON());
					flag = true;
				}
				
		
			}
		JsonUtiles.grabar(array,"comida.txt");
		return flag;
	}
	
	/**
	 * Graba la Comida del menu 
	 * @return true si se pudo hacer , false sino.
	 */
	public boolean grabarBebidas ()
	{
		boolean flag = false;
		JSONArray array = new JSONArray();
		HashMap<Integer, Producto> listaC = listadoDeProductos.devolverLista();
		for (HashMap.Entry<Integer, Producto> entry : listaC.entrySet())
			{	
			
				Producto producto = entry.getValue();
				if(producto instanceof Bebida) 
				{
					array.put(producto.getFormatoJSON());
					flag = true;
				}
				
		
			}
		JsonUtiles.grabar(array,"bebida.txt");
		return flag;
	}
	
	
	

	/**
	 * Graba todas las cuentas activas en archivo json
	 * @return
	 */
	
	public boolean grabaCuentasActivas()
	{ 
		boolean flag = false;
		JSONArray array = new JSONArray();
		if(cuentasActivas.tamanioLista()>0)
		{
			for(int i = 0; i<cuentasActivas.tamanioLista();i++)
			{	
					
					Cuenta cuenta = cuentasActivas.getindice(i);
					array.put(cuenta.getJson());
						
					
			}
			JsonUtiles.grabar(array,"CuentasActivas.txt");
		}
		return flag;
	}
	
	
	/**
	 * Graba todo el historial de cuenta en archivo json
	 * @return
	 */
	
	public boolean grabaHistorialCuenta()
	{ 
		boolean flag = false;
		JSONArray array = new JSONArray();
		if(historialDeCuentas.tamanioLista()>0)
		{
			for(int i = 0; i<historialDeCuentas.tamanioLista();i++)
			{	
					Cuenta cuenta = historialDeCuentas.getindice(i);
					array.put(cuenta.getJson());
			}
			
		}
		JsonUtiles.grabar(array,"Historial Cuenta.txt");
		return flag;
	}
	
	public boolean jsonReaderMesa()
	{
		boolean flag = false;
		JSONArray array;
		try {
			array = new JSONArray(JsonUtiles.leer("mesas.txt"));
			for(int i = 0; i<array.length();i++)
			{
				JSONObject jsonObject = array.getJSONObject(i);
				agregarMesa(jsonObject.getInt("numeroMesa"), jsonObject.getBoolean("ocupadoOno"));
				flag = true;
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * Agregar Mozo a listaMozo desde un archivo con JSONArray
	 * @return
	 */
	public boolean jsonReaderMozo()
	{
		boolean flag = false;
		try {
			JSONArray array = new JSONArray(JsonUtiles.leer("mozos.txt"));
			for(int i = 0 ; i<array.length();i++)
			{
				JSONObject jsonObject = array.getJSONObject(i);
				crearMozo(jsonObject.getString("Nombre"),jsonObject.getString("Apellido"), jsonObject.getInt("idMozo"));
				flag = true;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * Lee un Archivo JSON y lo agrega al Historial de Cuentas.
	 * @return true si lo pudo agregar , false si no
	 */
	
	public boolean jsonReaderCuentaActiva()
	{	boolean flag = false;

		JSONArray array;
		try {
			array = new JSONArray(JsonUtiles.leer("CuentasActivas.txt"));
			Cuenta cuenta = new Cuenta();
			for (int i = 0;i<array.length();i++)
			{
				JSONObject jsonObject = array.getJSONObject(i);
				cuenta.setIdMesa(jsonObject.getInt("IdMesa"));
				cuenta.setIdMozo(jsonObject.getInt("IdMozo"));
				cuenta.setFecha(jsonObject.getString("Fecha"));
				JSONArray listaCuenta = jsonObject.getJSONArray("Ticket");
				for(int x = 0 ; x<listaCuenta.length();x++)
				{
					JSONObject key = listaCuenta.getJSONObject(x);
					JSONObject value = listaCuenta.getJSONObject(x);
					int key_cuenta = key.getInt("Key");
					int value_Cuenta = value.getInt("Value");
					cuenta.ponerEnCuenta(key_cuenta,value_Cuenta);
				}
				//agregar cuenta a historial cuenta.
				crearCuentaActiva(cuenta.getIdMozo(), cuenta.getIdMesa());
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	/**
	 * Lee un Archivo JSON y lo agrega al Historial de Cuentas.
	 * @return true si lo pudo agregar , false si no
	 */
	
	public boolean jsonReaderCuenta()
	{	boolean flag = false;

		JSONArray array;
		try {
			array = new JSONArray(JsonUtiles.leer("Historial Cuenta.txt"));
			Cuenta cuenta = new Cuenta();
			for (int i = 0;i<array.length();i++)
			{
				JSONObject jsonObject = array.getJSONObject(i);
				cuenta.setIdMesa(jsonObject.getInt("IdMesa"));
				cuenta.setIdMozo(jsonObject.getInt("IdMozo"));
				cuenta.setFecha(jsonObject.getString("Fecha"));
				JSONArray listaCuenta = jsonObject.getJSONArray("Ticket");
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
	/**
	 * Lee las bebidas de un JSONArray de bebidas y lo guarda en listadoProductos
	 * @return true si se pudo leer , false sino
	 */
	public boolean jsonReaderBebida()
	{
		boolean flag = false;
		JSONArray array = new JSONArray();
		try {
			array = new JSONArray(JsonUtiles.leer("bebida.txt"));
			Bebida bebida = new Bebida();
			for (int i = 0;i<array.length();i++)
			{
				JSONObject jsonObject = array.getJSONObject(i);
				bebida.setIdProducto(jsonObject.getInt("idProducto"));
				bebida.setNombreProducto(jsonObject.getString("nombreProducto"));
				bebida.setPrecioProducto(jsonObject.getDouble("precioProducto"));
				bebida.setTamanioML(jsonObject.getInt("tamanioML"));
				bebida.setTipoDeBebida(jsonObject.getString("tipoDeBebida"));
				agregarProducto(bebida);
				flag = true;
			}
			
		}catch(JSONException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
/**
 * lee jsonArray Comida y lo guarda en listadoProducto
 * @return
 */
	public boolean jsonReaderComida()
	{
		boolean flag = false;
		JSONArray array = new JSONArray();
		try {
			array = new JSONArray(JsonUtiles.leer("comida.txt"));
			Comida comida = new Comida();
			for (int i = 0;i<array.length();i++)
			{
				JSONObject jsonObject = array.getJSONObject(i);
				comida.setIdProducto(jsonObject.getInt("idProducto"));
				comida.setNombreProducto(jsonObject.getString("nombreProducto"));
				comida.setPrecioProducto(jsonObject.getDouble("precioProducto"));
				comida.setTipoDePlato(jsonObject.getString("tipoDePlato"));
				comida.setCaliente(jsonObject.getBoolean("caliente"));
				agregarProducto(comida);
				flag = true;
			}
			
		}catch(JSONException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	/////////////////// Estadisticas /////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	
	/**
	 * Saca el segundo mas vendido.
	 * @param listaPedidos
	 * @param idMax
	 * @return 
	 */
	public int segundolista (HashMap<Integer,Integer> listaPedidos, int idMax)
	{
		int id = 0;
		listaPedidos.remove(idMax);
		for(HashMap.Entry<Integer,Integer> entry : listaPedidos.entrySet())
		{
			if(id < entry.getValue())
				id = entry.getKey();
		}
		
		
		return id;
	}
	
	/**
	 * Guarda la probabilidad de un producto en ser pedido. usar Historial Comidas o Historial bebidas para el hashmap
	 * @param listaPedidos
	 * @param idProducto
	 * @return
	 */
	public double probabilidadProducto(HashMap<Integer,Integer>listaPedidos,int idProducto)
	{
		double probabilidad= 0;
		int cant = 0;
		if(listaPedidos.containsKey(idProducto)){
			for(HashMap.Entry<Integer,Integer> entry:listaPedidos.entrySet())
			{
				cant += entry.getValue();
			}
			if (listaPedidos.get(idProducto)!=0){
				double cantProd = listaPedidos.get(idProducto);
				probabilidad = (cantProd/cant)*100;
			}
			
		}

		
		
		return probabilidad;
	}
	
	
	/**
	 * Devuelve el producto mas vendido de un hashmap
	 * @param listaPedidos
	 * @return
	 */
	public int maxLista(HashMap<Integer,Integer> listaPedidos)
	{
		int id = 0;
		for(HashMap.Entry<Integer,Integer> entry : listaPedidos.entrySet())
		{
			if(id < entry.getValue())
				id = entry.getKey();
		}
		
		
		return id;
	}
	
	
	
	/**
	 * Hace un hashmap con el id y la cantidad de todos las comidas vendidas
	 * @returnHashMap <Integer,Integer>
	 */
	public HashMap<Integer,Integer> historialComidas()
	{
		HashMap<Integer,Integer> listaComidaPedidos = new HashMap<Integer,Integer>();
		for(int i=0; i<historialDeCuentas.tamanioLista(); i++)
		{
			Cuenta cuenta = historialDeCuentas.getindice(i);
			
			HashMap<Integer, Integer> listaC = cuenta.devolverLista();
			for (HashMap.Entry<Integer, Integer> entry : listaC.entrySet())
			{
				if(devuelveProducto(entry.getKey()) instanceof Comida)
				{
					if(listaComidaPedidos.get(entry.getKey()) != null)
					{
						int val = listaComidaPedidos.get(entry.getKey());
						val += entry.getValue();
						listaComidaPedidos.put(entry.getKey(),val);
					}else {
						listaComidaPedidos.put(entry.getKey(), entry.getValue());
					}
				}
			}
			
		}
		return listaComidaPedidos;
		
	}
	
	/**
	 * Calcula el total Historico de Historial de cuenta
	 * @return
	 */
	public double  totalHistorico()
	{
		double total = 0;
		for(int i=0; i<historialDeCuentas.tamanioLista(); i++)
		{
			Cuenta cuenta = historialDeCuentas.getindice(i);
			HashMap<Integer, Integer> listaC = cuenta.devolverLista();
			for (HashMap.Entry<Integer, Integer> entry : listaC.entrySet())
			{
				double precioProducto = devuelveProducto(entry.getKey()).getPrecioProducto();
				total += (entry.getValue()* precioProducto);
				
			}
			
		}
		return total;
		
	}
	
	/**
	 * Devuelve un Hashmap con todas las bebidas consumidas y sus cantidades
	 * @return  HashMap<Integer,Integer>
	 */
	public HashMap<Integer,Integer> historialBebidas()
	{
		HashMap<Integer,Integer> listaBebidaPedida = new HashMap<Integer,Integer>();
		for(int i=0; i<historialDeCuentas.tamanioLista(); i++)
		{
			Cuenta cuenta = historialDeCuentas.getindice(i);
			
			HashMap<Integer, Integer> listaC = cuenta.devolverLista();
			for (HashMap.Entry<Integer, Integer> entry : listaC.entrySet())
			{
				if(devuelveProducto(entry.getKey()) instanceof Bebida)
				{
					if(listaBebidaPedida.get(entry.getKey()) != null)
					{
						int val = listaBebidaPedida.get(entry.getKey());
						val += entry.getValue();
						listaBebidaPedida.put(entry.getKey(),val);
					}else {
						listaBebidaPedida.put(entry.getKey(), entry.getValue());
					}
				}
			}
			
		}
		return listaBebidaPedida;
		
	}

		
}


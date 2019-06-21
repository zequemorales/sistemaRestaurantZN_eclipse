package clases;

import org.json.JSONArray;

public class Programain {

	public static void main (String[] args) {
		// TODO Apéndice de método generado automáticamente
		Restaurante restoprueba=new Restaurante("Antares", "Constitucion 5500");
		
		restoprueba.jsonReaderMozo();
		restoprueba.jsonReaderMesa();
		restoprueba.jsonReaderBebida();
		restoprueba.jsonReaderComida();
		restoprueba.jsonReaderCuentaActiva();
		System.out.println(restoprueba.listarCuentasActivas());
		
		//restoprueba.agregarMesa(1);
		//restoprueba.agregarMesa(2);
		//restoprueba.grabarMesa();
		//System.out.println(restoprueba.listarMesas());
		//restoprueba.crearMozo("Mauro", "Castillo", 1);
		//restoprueba.crearMozo("Julian", "Rocasalvo", 2);
		//restoprueba.crearCuentaActiva(1, 1);
		//restoprueba.grabarMozo();
		//System.out.println(restoprueba.listarMozos());
		//restoprueba.jsonReaderBebida();
		//restoprueba.jsonReaderComida();
		restoprueba.listarProductos();
		restoprueba.agregarProducto(4, "Jalapenios", 100, "Aperitivo", true);
		restoprueba.agregarProducto(5, "Scotish", 130, "Cerveza", 400);
		restoprueba.agregarProducto(6,"lager",100,"Cerveza",500);
		
		restoprueba.agregarMesa(3);
		restoprueba.agregarMesa(4);
		restoprueba.agregarMesa(5);
		/*restoprueba.agregaProductoAlaCuenta(1, 1, 5);
		restoprueba.agregaProductoAlaCuenta(1, 2, 3);
		restoprueba.agregaProductoAlaCuenta(1, 1, 1);
		restoprueba.agregaProductoAlaCuenta(1, 3, 1);
		//restoprueba.creaCuentaEnHistorialCuentas(restoprueba.devuelveCuenta(1));
		restoprueba.crearCuentaActiva(2, 2);
		restoprueba.agregaProductoAlaCuenta(2, 1, 6);
		restoprueba.grabaCuentasActivas();*/
		//restoprueba.agregaProductoAlaCuenta(2, 2, 3);
		//restoprueba.agregaProductoAlaCuenta(2, 1, 6);
		//restoprueba.agregaProductoAlaCuenta(2, 3, 3);
		//restoprueba.creaCuentaEnHistorialCuentas(restoprueba.devuelveCuenta(2));
		restoprueba.crearCuentaActiva(1,1);
		restoprueba.crearCuentaActiva(1,2);
		restoprueba.crearCuentaActiva(1,3);
		restoprueba.crearCuentaActiva(1,4);
		
		restoprueba.agregaProductoAlaCuenta(1,4, 10);
		restoprueba.agregaProductoAlaCuenta(2,4, 10);
		restoprueba.agregaProductoAlaCuenta(3,4, 10);
		restoprueba.agregaProductoAlaCuenta(1,1, 9);
		restoprueba.agregaProductoAlaCuenta(4,1, 9);
		restoprueba.agregaProductoAlaCuenta(5,1, 9);
		restoprueba.agregaProductoAlaCuenta(5,6, 5);
		restoprueba.agregaProductoAlaCuenta(3,5, 5);
		restoprueba.agregaProductoAlaCuenta(5,6, 5);
		restoprueba.agregaProductoAlaCuenta(4,5, 7);
		restoprueba.grabarBebidas();
		restoprueba.grabarComida();
		restoprueba.creaCuentaEnHistorialCuentas(1);
		restoprueba.creaCuentaEnHistorialCuentas(2);
		restoprueba.creaCuentaEnHistorialCuentas(3);
		restoprueba.creaCuentaEnHistorialCuentas(4);
		restoprueba.creaCuentaEnHistorialCuentas(5);
		restoprueba.grabaHistorialCuenta();
		int comi = restoprueba.maxLista(restoprueba.historialComidas());
		int bebi = restoprueba.maxLista(restoprueba.historialBebidas());
		System.out.println(restoprueba.devuelveNombreProducto(comi));
		System.out.println(restoprueba.devuelveNombreProducto(bebi));
			
		//Producto producto = new Comida(1, "Papas al Vapor", 100, "Aperitivo", true);
		//System.out.println(producto.getFormatoJSON());
		/*restoprueba.grabaHistorialCuenta();
		System.out.println(restoprueba.calcularTotal(1));
		restoprueba.jsonReaderCuenta();
		System.out.println(restoprueba.listarHistorialCuentas());*/
		
	}

}

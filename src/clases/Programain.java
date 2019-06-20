package clases;

import org.json.JSONArray;

public class Programain {

	public static void main (String[] args) {
		// TODO Apéndice de método generado automáticamente
		Restaurante restoprueba=new Restaurante("Antares", "Constitucion 5500");
		
		restoprueba.jsonReaderMozo();
		
		restoprueba.agregarMesa(1);
		restoprueba.agregarMesa(2);
		//restoprueba.crearMozo("Mauro", "Castillo", 1);
		//restoprueba.crearMozo("Julian", "Rocasalvo", 2);
		restoprueba.crearCuentaActiva(1, 1);
		//restoprueba.grabarMozo();
		System.out.println(restoprueba.listarMozos());
		//restoprueba.jsonReaderBebida();
		//restoprueba.jsonReaderComida();
		/*restoprueba.listarProductos();
		restoprueba.agregarProducto(1, "Papas al Vapor", 100, "Aperitivo", true);
		restoprueba.agregarProducto(2, "IPA", 130, "Cerveza", 400);
		restoprueba.agregarProducto(3,"Golden",100,"Cerveza",500);
		
		restoprueba.agregaProductoAlaCuenta(1, 1, 5);
		restoprueba.agregaProductoAlaCuenta(1, 2, 3);
		restoprueba.agregaProductoAlaCuenta(1, 1, 1);
		restoprueba.agregaProductoAlaCuenta(1, 3, 1);
		restoprueba.creaCuentaEnHistorialCuentas(restoprueba.devuelveCuenta(1));
		restoprueba.crearCuentaActiva(2, 2);
		restoprueba.agregaProductoAlaCuenta(2, 1, 6);
		restoprueba.agregaProductoAlaCuenta(2, 2, 3);
		restoprueba.agregaProductoAlaCuenta(2, 1, 6);
		restoprueba.agregaProductoAlaCuenta(2, 3, 3);
		restoprueba.creaCuentaEnHistorialCuentas(restoprueba.devuelveCuenta(2));
		
		restoprueba.grabarBebidas();
		restoprueba.grabarComida();
		*/
			
		//Producto producto = new Comida(1, "Papas al Vapor", 100, "Aperitivo", true);
		//System.out.println(producto.getFormatoJSON());
		/*restoprueba.grabaHistorialCuenta();
		System.out.println(restoprueba.calcularTotal(1));
		restoprueba.jsonReaderCuenta();
		System.out.println(restoprueba.listarHistorialCuentas());*/
		
	}

}

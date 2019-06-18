package clases;

import org.json.JSONArray;

public class Programain {

	public static void main (String[] args) {
		// TODO Apéndice de método generado automáticamente
		Restaurante restoprueba=new Restaurante("Antares", "Constitucion 5500");
		restoprueba.agregarMesa(1);
		restoprueba.crearCuentaActiva(1, 1);
		restoprueba.agregarProducto(1, "Papas al Vapor", 100, "Aperitivo", true);
		restoprueba.agregarProducto(2, "IPA", 130, "Cerveza", 400);
		restoprueba.agregarProducto(3,"Golden",100,"Cerveza",500);
		restoprueba.agregaProductoAlaCuenta(1, 1, 5);
		restoprueba.agregaProductoAlaCuenta(1, 2, 3);
		restoprueba.agregaProductoAlaCuenta(1, 1, 1);
		restoprueba.agregaProductoAlaCuenta(1, 3, 1);
		JSONArray array = new JSONArray();
		System.out.println(restoprueba.devuelveProductosEnCuenta(restoprueba.devuelveCuenta(1)));
			
		restoprueba.devuelveCuenta(1);
		array.put(restoprueba.devuelveCuenta(1).getJson());
		JsonUtiles.grabar(array);
		restoprueba.JsonReader();
		System.out.println(restoprueba.listarHistorialCuentas());
		
	}

}

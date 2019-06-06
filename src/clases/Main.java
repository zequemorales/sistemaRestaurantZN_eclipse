package clases;

import org.json.JSONObject;

public class Main {
	
	

	public static void main(String[] args) {
		//Prueba de fecha formateada.
		Cuenta cuenta = new Cuenta(1,1);
		System.out.println(cuenta.getFecha());
		
		Bebida bebe = new Bebida(1,"IPA",90,"Cerveza",400);
		JSONObject jason = bebe.getFormatoJSON();;
		System.out.println(jason.toString());
		
		Comida comi = new Comida(1,"Arroz con Pollo",120,"Almuerzo",true);
		System.out.println(comi.getFormatoJSON().toString());
		
		
		
		
		
		
		
		
	}

	
	
}

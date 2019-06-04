package clases;

public class Programain {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		Restaurante restoprueba=new Restaurante("Antares", "Constitucion 5500");
		System.out.println(restoprueba.toString());
		
		System.out.println("LISTAR MESAS");
		restoprueba.listarMesas();
		System.out.println("LISTAR MOZOS");
		restoprueba.listarMozos();
		
		Mesa mesa1 = new Mesa(1);
		Mesa mesa2=new Mesa(2);
		Mesa mesa3=new Mesa(3);
		
		Mozo mozo1 = new Mozo("Ezequiel", "Morales", 1);
		Mozo mozo2 = new Mozo("Juan", "Perez", 2);
		Mozo mozo3 = new Mozo("Nico", "Garcia", 3);
		
		if(restoprueba.agregarMesa(mesa1)){
			System.out.println("ok");
		}
		else
			System.out.println("no");
		
		restoprueba.agregarMesa(mesa2);
		restoprueba.agregarMesa(mesa3);
		
		
		if(restoprueba.agregarMozo(mozo1)){
			System.out.println("ok");
		}
		else
			System.out.println("no");
		restoprueba.agregarMozo(mozo2);
		restoprueba.agregarMozo(mozo3);
		
		
		System.out.println("LISTAR MESAS");
		System.out.println(restoprueba.listarMesas());
		System.out.println("LISTAR MOZOS");
		System.out.println(restoprueba.listarMozos());
	
		
		
		
		

	}

}

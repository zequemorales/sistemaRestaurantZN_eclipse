package clases;

public class Programain {

	public static void main (String[] args) {
		// TODO Apéndice de método generado automáticamente
		Restaurante restoprueba=new Restaurante("Antares", "Constitucion 5500");
		System.out.println(restoprueba.toString());
		
		System.out.println("LISTAR MESAS");
		restoprueba.listarMesas();
		System.out.println("LISTAR MOZOS");
		restoprueba.listarMozos();
		System.out.println("CUENTAS ACTIVAS "+restoprueba.listarCuentasActivas());
		System.out.println("HISTORIAL CUENTAS "+restoprueba.listarHistorialCuentas());
		
		Mesa mesa1 = new Mesa(1);
		Mesa mesa2=new Mesa(2);
		Mesa mesa3=new Mesa(3);
		
	/*
		
		if(restoprueba.agregarMesa(mesa1)){
			System.out.println("la mesa "+ mesa1.getNumeroDeMesa() + "fue cargado correctamente");
		}
		else
			System.out.println("no");
		
		restoprueba.agregarMesa(mesa2);
		restoprueba.agregarMesa(mesa3);
		
		
		restoprueba.crearMozo("juan", "perez", 1);
		restoprueba.crearMozo("eze", "morales", 2);
		restoprueba.crearMozo("nico", "cristo", 3);
		*/
		//prueba

	
		
		System.out.println("LISTAR MESAS");
		System.out.println(restoprueba.listarMesas());
		System.out.println("LISTAR MOZOS");
		System.out.println(restoprueba.listarMozos());
		
		restoprueba.crearCuentaActiva(1, 1);
	System.out.println("CUENTAS ACTIVAS "+restoprueba.listarCuentasActivas());
	System.out.println("HISTORIAL CUENTAS "+restoprueba.listarHistorialCuentas());
	
		System.out.println(restoprueba.listarMesas());
		
		//restoprueba.eliminarCuentaActiva(1);
		
		System.out.println(restoprueba.listarMesas());
		
		
		
		restoprueba.agregarProducto(1,"IPA",90,"Cerveza",400);
		restoprueba.agregarProducto(2,"Arroz con Pollo",120,"Almuerzo",true);
		
		System.out.println(restoprueba.listarProductos());
		System.out.println("HISTORIAL CUENTAS "+restoprueba.listarHistorialCuentas());
		System.out.println("CUENTAS ACTIVAS "+restoprueba.listarCuentasActivas());
		
		
		restoprueba.agregaProductoAlaCuenta(1,1 , 3);
		restoprueba.agregaProductoAlaCuenta(1, 1, 2);
		restoprueba.agregaProductoAlaCuenta(1, 2,5);
		System.out.println(restoprueba.calcularTotal(1));
		restoprueba.eliminarCuentaActiva(1);
		System.out.println("HISTORIAL CUENTAS "+restoprueba.listarHistorialCuentas());
		System.out.println("CUENTAS ACTIVAS "+restoprueba.listarCuentasActivas());
		System.out.println("Bebidas\r\n"+restoprueba.listarBebidas());
		System.out.println("Comidas \r\n"+restoprueba.listarComidas());

	}

}

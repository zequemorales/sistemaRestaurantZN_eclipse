package clases;

public class Programain {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		Restaurante restoprueba = new Restaurante("Antares", "Constitucion 5500");
		System.out.println(restoprueba.toString());

		System.out.println("LISTAR MESAS");
		restoprueba.listarMesas();
		System.out.println("LISTAR MOZOS");
		restoprueba.listarMozos();
		System.out.println("CUENTAS ACTIVAS " + restoprueba.listarCuentasActivas());
		System.out.println("HISTORIAL CUENTAS " + restoprueba.listarHistorialCuentas());

		if (restoprueba.agregarMesa(1)) {
			System.out
					.println("la mesa " + restoprueba.devuelveMesa(1).getNumeroDeMesa() + "fue cargado correctamente");
		} else
			System.out.println("no");

		restoprueba.agregarMesa(2);
		restoprueba.agregarMesa(3);

		restoprueba.crearMozo("juan", "perez", 1);
		restoprueba.crearMozo("eze", "morales", 2);
		restoprueba.crearMozo("nico", "cristo", 3);

		// prueba

		System.out.println("LISTAR MESAS");
		System.out.println(restoprueba.listarMesas());
		System.out.println("LISTAR MOZOS");
		System.out.println(restoprueba.listarMozos());

		restoprueba.crearCuentaActiva(1, 1);
		System.out.println("CUENTAS ACTIVAS " + restoprueba.listarCuentasActivas());
		System.out.println("HISTORIAL CUENTAS " + restoprueba.listarHistorialCuentas());

		System.out.println(restoprueba.listarMesas());

		// restoprueba.eliminarCuentaActiva(1);

		System.out.println(restoprueba.listarMesas());

		restoprueba.agregarProducto(1, "IPA", 90, "Cerveza", 400);
		restoprueba.agregarProducto(2, "Arroz con Pollo", 120, "Almuerzo", true);
		
		//listar productos
		
		

		System.out.println(restoprueba.listarProductos());
		System.out.println("HISTORIAL CUENTAS " + restoprueba.listarHistorialCuentas());
		System.out.println("CUENTAS ACTIVAS " + restoprueba.listarCuentasActivas());

		restoprueba.agregaProductoAlaCuenta(1, 1, 3);
		restoprueba.agregaProductoAlaCuenta(1, 1, 2);
		restoprueba.agregaProductoAlaCuenta(1, 2, 5);
		System.out.println(restoprueba.calcularTotal(1));
		restoprueba.eliminarCuentaActiva(1);
		System.out.println("HISTORIAL CUENTAS " + restoprueba.listarHistorialCuentas());
		System.out.println("CUENTAS ACTIVAS " + restoprueba.listarCuentasActivas());

	}

}

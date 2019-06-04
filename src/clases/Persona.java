package clases;

public class Persona {
	private String nombre;
	private String apellido;
	
		
	public Persona(String nombre, String apellido) {
		setNombre(nombre);
		setApellido(apellido);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
 @Override
public String toString() {
	// TODO Apéndice de método generado automáticamente
	return "Nombre: "+ getNombre()+" Apellido: "+ getApellido()+ " ";
}
}

package clases;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Clase Comida
 * 
 * 
 */

public class Comida extends Producto{
	
	private String tipoDePlato;
	private boolean caliente;
	
	/**
	 * Descripcion de la comida
	 * @return String con las descripcion de la comida
	 */
	@Override
	public String toString() {
		return super.toString()+ "Tipo De Plato:" + getTipoDePlato() + " Caliente:" + isCalienteOno();
	}
	/**
	 * Costructor
	 * @param idProducto
	 * @param nombreProducto
	 * @param precioProducto
	 * @param tipoDePlato
	 * @param caliente
	 */
	public Comida(int idProducto, String nombreProducto, double precioProducto, String tipoDePlato, boolean caliente) {
		super(idProducto, nombreProducto, precioProducto);
		setTipoDePlato(tipoDePlato);
		setCaliente(caliente);
		
	}
	/**
	 * Costructor Vacio
	 */
	public Comida() {
		super();
		tipoDePlato = "";
	}
	/**
	 * Obtiene el tipo de plato
	 * @return String con el tipo de plato
	 */
	public String getTipoDePlato() {
		return tipoDePlato;
	}
	/**
	 * Setea el tipo de plato
	 * @param tipoDePlato
	 * Recibie el tipo de plato a setear
	 */
	public void setTipoDePlato(String tipoDePlato) {
		this.tipoDePlato = tipoDePlato;
	}
	/*
	 * Si el plato esta caliente 
	 * @return  si el plato esta caliente devuelve true 
	 */
	public boolean isCalienteOno(){
		return caliente;
	}
	/**
	 * Setea caliente 
	 * @param caliente
	 * Recibe caliente a setear
	 */
	public void setCaliente(boolean caliente){
		this.caliente=caliente;
	}
	
	@Override
	public JSONObject getFormatoJSON() 
	{
		JSONObject jsonObject = super.getFormatoJSON();
		try {
			jsonObject.put("tipoDePlato", getTipoDePlato());
			jsonObject.put("caliente", isCalienteOno());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	

}

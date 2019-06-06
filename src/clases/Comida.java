package clases;
import org.json.JSONException;
import org.json.JSONObject;


public class Comida extends Producto{
	
	private String tipoDePlato;
	private boolean caliente;
	
	
	
	@Override
	public String toString() {
		return super.toString()+ "Tipo De Plato:" + getTipoDePlato() + " Caliente:" + isCalienteOno();
	}


	public Comida(int idProducto, String nombreProducto, double precioProducto, String tipoDePlato, boolean caliente) {
		super(idProducto, nombreProducto, precioProducto);
		setTipoDePlato(tipoDePlato);
		setCaliente(caliente);
		
	}

		
	public Comida() {
		super();
		tipoDePlato = "";
	}

	public String getTipoDePlato() {
		return tipoDePlato;
	}
	public void setTipoDePlato(String tipoDeComida) {
		this.tipoDePlato = tipoDeComida;
	}
	
	public boolean isCalienteOno(){
		return caliente;
	}
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

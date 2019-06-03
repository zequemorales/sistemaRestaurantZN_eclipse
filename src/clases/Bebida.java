package clases;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONException;
public class Bebida extends Producto{
	
	private String tipoDeBebida;
	private int tamanioML;

		
	public Bebida(int idProducto, String nombreProducto, double precioProducto, String tipoDeBebida, int tamanioML) {
		super(idProducto, nombreProducto, precioProducto);
		setTipoDeBebida(tipoDeBebida);
		setTamanioML(tamanioML);
	}
		
	public Bebida() {
		super();
		tipoDeBebida = "";
	}

	public String getTipoDeBebida() {
		return tipoDeBebida;
	}
	public void setTipoDeBebida(String tipoDeBebida) {
		this.tipoDeBebida = tipoDeBebida;
	}

	public int getTamanioML() {
		return tamanioML;
	}

	public void setTamanioML(int tamanioML) {
		this.tamanioML = tamanioML;
	}
	
	public JSONObject getFormatoJSON()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject = super.getFormatoJSON();
			jsonObject.put("tipoDeBebida", getTipoDeBebida());
			jsonObject.put("tamanioML", getTamanioML());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject;
		
	}

}

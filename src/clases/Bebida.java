package clases;
/**
 * Clase Comida
 * 
 * @param tipoDeBebida
 * @param tamanioML
 * 					tamaño del envace expresado en mililitros
 */
import org.json.JSONException;
import org.json.JSONObject;
public class Bebida extends Producto{
	
	private String tipoDeBebida;
	private int tamanioML;

	/**
	 * Descripcion de la bebida
	 * @return String con las descripcion de la bebida
	 */
	@Override
	public String toString() {
		return super.toString()+ "Tipo De Bebida:" + getTipoDeBebida() + "Tamanio ML=" + getTamanioML();
	}
	/**
	 * Constructor
	 * @param idProducto identificador del producto
	 * @param nombreProducto nombre del producto
	 * @param precioProducto precio del producto
	 * @param tipoDeBebida tipo de bebeido
	 * @param tamanioML tamaño de la bebida 
	 */
	public Bebida(int idProducto, String nombreProducto, double precioProducto, String tipoDeBebida, int tamanioML) {
		super(idProducto, nombreProducto, precioProducto);
		setTipoDeBebida(tipoDeBebida);
		setTamanioML(tamanioML);
	}
	/**
	 * Constructor vacio
	 */
	public Bebida() {
		super();
		tipoDeBebida = "";
	}
	/**
	 * Obtiene el tipo de bebida
	 * @return String con el tipo de bebida
	 */
	public String getTipoDeBebida() {
		return tipoDeBebida;
	}
	/**
	 * Setea el tipo de bebida
	 * @param tipoDeBebida tipo de la bebida
	 * Recibe el tipo de bebida a setear	 
	 */
	public void setTipoDeBebida(String tipoDeBebida) {
		this.tipoDeBebida = tipoDeBebida;
	}
	/**
	 * Obtiene el tamañoo de la bebida
	 * @return int con el tamaño de la beboda
	 */
	public int getTamanioML() {
		return tamanioML;
	}
	/**
	 * Setea el tamaño del envace
	 * @param tamanioML tamaño de la bebida
	 * Recibe el tamaño del envace a setear	 
	 */
	public void setTamanioML(int tamanioML) {
		this.tamanioML = tamanioML;
	}
	/**
	 * Obtiene el formato json
	 * @return Objeto del Json
	 */
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

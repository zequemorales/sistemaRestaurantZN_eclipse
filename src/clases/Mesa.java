package clases;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase Mesa
 * 
 * @param numeroDeMesa
 * 				numero de mesa
 * @param ocupadoONO
 * 					si la mesa esta ocupada devuelve true
 */
public class Mesa {
	
	private int numeroDeMesa;
	private boolean ocupadoONO;
	
	/**
	 * Constructor
	 * @param nromesa numero de la mesa
	 */
	public Mesa(int nromesa){
		setNumeroDeMesa(nromesa);
		setOcupadoONO(false);
	}
	
	/**
	 * Contructor
	 * @param nromesa
	 * @param ocupado
	 */
	public Mesa(int nromesa,Boolean ocupado){
		setNumeroDeMesa(nromesa);
		setOcupadoONO(ocupado);
	}
	
	/**
	 * Constructor Vacio
	 */
	public Mesa(){
		setNumeroDeMesa(0);
		setOcupadoONO(false);
	}
	/**
	 * Obtiene el numero de mesa
	 * @return int con el numero de mesas
	 */
	public int getNumeroDeMesa() {
		return numeroDeMesa;
	}
	/**
	 * Setea el numero de mesas
	 * @param numeroDeMesa
	 * Recibe el numeros de mesas a setear
	 */
	public void setNumeroDeMesa(int numeroDeMesa) {
		this.numeroDeMesa = numeroDeMesa;
	}
	/*
	 * Si esta ocupada o no la mesa
	 * @return  si la mesa esta ocupada devuelve true 
	 */
	public boolean isOcupadoONO() {
		return ocupadoONO;
	}
	/**
	 * Setea la ocupacion de la mesa
	 * @param ocupadoONO
	 * Recibe la ocupacion a setear
	 */
	private void setOcupadoONO(boolean ocupadoONO) {
		this.ocupadoONO = ocupadoONO;
	}
	/**
	 * Descripcion de la mesa
	 * @return String con la descripcion de la mesa
	 */
	@Override
	public String toString() {
		return " Numero de Mesa " +  getNumeroDeMesa()+" Ocupada " +  isOcupadoONO() ;
	}
	
	/**
	 * Ocupado true
	 * Desocupado false
	 */
	public void ocuparMesa(){
		setOcupadoONO(true);
	}
	public void desocuparMesa(){
		setOcupadoONO(false);
	}

	public JSONObject getFormatoJson()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("numeroMesa", getNumeroDeMesa());
			jsonObject.put("ocupadoOno", isOcupadoONO());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
		
	}
}

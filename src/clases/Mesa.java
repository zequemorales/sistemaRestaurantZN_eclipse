package clases;
/**
 * Clase Mesa
 * @param numeroDeMesa
 * 					numero de identificación de la mesa
 * @param ocupadoONO
 */
public class Mesa {
	private int numeroDeMesa;
	private boolean ocupadoONO;
	
	/**
	 * Constructor
	 * @param nromesa
	 */
	public Mesa(int nromesa){
		setNumeroDeMesa(nromesa);
		setOcupadoONO(false);
	}
	/**
	 * Constructor Vacio
	 */
	public Mesa(){
		setNumeroDeMesa(0);
		setOcupadoONO(false);
	}
	/**
	 * Obtiene el número de mesa
	 * @return int con el numero de mesas
	 */
	public int getNumeroDeMesa() {
		return numeroDeMesa;
	}
	/**
	 * Setea el número de mesas
	 * @param numeroDeMesa
	 * Recibe el números de mesas a setear
	 */
	public void setNumeroDeMesa(int numeroDeMesa) {
		this.numeroDeMesa = numeroDeMesa;
	}
	/*
	 * Si esta ocupada o no la mesa
	 * @return  si la mesa está ocupada devuelve true 
	 */
	public boolean isOcupadoONO() {
		return ocupadoONO;
	}
	/**
	 * Setea la ocupación de la mesa
	 * @param ocupadoONO
	 * Recibe la ocupación a setear
	 */
	private void setOcupadoONO(boolean ocupadoONO) {
		this.ocupadoONO = ocupadoONO;
	}
	/**
	 * Descripción de la mesa
	 * @return String con la descripción de la mesa
	 */
	@Override
	public String toString() {
		return "N° de Mesa " +  getNumeroDeMesa()+"Ocupada " +  isOcupadoONO() ;
	}
	
	/**
	 * OCUPADO TRUE
	 * DESOCUPADO FALSE
	 */
	public void ocuparMesa(){
		setOcupadoONO(true);
	}
	public void desocuparMesa(){
		setOcupadoONO(false);
	}

}

package clases;
/**
 * Clase Mesa
 * 
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
	 * Constructor Vacio
	 */
	public Mesa(){
		setNumeroDeMesa(0);
		setOcupadoONO(false);
	}
	/**
	 * Obtiene el n�mero de mesa
	 * @return int con el numero de mesas
	 */
	public int getNumeroDeMesa() {
		return numeroDeMesa;
	}
	/**
	 * Setea el n�mero de mesas
	 * @param numeroDeMesa
	 * Recibe el n�meros de mesas a setear
	 */
	public void setNumeroDeMesa(int numeroDeMesa) {
		this.numeroDeMesa = numeroDeMesa;
	}
	/*
	 * Si esta ocupada o no la mesa
	 * @return  si la mesa est� ocupada devuelve true 
	 */
	public boolean isOcupadoONO() {
		return ocupadoONO;
	}
	/**
	 * Setea la ocupaci�n de la mesa
	 * @param ocupadoONO
	 * Recibe la ocupaci�n a setear
	 */
	private void setOcupadoONO(boolean ocupadoONO) {
		this.ocupadoONO = ocupadoONO;
	}
	/**
	 * Descripci�n de la mesa
	 * @return String con la descripci�n de la mesa
	 */
	@Override
	public String toString() {
		return " Numero de Mesa " +  getNumeroDeMesa()+" Ocupada " +  isOcupadoONO() ;
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

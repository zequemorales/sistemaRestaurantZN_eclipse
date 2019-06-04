package clases;

public class Mesa {
	private int numeroDeMesa;
	private boolean ocupadoONO;
	
	
	public Mesa(int nromesa){
		setNumeroDeMesa(nromesa);
		setOcupadoONO(false);
	}
	
	public Mesa(){
		setNumeroDeMesa(0);
		setOcupadoONO(false);
	}
	
	
	public int getNumeroDeMesa() {
		return numeroDeMesa;
	}
	public void setNumeroDeMesa(int numeroDeMesa) {
		this.numeroDeMesa = numeroDeMesa;
	}
	public boolean isOcupadoONO() {
		return ocupadoONO;
	}
	private void setOcupadoONO(boolean ocupadoONO) {
		this.ocupadoONO = ocupadoONO;
	}
	
	@Override
	public String toString() {
		// TODO Apéndice de método generado automáticamente
		return "Ocupada " +  isOcupadoONO() ;
	}
	
	// OCUPADO TRUE
	// DESOCUPADO FALSE
	public void ocuparMesa(){
		setOcupadoONO(true);
	}
	public void desocuparMesa(){
		setOcupadoONO(false);
	}

}

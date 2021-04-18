package domain;


public class Casilla {
	
	static final String[] tipoDeCasilla = {"VACIA", "ARBOL", "LOBO", "DULCE", "FLORES"};
	
	Integer tipo;

	public Integer getTipo() {
		return tipo;
	}


	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	

}

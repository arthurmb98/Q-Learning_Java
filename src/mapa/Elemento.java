package mapa;

public enum Elemento {
	PAREDE("[-]",-1), CAMINHO("   ",0), PACMAN(" C ", 9), COMIDA(" o ", 5);
	
	private int valor;
	private String rep;
	
	Elemento(String s, int valor){
		this.valor = valor;
		this.rep = s;
	}
	
	public int valor(){
		return valor;
	}
	
	public boolean equals(int valor){
		if(this.valor == valor){
			return true;
		}
		return false;
	}
	
	public String rep(){
		return rep;
	}
	
}

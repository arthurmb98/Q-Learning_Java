package mapa;

import java.util.List;

public class Estado {// numero e ponto referente no mapa do estado
	private int id;
	private Coordenada coord;
	
	
	Estado(int id, Coordenada c){
		this.id = id;
		coord = c;
	}
	
	public int getId(){
		return id;
	}
	
	public Coordenada getCoord(){
		return coord;
	}
	
}

package mapa;

public class Coordenada {
	public int l;
	public int c;
	
	public Coordenada(int x, int y){
		l=x;
		c=y;
		
	}
	
	public boolean equals(Coordenada o){
		if(o != null){
			if(o.l == this.l){
				if(o.c == this.c){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public int hashCode(){
		return this.toString().hashCode();
	}
	
	public String toString(){
		return l+""+c;
	}
}

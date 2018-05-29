package mapa;

import java.awt.Point;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Mapa {
	private Coordenada size = new Coordenada(11,19);
	private int[][] mapa = {{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
							{ -1,  0,  0,  0,  0, -1,  0,  0,  0,  0,  0,  0,  0, -1,  0,  0,  0,  0, -1},
							{ -1,  0, -1, -1,  0, -1,  0, -1, -1, -1, -1, -1,  0, -1,  0, -1, -1,  0, -1},
							{ -1,  0, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1,  0, -1},
							{ -1,  0, -1,  0, -1, -1,  0, -1, -1,  0, -1, -1,  0, -1, -1,  0, -1,  0, -1},
							{ -1,  0,  0,  5,  0,  0,  0, -1,  5,  0,  0, -1,  0,  0,  0,  0,  0,  0, -1},
							{ -1,  0, -1,  0, -1, -1,  0, -1, -1, -1, -1, -1,  0, -1, -1,  0, -1,  0, -1},
							{ -1,  0, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1,  0, -1},
							{ -1,  0, -1, -1,  0, -1,  0, -1, -1, -1, -1, -1,  0, -1,  0, -1, -1,  0, -1},
							{ -1,  0,  0,  0,  0, -1,  0,  0,  0,  0,  0,  0,  0, -1,  0,  0,  0,  5, -1},
							{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
	
	private int[][] reset =    {{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
								{ -1,  0,  0,  0,  0, -1,  0,  0,  0,  0,  0,  0,  0, -1,  0,  0,  0,  0, -1},
								{ -1,  0, -1, -1,  0, -1,  0, -1, -1, -1, -1, -1,  0, -1,  0, -1, -1,  0, -1},
								{ -1,  0, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1,  0, -1},
								{ -1,  0, -1,  0, -1, -1,  0, -1, -1,  0, -1, -1,  0, -1, -1,  0, -1,  0, -1},
								{ -1,  5,  0,  0,  0,  0,  0, -1,  0,  0,  5, -1,  0,  0,  0,  0,  0,  0, -1},
								{ -1,  0, -1,  0, -1, -1,  0, -1, -1, -1, -1, -1,  0, -1, -1,  0, -1,  0, -1},
								{ -1,  0, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1,  0, -1},
								{ -1,  0, -1, -1,  0, -1,  0, -1, -1, -1, -1, -1,  0, -1,  0, -1, -1,  0, -1},
								{ -1,  0,  0,  0,  0, -1,  0,  0,  0,  0,  0,  0,  0, -1,  0,  0,  0,  5, -1},
								{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
	
	private int[][] mapaEstado =   {{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
									{ -1,  0,  1,  2,  0, -1,  0,  1,  2,  3,  4,  5,  0, -1,  0,  1,  2,  0, -1},
									{ -1,  1, -1, -1,  1, -1,  1, -1, -1, -1, -1, -1,  1, -1,  1, -1, -1,  1, -1},
									{ -1,  2, -1,  0,  0,  1,  0,  1,  2,  0,  1,  2,  0,  1,  0,  0, -1,  2, -1},
									{ -1,  3, -1,  1, -1, -1,  1, -1, -1,  1, -1, -1,  1, -1, -1,  1, -1,  3, -1},
									{ -1,  0,  1,  0,  1,  2,  0, -1,  0,  0,  0, -1,  0,  1,  2,  0,  1,  0, -1},
									{ -1,  1, -1,  1, -1, -1,  1, -1, -1, -1, -1, -1,  1, -1, -1,  1, -1,  1, -1},
									{ -1,  2, -1,  0,  0,  1,  0,  1,  2,  3,  4,  5,  0,  1,  0,  0, -1,  2, -1},
									{ -1,  3, -1, -1,  1, -1,  1, -1, -1, -1, -1, -1,  1, -1,  1, -1, -1,  3, -1},
									{ -1,  0,  1,  2,  0, -1,  0,  1,  2,  3,  4,  5,  0, -1,  0,  1,  2,  0, -1},
									{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
	private Coordenada pacman;
	private Grafo grafo;
	private int qntdComida = 0;
	
	private int aleatorio(int bound){
		Random r = new Random();
		return r.nextInt(bound);
	}
	
	public Mapa(){
		grafo = new Grafo();
		parse();
	}
	
	
	public String toString(){
		String mapaS = "";
		for(int i = 0; i < size.l; i++){
			for(int j = 0; j < size.c; j++){
				if(Elemento.PAREDE.equals(mapa[i][j])){
					mapaS += Elemento.PAREDE.rep();
				}
				if(Elemento.PACMAN.equals(mapa[i][j])){
					mapaS += Elemento.PACMAN.rep();				
				}
				if(Elemento.COMIDA.equals(mapa[i][j])){
					mapaS += Elemento.COMIDA.rep();				
				}
				if(Elemento.CAMINHO.equals(mapa[i][j])){
					mapaS += Elemento.CAMINHO.rep();				
				}
			}
			mapaS += "\n";
		}
		return mapaS;
		
	}
		
	
	public Grafo getGrafo(){
		return grafo;
	}
	
	private void parse(){
		int id = 0;
		for(int i = 0; i < size.l; i++){
			for(int j = 0; j < size.c; j++){
				if(mapaEstado[i][j] == 0){
					Coordenada p = new Coordenada(i,j);
					grafo.setEstados(p,new Estado(id,p));
					id++;
				}	
			}
		}
		grafo.gerarTabelas();
		for(int i = 0; i < size.l; i++){
			int dist;
			for(int j = 0; j < size.c; j++){
				if(mapaEstado[i][j] == 0){
					if(mapaEstado[i-1][j] >= 0){
						dist = mapaEstado[i-1][j] + 1;
						grafo.setAresta(new Coordenada(i,j), new Coordenada(i-dist,j));
					}
					if(mapaEstado[i][j-1] >= 0){
						dist = mapaEstado[i][j-1] + 1;
						grafo.setAresta(new Coordenada(i,j), new Coordenada(i,j-dist));
					}
				}
			}
		}
		for(int i = 0; i < size.l; i++){
			for(int j = 0; j < size.c; j++){
				if(mapa[i][j] == Elemento.COMIDA.valor()){
					qntdComida++;
					grafo.setRecompensa(new Coordenada(i,j), 100);
				}
			}
		}
	}
	
	public void executar(){
		int comida = qntdComida;
		int bound = grafo.getNumEstados();
		int id = aleatorio(bound);
		Coordenada p = grafo.getPontoById(id);
		if(mapa[p.l][p.c] == Elemento.COMIDA.valor()){
			comida--;
		}
		pacman = p;
		mapa[pacman.l][pacman.c] = Elemento.PACMAN.valor();
		while(comida != 0){
			p = grafo.qLearning(pacman);
			if(mapa[p.l][p.c] == Elemento.COMIDA.valor()){
				comida--;
	
			}
			mapa[pacman.l][pacman.c] = Elemento.CAMINHO.valor();
			pacman = p;
			mapa[pacman.l][pacman.c] = Elemento.PACMAN.valor();
			
		}
		resetMapa();
	}

	private void resetMapa() {
		for(int i = 0; i < size.l; i++){
			for(int j = 0; j < size.c; j++){
				mapa[i][j] = reset[i][j];
			}
		}	
	}

	
}

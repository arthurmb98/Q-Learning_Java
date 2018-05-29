package mapa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Grafo {
	private Map<Integer, Estado> estados;
	private Map<Integer, Integer> mapa;
	private double[][] tabelaR;
	private double[][] tabelaQ;
	private double gamma = 0.8 ;
	
	private int aleatorio(int bound){
		Random r = new Random();
		return r.nextInt(bound);
	}
	
	public Grafo(){
		estados = new HashMap<Integer, Estado>();
		mapa = new HashMap<Integer, Integer>();
	}
	
	public void gerarTabelas(){
		int size = estados.size();
		tabelaR = new double[size][size];
		tabelaQ = new double[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				tabelaR[i][j] =  -1;
				tabelaQ[i][j] =  0;
			}
		}	
	}
	
	public void setGamma(double valor){
		gamma = valor;
	}
	
	public List<Estado> getVertAdj(int id){
		List<Estado> adj = new ArrayList<Estado>();
		int size = estados.size();	
		for(int i = 0; i < size; i++){
			if(tabelaR[id][i] != -1){
					Estado v = getVerticeById(i);
					adj.add(v);
			}
		}
		return adj;
	}
	
	
	public void setRecompensa(Coordenada p, double valor){
		int id =  getIdByPonto(p);
		tabelaR[id][id] = valor;
		List<Estado> adj = getVertAdj(id);
		for(int i = 0; i < adj.size(); i++){
			tabelaR[adj.get(i).getId()][id] = valor;
		}
		
	}
	
	public void setAresta(Coordenada origem, Coordenada destino){
		try {
			int o = getIdByPonto(origem);
			int d = getIdByPonto(destino);
			tabelaR[o][d] = 0;
			tabelaR[d][o] = 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void setEstados(Coordenada p, Estado v){
		mapa.put(p.hashCode(), v.getId());
		estados.put(v.getId(), v);
	}
	
	public Estado getVerticeById(int id){
		return estados.get(id);
	}
	
	public Coordenada getPontoById(int id){
		return getVerticeById(id).getCoord();
	}
	
	public int getIdByPonto(Coordenada p){
		return mapa.get(p.hashCode());
	}
	
	
	public int getNumEstados(){
		return estados.size();
	}
	
	public String tabelaQtoString(){
		String s = "";
		int size = estados.size();
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(tabelaR[i][j] != -1){
					s += "["+i+"~"+j+"]" +" = "+tabelaQ[i][j]+"\n";
				}	
			}
		} 
		return s;
	}
	
	public String tabelaRtoString(){
		String s = "";
		int size = estados.size();
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(tabelaR[i][j] != -1){
					s += "["+i+"~"+j+"]" +" = "+tabelaR[i][j]+"\n";
				}	
			}
		} 
		return s;
	}
	
	private double qMax(int id){
		List<Estado> adj = getVertAdj(id);
		double maior = tabelaQ[id][adj.get(0).getId()];
		for(int i = 1; i < adj.size(); i++){
			if(tabelaQ[id][adj.get(i).getId()] > maior){
				maior = tabelaQ[id][adj.get(i).getId()];
			}
		}
		return maior;
	}
	
	public Coordenada qLearning(Coordenada i){
		int id = getIdByPonto(i);
		List<Estado> adj = getVertAdj(id);
		Estado v = adj.get(aleatorio(adj.size()));
		tabelaQ[id][v.getId()] = tabelaR[id][v.getId()] + gamma*(qMax(v.getId()));
		return v.getCoord();
	}

	public String getGamma() {
		
		return gamma+"";
	}
}

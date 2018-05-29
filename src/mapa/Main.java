package mapa;
/*UNIVERSIDADE ESTADUAL DO MARANHÃO
 *CCT - ENGENHARIA DE COMPUTAÇÃO
 *INTELIGENCIA COMPUTACIONAL
 *Algoritmo de QLearning no pacman
 *		Meta: pegar 3 comidas
 *ARTHUR MOURA BARBOSA - 201524350
 *IAN LIMA PEREIRA - 201520735
 *TIAGO SANTOS FERREIRA - 201523076
*/
public class Main {
	public static void main(String[] args){
		Mapa m;
		int nEps = 50;
		m = new Mapa();
		System.out.println("Algoritmo QLearning para Pacman\nRepresentação do mapa:\n\n"+m.toString());
		for(int i = 0; i < nEps; i++){
			m.executar();
		}
		
		System.out.println("\nDepois de 50 episódios com gamma = 0.8\n\n"+m.getGrafo().tabelaQtoString());
		m.getGrafo().setGamma(0.5);
		for(int i = 0; i < nEps; i++){
			m.executar();
		}
		
		System.out.println("\nDepois de 50 episódios com gamma = 0.5\n\n"+m.getGrafo().tabelaQtoString());
		m.getGrafo().setGamma(0.1);
		for(int i = 0; i < nEps; i++){
			m.executar();
		}
		
		System.out.println("\nDepois de 50 episódios com gamma = 0.1\n\n"+m.getGrafo().tabelaQtoString());
		
		
		
	}
}

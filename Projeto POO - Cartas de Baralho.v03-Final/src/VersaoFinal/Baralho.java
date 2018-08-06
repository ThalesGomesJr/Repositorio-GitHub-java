package VersaoFinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class Baralho {
	//Cada posicao do Array baralho contem uma carta 
	private List <Carta> baralho = new ArrayList <Carta>();
	
	//Construtor baralho 
	public Baralho() {
		baralho = new ArrayList <Carta>();
	}
	
	//Construtor naipes do baralho
	public Baralho(int qtNaipe, char naipe ) {
		String nome;
		Carta c;
		int  numCarta,i;
		
		/*if (qtNaipe==1) {
			for(numcarta = 1; numcarta < 14; numcarta++) {		
				nome = String.format("%d", numcarta)+"-"+naipe+".png";
				c = new Carta (nome, naipe, numcarta, false);
				baralho.add(c);
			}
		}*/
		
		if(qtNaipe==4) {
			for(i=1;i<5;i++) {
				switch(i) {
					case 1: naipe = 'o';
							break;
					
					case 2: naipe = 'c';
							break;
							
					case 3: naipe = 'e';
							break;
					
					case 4: naipe = 'p';
							break;
				}
				
				for(numCarta=1; numCarta<14; numCarta++) {	
					nome = String.format("%d", numCarta)+"-" +naipe+ ".png";
					c = new Carta (nome, naipe, numCarta, false);
					baralho.add(c);	
				}
			}
		}
	}
	//Limpa o array baralho
	public void zeraBaralho () {
		baralho.clear();
	}
	//Contador de cartas que estão no array baralho
	public int quantidade() {
		return baralho.size();
	}
	//adiciona cartas no array baralho 
	public void adcionar(Carta c){
		baralho.add(c);
	}
	//embaralha o array baralho
	public void embaralha() {
		Collections.shuffle(baralho);
		JOptionPane.showMessageDialog(null,"Cartas embaralhadas!");
	}
	//busca carta no array baralho,envia para c e remove do baralho 
	public Carta getCarta(int posicao) {
		Carta c = baralho.get(posicao);
		baralho.remove(posicao);
		return c;
	}
	//Exibe array
	public String toString () {
					
		String saida = "------ Baralho ------ \n";
			for(Carta c: baralho)
				saida+=c.toString()+"\n";
				
		return saida;	
	}
}

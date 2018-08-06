import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class Baralho {
	
	private List <Carta> baralho = new ArrayList <Carta>();//cada posicao do vetor � uma carta / baralho = nome do vetor
	
	public Baralho() {//Construtor
		
		baralho = new ArrayList <Carta>();
		
	}
	
	public Baralho(int qtNaipe, char naipe ) {
		
		String nome;
		Carta c;
		
		if (qtNaipe==1) {
			
			for(int numcarta = 1; numcarta < 14; numcarta++) {
			
				nome = String.format("%d", numcarta) + "-" +naipe+ ".png";
				c = new Carta (nome, naipe, numcarta, false);
				
				baralho.add(c);
			
			}
			
		}
		
		if(qtNaipe==4) {
			
			for (int i=1;i<5;i++) {
					
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
				
				for(int nC=1; nC<14; nC++) {
					
					nome = String.format("%d", nC) + "-" +naipe+ ".png";
					c = new Carta (nome, naipe, nC, false);
					
					baralho.add(c);
					
					
				}
				
			}
		}
		
		
	}
	
	public void zeraBaralho () {
		baralho.clear();
	}
	
	public int quantidade() {
		return baralho.size();
	}
	
	public void adcionar(Carta card){
		baralho.add(card);
		 
	}
	
	public void embaralha() {
		Collections.shuffle(baralho);
		JOptionPane.showMessageDialog(null,"Cartas embaralhadas!");
	}
	
	public Carta getCarta(int posicao) {
		Carta c = baralho.get(posicao);
		baralho.remove(posicao);
		return c;
	}
	
	public String toString () {
					
		String saida = "------ Baralho ------ \n";
			for(Carta c: baralho)
				saida+=c.toString()+"\n";
				
		return saida;	
				
	}

}
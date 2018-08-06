
public class Carta {
	
	private String imagem;
	private char naipe;
	private int numero;
	private boolean aberto;

	public Carta() {//Construtor
		
		this.imagem = " ";
		this.naipe = 'o';
		this.numero = 0;
		this.aberto = false;
		
	}
	
	public Carta (String i, char n, int num, boolean a) {
		
		this.imagem=i;
		this.naipe=n;
		this.numero=num;
		this.aberto=a;
		
	}
	
	public String toString() {
		
		String saida = "";
			
			switch(this.naipe) {
			
				case 'o': saida+="Ouro";
							break;
						  
				case 'e': saida+="Espada";
						  break;
						  
				case 'p': saida+="Paus";
					 	  break;
				
				case 'c': saida+="Copas";
						  break;
		
			}
			
		switch(this.numero) {
			
			case 1: saida+="AS";
			
					break;
					
			case 11: saida+="J";
			
					break;
					
			case 12: saida+="Q";
			
					break;
			
			case 13: saida+="K";
			
					break;
				
			default: saida+="Num: " +String.format("%d", this.numero);
					break;
			
		}
	
			
		return saida;
		
	}
	
	
		public String getImagem() {
			return this.imagem;
		}
		
		public void setImagem(String i) {
			this.imagem=i;
		}
	
		public char getNaipe() {
			return this.naipe;
		}
		
		public void setNaipe(char n) {
			this.naipe=n;
		}
		public int getNumero() {
			return this.numero;
		}
		
		public void setImagem(int num) {
			this.numero=num;
		}
	
		public boolean getAberto() {
			return this.aberto;
		}
		
		public void setAberto(boolean a) {
			this.aberto=a;
		}
}

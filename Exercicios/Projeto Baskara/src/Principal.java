import javax.swing.JOptionPane;

public class Principal {
	
		Equacao p = new Equacao();
		
		public void calculaDelta() {
			double a1 = p.getA();
			double a2 = p.getB();
			double a3 = p.getC();
			double delta = 0;
			delta = (Math.pow (a2, 2)) -4 * a1 * a3;
			p.setDelta(delta);
			
		}
		
		public int calculaRaizes() {
			double a1 = p.getA();
			double a2 = p.getB();
			double delta = p.getDelta();
			double x1 = 0;
			double x2 = 0;
			if(delta < 0)
				return 0;
			else {
				x1 = (-a2 + (Math.sqrt(delta)))/(2 * a1);
				x2 = (-a2 - (Math.sqrt(delta)))/(2 * a1);
			}
			p.setX1(x1);
			p.setX2(x2);
			return 1;
		}
		
		public void xInserir() {
			double a = 0, b = 0, c = 0;
	        String frase;
			boolean erro=true;
			
			do {
				
				try {
				
					frase=JOptionPane.showInputDialog(null, "\nInsira o coeficiente A: ");
					a=Double.parseDouble(frase);
			
					frase=JOptionPane.showInputDialog(null, "\nInsira o coeficiente B: ");
					b=Double.parseDouble(frase);
					
					frase=JOptionPane.showInputDialog(null, "\nInsira o coeficiente C: ");
					c=Double.parseDouble(frase);
					
					erro=false;
					
				}
				
				catch(NumberFormatException msg) {
					JOptionPane.showMessageDialog(null,"\nInforme somente números. Tente novamente!");
				}
				
				
			}while(erro);
			
	        p.setA(a);
	        p.setB(b);
	        p.setC(c);
			
		}
		
		public void Exibe() {
			String saida = "";
			saida = p.toStringDelta();
			JOptionPane.showMessageDialog(null, saida);
			
		}
		
		public void ExibeRaizes() {
			String saida = "";
			saida = p.toStringRaizes();
			JOptionPane.showMessageDialog(null, saida);
		}
		
		public void ExibeEquacao() {
			String saida = "";
			saida = p.toStringEquacao();
			JOptionPane.showMessageDialog(null, saida);
			ExibeRaizes();
		}
		
			
			
	public static void main(String[] args){
			
			Principal q = new Principal();
			char opte='0';
			
			while(opte!='5') {
				String opcao = JOptionPane.showInputDialog(null,
						"\n |----------|MENU|----------| \n\n"+
						"\n 1 - Inserir coef. a, b, c."+
						"\n 2 - Exibir o Delta."+
						"\n 3 - Exibir as Raizes."+
						"\n 4 - Exibir a Equacao e as Raizes."+
						"\n 5 - SAIR.");
				
				opte=opcao.charAt(0);
				switch(opte) {
					
					case '1': q.xInserir();
							  if(q.p.getA() == 0) {
								  JOptionPane.showInputDialog(null,"O coeficiente A nao pode ser igual a 0, aperte 1 para inserir novamente!");
								  q.xInserir();
							  }
								  
							  break;
							  
					case '2': q.calculaDelta();
							  q.Exibe();
							  break;
					
					case '3': int aux;
							  aux = q.calculaRaizes();
							  if(aux == 0)
								  JOptionPane.showInputDialog(null, "O Delta eh menor que 0, sendo assim, nao eh possivel resolver a funcao");
							  else
								  q.ExibeRaizes();
							  break;
							  	
					case '4': q.ExibeEquacao();
							  
							  break;
							  
					}
			}
		}


	}



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Jogo extends JFrame {
	
	private static final long serialVersionUID = -5492780116061103332L;
	List <Carta> morto = new ArrayList <Carta>();
	List <Carta> vetorA = new ArrayList <Carta>();
	List <Carta> vetorB = new ArrayList <Carta>();
	List <Carta> vetorC = new ArrayList <Carta>();
	List <Carta> vetorD = new ArrayList <Carta>();
	
	
	
	Baralho baralho;
	int i = 1;
	int j = 1;
	int x = 1;
	int k = 1;
	Carta c, aux, temp;
	JButton btFechado, btVazio, btAberto, btA, btVetor1, btVetor2, btVetor3, btVetor4;
	JButton btCriaUm, btCriaQuatro, btEmbaralha, btExibe, btLimpa;
	Icon iconeFechado, iconeAberto, iconeVazio, iconeCarta;
	
	public Jogo() {//construtor
		
		
		super ("Jogo de Cartas de Baralho.");
		setLayout(new BorderLayout());
		Icon iconeFechado = new ImageIcon(getClass().getResource("fechado.png"));
		Icon iconeVazio = new ImageIcon(getClass().getResource("fechado2.png"));
		btFechado = new JButton (iconeVazio);
		btAberto = new JButton (iconeVazio);
		btA = new JButton ();
		btVetor1 = new JButton (iconeVazio);
		btVetor2 = new JButton (iconeVazio);
		btVetor3 = new JButton (iconeVazio);
		btVetor4 = new JButton (iconeVazio);
		baralho = new Baralho();
		morto.clear();
		vetorA.clear();
		vetorB.clear();
		vetorC.clear();
		vetorD.clear();
		
		
		//adicionando bot�es no painel do centro
		JPanel painelcentro = new JPanel(new GridLayout(1,7,5,5));
		painelcentro.add(btFechado);
		painelcentro.add(btAberto);
		painelcentro.add(btA);
		painelcentro.add(btVetor1);
		painelcentro.add(btVetor2);
		painelcentro.add(btVetor3);
		painelcentro.add(btVetor4);
		add(painelcentro, BorderLayout.CENTER);
		
		// adicionando bot�es no painel do sul/flow
		JPanel painelsul = new JPanel(new FlowLayout());
		btCriaUm = new JButton ("Criar um naipe");
		btCriaQuatro = new JButton ("Criar 4 naipes");
		btEmbaralha = new JButton("Embaralhar");
		btLimpa = new JButton("Limpar baralho");
		btExibe = new JButton("Exibe");
		painelsul.add(btCriaUm);
		painelsul.add(btCriaQuatro);
		painelsul.add(btEmbaralha);
		painelsul.add(btLimpa);
		painelsul.add(btExibe);
		add(painelsul, BorderLayout.SOUTH);
		
		//adicionando funcionalidade nos buttons
		//botao cria um
		btCriaUm.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				baralho.zeraBaralho();
				baralho = new Baralho (1, 'c');
				btFechado.setIcon(iconeFechado);
				btAberto.setIcon(iconeVazio);
				
			}
		});
		
		//botao embaralha
		btEmbaralha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				baralho.embaralha();
			
			}
		});
		
		//botao cria 4 naipes
		btCriaQuatro.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				baralho.zeraBaralho();
				baralho = new Baralho(4,'c');
				btFechado.setIcon(iconeFechado);
				btAberto.setIcon(iconeVazio);
				
			}
		});
		
		//botao limpa baralho
		btLimpa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				baralho.zeraBaralho();
				morto.clear();
				btFechado.setIcon(iconeVazio);
				btAberto.setIcon(iconeVazio);
				btVetor1.setIcon(iconeVazio);
				btVetor2.setIcon(iconeVazio);
				btVetor3.setIcon(iconeVazio);
				btVetor4.setIcon(iconeVazio);
				vetorA.clear();
				vetorB.clear();
				vetorC.clear();
				vetorD.clear();
				i = 1;
				j = 1;
				k = 1;
				x = 1;
				
			}
		});
		
		//botao para exibir
		btExibe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String saida = baralho.toString();
				JOptionPane.showMessageDialog(null, saida);
				
			}
		});
	
		//botao fechado
		btFechado.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(baralho.quantidade() > 0) {
					
					c = baralho.getCarta(0);
					
					if(baralho.quantidade() == 0)
						btFechado.setIcon(iconeVazio);
					
					morto.add(c);
					String figura = c.getImagem();
					iconeAberto = new ImageIcon(getClass().getResource(figura));
					btAberto.setIcon(iconeAberto);
					
				}
			}
		});
		
	
		
		//botao vetorA
		btVetor1.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				c = morto.get((morto.size()	-1));
				if(vetorA.size() == 0) {
					if(c.getNumero() == 1) {
						if((morto.size() != 1 )) {
							aux = morto.get((morto.size() -2));
							String figure = aux.getImagem();
							iconeAberto = new ImageIcon(getClass().getResource(figure));
							btAberto.setIcon(iconeAberto);
						}
						else btAberto.setIcon(iconeVazio);
						vetorA.add(c);
						
						String figura = c.getImagem();
						
						iconeAberto = new ImageIcon(getClass().getResource(figura));
						btVetor1.setIcon(iconeAberto);
						
						morto.remove(c);
						if(morto.size() == 0)
							btAberto.setIcon(iconeVazio);

						
					}
	
				}
				else {
					temp = vetorA.get(0);
					if(temp.getNaipe() == c.getNaipe()) {
						if(c.getNumero() == (temp.getNumero() +i)) {
							if((morto.size() != 1 )) {
								
								aux = morto.get((morto.size() -2));
								String figure = aux.getImagem();
								iconeAberto = new ImageIcon(getClass().getResource(figure));
								btAberto.setIcon(iconeAberto);
							}
							else btAberto.setIcon(iconeVazio);
							vetorA.add(c);
							
							String figura = c.getImagem();
							
							iconeAberto = new ImageIcon(getClass().getResource(figura));
							btVetor1.setIcon(iconeAberto);
							
							morto.remove(c);
							if(morto.size() == 0)
								btAberto.setIcon(iconeVazio);
							i++;
						}
					}
					
				}
				if(vetorA.size() == 13 ) {
					btVetor1.setIcon(iconeFechado);
					JOptionPane.showMessageDialog(null,"Vitoria no naipe!");
				}
				if((vetorA.size()==13)&&(vetorB.size()==13)&&(vetorC.size()==13)&&(vetorD.size()==13)) {
					JOptionPane.showMessageDialog(null,"Você venceu o jogo, Parabéns!!");
					}
			}
	});
	
		
		btVetor2.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				c = morto.get((morto.size()	-1));
				if(vetorB.size() == 0) {
					if(c.getNumero() == 1) {
						if((morto.size() != 1 )) {
							aux = morto.get((morto.size() -2));
							String figure = aux.getImagem();
							iconeAberto = new ImageIcon(getClass().getResource(figure));
							btAberto.setIcon(iconeAberto);
						}
						else btAberto.setIcon(iconeVazio);
						vetorB.add(c);
						
						String figura = c.getImagem();
						
						iconeAberto = new ImageIcon(getClass().getResource(figura));
						btVetor2.setIcon(iconeAberto);
						
						morto.remove(c);
						if(morto.size() == 0)
							btAberto.setIcon(iconeVazio);

						
					}
	
				}
				else {
					temp = vetorB.get(0);
					if(temp.getNaipe() == c.getNaipe()) {
						if(c.getNumero() == (temp.getNumero() +j)) {
							if((morto.size() != 1 )) {
								
								aux = morto.get((morto.size() -2));
								String figure = aux.getImagem();
								iconeAberto = new ImageIcon(getClass().getResource(figure));
								btAberto.setIcon(iconeAberto);
							}
							else btAberto.setIcon(iconeVazio);
							vetorB.add(c);
							
							String figura = c.getImagem();
							
							iconeAberto = new ImageIcon(getClass().getResource(figura));
							btVetor2.setIcon(iconeAberto);
							
							morto.remove(c);
							if(morto.size() == 0)
								btAberto.setIcon(iconeVazio);
							j++;
						}
					}
					
				}
				if(vetorB.size() == 13 ) {
					btVetor2.setIcon(iconeFechado);
					JOptionPane.showMessageDialog(null,"Vitoria no naipe!");
				}
				if((vetorA.size()==13)&&(vetorB.size()==13)&&(vetorC.size()==13)&&(vetorD.size()==13)) {
					JOptionPane.showMessageDialog(null,"Você venceu o jogo, Parabéns!!");
					}
			}

		});
		
		btVetor3.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				c = morto.get((morto.size()	-1));
				if(vetorC.size() == 0) {
					if(c.getNumero() == 1) {
						if((morto.size() != 1 )) {
							aux = morto.get((morto.size() -2));
							String figure = aux.getImagem();
							iconeAberto = new ImageIcon(getClass().getResource(figure));
							btAberto.setIcon(iconeAberto);
						}
						else btAberto.setIcon(iconeVazio);
						vetorC.add(c);
						
						String figura = c.getImagem();
						
						iconeAberto = new ImageIcon(getClass().getResource(figura));
						btVetor3.setIcon(iconeAberto);
						
						morto.remove(c);
						if(morto.size() == 0)
							btAberto.setIcon(iconeVazio);

						
					}
	
				}
				else {
					temp = vetorC.get(0);
					if(temp.getNaipe() == c.getNaipe()) {
						if(c.getNumero() == (temp.getNumero() +k)) {
							if((morto.size() != 1 )) {
								
								aux = morto.get((morto.size() -2));
								String figure = aux.getImagem();
								iconeAberto = new ImageIcon(getClass().getResource(figure));
								btAberto.setIcon(iconeAberto);
							}
							else btAberto.setIcon(iconeVazio);
							vetorC.add(c);
							
							String figura = c.getImagem();
							
							iconeAberto = new ImageIcon(getClass().getResource(figura));
							btVetor3.setIcon(iconeAberto);
							
							morto.remove(c);
							if(morto.size() == 0)
								btAberto.setIcon(iconeVazio);
							k++;
						}
					}
					
				}
				if(vetorC.size() == 13 ) {
					btVetor3.setIcon(iconeFechado);
					JOptionPane.showMessageDialog(null,"Vitoria no naipe!");
				}
				if((vetorA.size()==13)&&(vetorB.size()==13)&&(vetorC.size()==13)&&(vetorD.size()==13)) {
					JOptionPane.showMessageDialog(null,"Você venceu o jogo, Parabéns!!");
					}
			}
		});
		
		btVetor4.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				c = morto.get((morto.size()	-1));
				if(vetorD.size() == 0) {
					if(c.getNumero() == 1) {
						if((morto.size() != 1 )) {
							aux = morto.get((morto.size() -2));
							String figure = aux.getImagem();
							iconeAberto = new ImageIcon(getClass().getResource(figure));
							btAberto.setIcon(iconeAberto);
						}
						else btAberto.setIcon(iconeVazio);
						vetorD.add(c);
						
						String figura = c.getImagem();
						
						iconeAberto = new ImageIcon(getClass().getResource(figura));
						btVetor4.setIcon(iconeAberto);
						
						morto.remove(c);
						if(morto.size() == 0)
							btAberto.setIcon(iconeVazio);

						
					}
	
				}
				else {
					temp = vetorD.get(0);
					if(temp.getNaipe() == c.getNaipe()) {
						if(c.getNumero() == (temp.getNumero() +x)) {
							if((morto.size() != 1 )) {
								
								aux = morto.get((morto.size() -2));
								String figure = aux.getImagem();
								iconeAberto = new ImageIcon(getClass().getResource(figure));
								btAberto.setIcon(iconeAberto);
							}
							else btAberto.setIcon(iconeVazio);
							vetorD.add(c);
							
							String figura = c.getImagem();
							
							iconeAberto = new ImageIcon(getClass().getResource(figura));
							btVetor4.setIcon(iconeAberto);
							
							morto.remove(c);
							if(morto.size() == 0)
								btAberto.setIcon(iconeVazio);
							x++;
						}
					}
					
				}
				if(vetorD.size() == 13 ) {
					btVetor4.setIcon(iconeFechado);
					JOptionPane.showMessageDialog(null,"Vitoria no naipe!");
				}
				if((vetorA.size()==13)&&(vetorB.size()==13)&&(vetorC.size()==13)&&(vetorD.size()==13)) {
					JOptionPane.showMessageDialog(null,"Você venceu o jogo, Parabéns!!");
				}
			}
			
		});
	}
	
	public static void main(String[] args) {
		
		Jogo j = new Jogo();
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(1000,400);
		j.setLocation(200,200);
		j.setVisible(true);

	}

}

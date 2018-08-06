package VersaoFinal;

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

public class Separar extends JFrame {
	private static final long serialVersionUID = -6061103332L;
	
	List <Carta> morto = new ArrayList <Carta>();
	List <Carta> naipe1 = new ArrayList <Carta>();
	List <Carta> naipe2 = new ArrayList <Carta>();
	List <Carta> naipe3 = new ArrayList <Carta>();
	List <Carta> naipe4 = new ArrayList <Carta>();
	
	int i = 1;
	int j = 1;
	int l = 1;
	int k = 1;
	Carta c, aux, aux2,aux3;
	Baralho baralho;
	
	JButton btFechado, btVazio, btAberto, btA, btNaipe1, btNaipe2, btNaipe3, btNaipe4;
	JButton btCriaUm, btCriaQuatro, btEmbaralha, btExibe, btLimpa, btExibeMorto;
	JButton btExibeNaipe1, btExibeNaipe2, btExibeNaipe3, btExibeNaipe4;
	Icon iconeFechado, iconeAberto, iconeVazio, iconeCarta;
	
	//Construtor separar
	public Separar() {
		super ("Separar Baralho");
		setLayout(new BorderLayout());
		Icon iconeFechado = new ImageIcon(getClass().getResource("fechado.png"));
		Icon iconeVazio = new ImageIcon(getClass().getResource("vazio.png"));
		btFechado = new JButton (iconeVazio);
		btAberto = new JButton (iconeVazio);
		btA = new JButton ();
		btNaipe1 = new JButton (iconeVazio);
		btNaipe2 = new JButton (iconeVazio);
		btNaipe3 = new JButton (iconeVazio);
		btNaipe4 = new JButton (iconeVazio);
		baralho = new Baralho();
		morto.clear();
		naipe1.clear();
		naipe2.clear();
		naipe3.clear();
		naipe4.clear();

		//adicionando os botões do painel centro
		JPanel painelcentro = new JPanel(new GridLayout(1,7,5,5));
		painelcentro.add(btFechado);
		painelcentro.add(btAberto);
		painelcentro.add(btA);
		painelcentro.add(btNaipe1);
		painelcentro.add(btNaipe2);
		painelcentro.add(btNaipe3);
		painelcentro.add(btNaipe4);
		add(painelcentro, BorderLayout.CENTER);
		
		// adicionando os botões do painel sul
		JPanel painelsul = new JPanel(new FlowLayout());
		//btCriaUm = new JButton ("Criar um naipe");
		btCriaQuatro = new JButton ("Criar 4 naipes");
		btEmbaralha = new JButton("Embaralhar");
		btLimpa = new JButton("Limpar Baralho");
		btExibe = new JButton("Exibe Baralho");
		btExibeMorto = new JButton("Exibe Morto");
		btExibeNaipe1 = new JButton("Exibe Naipe 1");
		btExibeNaipe2 = new JButton("Exibe Naipe 2");
		btExibeNaipe3 = new JButton("Exibe Naipe 3");
		btExibeNaipe4 = new JButton("Exibe Naipe 4");
		//painelsul.add(btCriaUm);
		painelsul.add(btCriaQuatro);
		painelsul.add(btEmbaralha);
		painelsul.add(btLimpa);
		painelsul.add(btExibe);
		painelsul.add(btExibeMorto);
		painelsul.add(btExibeNaipe1);
		painelsul.add(btExibeNaipe2);
		painelsul.add(btExibeNaipe3);
		painelsul.add(btExibeNaipe4);
		add(painelsul, BorderLayout.SOUTH);
		
		
		//botao cria um
		/*btCriaUm.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if((baralho.quantidade() + morto.size()) != 0)
						JOptionPane.showMessageDialog(null,"Você não pode criar mais naipes!");
						
					else {
						baralho.zeraBaralho();
						baralho = new Baralho (1, 'o');
						btFechado.setIcon(iconeFechado);
						btAberto.setIcon(iconeVazio);
						}
					}
				});*/
				
		//Adicionando funcionalidade nos botões
		//botao para embaralhar		
		btEmbaralha.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				if(baralho.quantidade()==0)
					JOptionPane.showMessageDialog(null, "O baralho está vazio, não é possivel embaralhar");
				else
					baralho.embaralha();				
			}
		});
		
		//botao para criar 4 naipes
		btCriaQuatro.addActionListener( new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if((naipe1.size()==13)&&(naipe2.size()==13)&&(naipe3.size()==13)&&(naipe4.size()==13))
					JOptionPane.showMessageDialog(null,"Para criar novos naipes você deve limpar o Baralho");
				
				if((baralho.quantidade() + morto.size()) != 0) 
					JOptionPane.showMessageDialog(null,"Você não pode criar mais naipes");
				
				else{
					baralho.zeraBaralho();
					baralho = new Baralho(4,'o');
					btFechado.setIcon(iconeFechado);
					btAberto.setIcon(iconeVazio);
				}
			}
		});
		
		//botao para limpar baralho
		btLimpa.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {	
				baralho.zeraBaralho();
				morto.clear();
				btFechado.setIcon(iconeVazio);
				btAberto.setIcon(iconeVazio);
				btNaipe1.setIcon(iconeVazio);
				btNaipe2.setIcon(iconeVazio);
				btNaipe3.setIcon(iconeVazio);
				btNaipe4.setIcon(iconeVazio);
				naipe1.clear();
				naipe2.clear();
				naipe3.clear();
				naipe4.clear();
				i = 1;
				j = 1;
				k = 1;
				l = 1;			
			}
		});
		
		//botao para exibir o baralho 
		btExibe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(baralho.quantidade() == 0)						
					JOptionPane.showMessageDialog(null,"O Baralho está vazio");
					
				else {		
					String saida = baralho.toString();
					JOptionPane.showMessageDialog(null, saida);
				}
			}
		});
				
		//botao para exibir o morto
		btExibeMorto.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				if(morto.size() == 0) {					 	
					JOptionPane.showMessageDialog(null, "O morto está vazio");
				}
				
				else {		
					String saida = morto.toString();
					JOptionPane.showMessageDialog(null, saida);			
					}	
				}
			});
		
		//botao para exibir o naipe 1
		btExibeNaipe1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(naipe1.size() == 0) {
					JOptionPane.showMessageDialog(null, "O naipe 1 está vazio");
				}
				
				else {
					String saida = naipe1.toString();
					JOptionPane.showMessageDialog(null, saida);
				}
						
			}
		});
			
		//botao para exibir o naipe 2
		btExibeNaipe2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if(naipe2.size() == 0) {
					JOptionPane.showMessageDialog(null, "O naipe 2 está vazio");
				}
			
				else {
					String saida = naipe2.toString();
					JOptionPane.showMessageDialog(null, saida);			
					}
			}
		});
				
		//botao para exibir o naipe 3
		btExibeNaipe3.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {			
				if(naipe3.size() == 0) {			
					JOptionPane.showMessageDialog(null, "O naipe 3 está vazio");		
				}
				
				else {
					String saida = naipe3.toString();
					JOptionPane.showMessageDialog(null, saida);				
					}
			}
		});
		
		//botao para exibir o naipe 4
		btExibeNaipe4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(naipe4.size() == 0) {			
					JOptionPane.showMessageDialog(null, "O naipe 4 está vazio");		
				}
				
				else {
					String saida = naipe4.toString();
					JOptionPane.showMessageDialog(null, saida);
					}
			}
		});
		
		//botao fechado (contem as cartas do baralho)
		btFechado.addActionListener( new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
		
				if(baralho.quantidade() > 0) {		
					btFechado.setIcon(iconeFechado);	
					c = baralho.getCarta(0);
						if(baralho.quantidade() == 0)
							btFechado.setIcon(iconeVazio);
				
						morto.add(c);
						String figura = c.getImagem();
						iconeAberto = new ImageIcon(getClass().getResource(figura));
						btAberto.setIcon(iconeAberto);			
							
						if((baralho.quantidade() == 0)&&(morto.size()>0)) {
							int i = 0;
							while(i<morto.size()){
								aux = morto.get(i);
								baralho.adcionar(aux);
								i++;
							}
							
							morto.clear();
							
							if(baralho.quantidade()==1) { 
								aux2 = baralho.getCarta(0);	
								morto.add(aux2);
								String figure = aux2.getImagem();
								iconeAberto = new ImageIcon(getClass().getResource(figure));
								btAberto.setIcon(iconeAberto);
								if(baralho.quantidade()==0)
									btFechado.setIcon(iconeVazio);
							}					
						}
					}	
				}	
		});
		
		
		//botao aberto (o morto)
		/*btAberto.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
				if(morto.size() > 0) {			
					if(morto.size() == 1) {
						c = morto.get(morto.size()-1);
						baralho.adcionar(c);
						btAberto.setIcon(iconeVazio);
					}
			
					else{
						c = morto.get(morto.size()-1);
						baralho.adcionar(c);
						aux = morto.get(morto.size()-2);		
						if(morto.size()==0)
							btAberto.setIcon(iconeVazio);
	
						String figura = aux.getImagem();
						iconeAberto = new ImageIcon(getClass().getResource(figura));
						btAberto.setIcon(iconeAberto);
					
					}
					btFechado.setIcon(iconeFechado);
				}	
				morto.remove(c);
				
			}
		});*/
	
		//botao naipe 1
		btNaipe1.addActionListener( new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				c = morto.get((morto.size()	-1));
				if(naipe1.size() == 0) {		
					if(c.getNumero() == 1) {			
						if((morto.size() != 1 )) {			
							aux = morto.get((morto.size() -2));
							String figure = aux.getImagem();
							iconeAberto = new ImageIcon(getClass().getResource(figure));
							btAberto.setIcon(iconeAberto);
						}
						else 
							btAberto.setIcon(iconeVazio);
	
						naipe1.add(c);
						String figura = c.getImagem();
						iconeAberto = new ImageIcon(getClass().getResource(figura));
						btNaipe1.setIcon(iconeAberto);	
						morto.remove(c);	
						if(morto.size() == 0)
						btAberto.setIcon(iconeVazio);
					}
				}
				else {
					aux2 = naipe1.get(0);		
					if(aux2.getNaipe() == c.getNaipe()) {
						if(c.getNumero() == (aux2.getNumero() +i)) {			
							if((morto.size() != 1 )) {			
								aux = morto.get((morto.size() -2));
								String figure = aux.getImagem();
								iconeAberto = new ImageIcon(getClass().getResource(figure));
								btAberto.setIcon(iconeAberto);
							}
							else 
								btAberto.setIcon(iconeVazio);
							
							naipe1.add(c);		
							String figura = c.getImagem();
							iconeAberto = new ImageIcon(getClass().getResource(figura));
							btNaipe1.setIcon(iconeAberto);						
							morto.remove(c);		
							if(morto.size() == 0)
								btAberto.setIcon(iconeVazio);
							i++;
						}
					}
				}
						
				if(naipe1.size() == 13) {
					JOptionPane.showMessageDialog(null,"Naipe Completo!");
					btNaipe1.setIcon(iconeFechado);
				}
				
				if((baralho.quantidade()==0)&&(morto.size() == 0))
					JOptionPane.showMessageDialog(null, "<<<<<<<<<<|VITÓRIA|>>>>>>>>>> \n Todos os naipes foram separados!" );
				
			}		
		});
		
		//botao naipe 2
		btNaipe2.addActionListener( new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				c = morto.get((morto.size()	-1));		
				if(naipe2.size() == 0) {			
					if(c.getNumero() == 1) {			
						if((morto.size() != 1 )) {			
							aux = morto.get((morto.size() -2));
							String figure = aux.getImagem();
							iconeAberto = new ImageIcon(getClass().getResource(figure));
							btAberto.setIcon(iconeAberto);								
						}
						else 
							btAberto.setIcon(iconeVazio);
						
						naipe2.add(c);		
						String figura = c.getImagem();
						iconeAberto = new ImageIcon(getClass().getResource(figura));
						btNaipe2.setIcon(iconeAberto);
						morto.remove(c);
						
						if(morto.size() == 0)
							btAberto.setIcon(iconeVazio);
					}
				}
				else {
					aux2 = naipe2.get(0);
					if(aux2.getNaipe() == c.getNaipe()) {
						if(c.getNumero() == (aux2.getNumero() +j)) {			
							if((morto.size() != 1 )) {
								aux = morto.get((morto.size() -2));
								String figure = aux.getImagem();
								iconeAberto = new ImageIcon(getClass().getResource(figure));
								btAberto.setIcon(iconeAberto);
							}
							else 
								btAberto.setIcon(iconeVazio);
							
							naipe2.add(c);
							String figura = c.getImagem();
							iconeAberto = new ImageIcon(getClass().getResource(figura));
							btNaipe2.setIcon(iconeAberto);
							morto.remove(c);								
							if(morto.size() == 0)
								btAberto.setIcon(iconeVazio);
							j++;
								}
							}				
						}
						
						if(naipe2.size() == 13) {
							JOptionPane.showMessageDialog(null,"Naipe Completo!");
							btNaipe2.setIcon(iconeFechado);
						}
			
						if((baralho.quantidade()==0)&&(morto.size() == 0))
							JOptionPane.showMessageDialog(null, "<<<<<<<<<<|VITÓRIA|>>>>>>>>>> \n Todos os naipes foram separados!");
						
					}
				});
				
		//botao naipe 3
		btNaipe3.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = morto.get((morto.size()	-1));
				if(naipe3.size() == 0) {	
					if(c.getNumero() == 1) {
						if((morto.size() != 1 )) {
							aux = morto.get((morto.size() -2));
							String figure = aux.getImagem();
							iconeAberto = new ImageIcon(getClass().getResource(figure));
							btAberto.setIcon(iconeAberto);
						}
						else 
							btAberto.setIcon(iconeVazio);
						
						naipe3.add(c);
						String figura = c.getImagem();
						iconeAberto = new ImageIcon(getClass().getResource(figura));
						btNaipe3.setIcon(iconeAberto);
						morto.remove(c);
						if(morto.size() == 0)
							btAberto.setIcon(iconeVazio);
					}
				}
				else {
					aux2 = naipe3.get(0);
					if(aux2.getNaipe() == c.getNaipe()) {							
						if(c.getNumero() == (aux2.getNumero() +k)) {			
							if((morto.size() != 1 )) {
								aux = morto.get((morto.size() -2));
								String figure = aux.getImagem();
								iconeAberto = new ImageIcon(getClass().getResource(figure));
								btAberto.setIcon(iconeAberto);
								}
								
							else 
								btAberto.setIcon(iconeVazio);
								
							naipe3.add(c);
							String figura = c.getImagem();
							iconeAberto = new ImageIcon(getClass().getResource(figura));
							btNaipe3.setIcon(iconeAberto);
							morto.remove(c);				
							if(morto.size() == 0)
								btAberto.setIcon(iconeVazio);
							
							k++;
							}
						}
							
					}
							
				if(naipe3.size() == 13) {
					JOptionPane.showMessageDialog(null,"Naipe Completo!");
					btNaipe3.setIcon(iconeFechado);
					}
				
				if((baralho.quantidade()==0)&&(morto.size() == 0))
					JOptionPane.showMessageDialog(null, "<<<<<<<<<<|VITÓRIA|>>>>>>>>>> \n Todos os naipes foram separados!" );
				
			}
		});
		
		//botao naipe 4
		btNaipe4.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = morto.get((morto.size()	-1));
				if(naipe4.size() == 0) {
					if(c.getNumero() == 1) {
						if((morto.size() != 1 )) {			
								aux = morto.get((morto.size() -2));
								String figure = aux.getImagem();
								iconeAberto = new ImageIcon(getClass().getResource(figure));
								btAberto.setIcon(iconeAberto);
									
						}
						else 
							btAberto.setIcon(iconeVazio);
			
						naipe4.add(c);
						String figura = c.getImagem();
						iconeAberto = new ImageIcon(getClass().getResource(figura));
						btNaipe4.setIcon(iconeAberto);				
						morto.remove(c);		
					
						if(morto.size() == 0)
							btAberto.setIcon(iconeVazio);
					}
			
				}
		
				else {
					aux2 = naipe4.get(0);
					if(aux2.getNaipe() == c.getNaipe()) {
						if(c.getNumero() == (aux2.getNumero() +l)) {
							if((morto.size() != 1 )) {
								aux = morto.get((morto.size() -2));
								String figure = aux.getImagem();
								iconeAberto = new ImageIcon(getClass().getResource(figure));
								btAberto.setIcon(iconeAberto);
							}
							else
								btAberto.setIcon(iconeVazio);
							
							naipe4.add(c);
							String figura = c.getImagem();
							iconeAberto = new ImageIcon(getClass().getResource(figura));
							btNaipe4.setIcon(iconeAberto);
							morto.remove(c);
						
						if(morto.size() == 0)
							btAberto.setIcon(iconeVazio);
				
						l++;
					}
				}
							
			}
			
			if(naipe4.size() == 13) {
				JOptionPane.showMessageDialog(null,"Naipe Completo!");
				btNaipe4.setIcon(iconeFechado);
				}
			
			if((baralho.quantidade()==0)&&(morto.size() == 0))
				JOptionPane.showMessageDialog(null, "<<<<<<<<<<|VITÓRIA|>>>>>>>>>> \n Todos os naipes foram separados!" );
			
			}
		});
			
	}				
	public static void main(String args[]) {
		Separar s = new Separar();
		
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setSize(1050,400);
		s.setLocation(200,200);
		s.setLocationRelativeTo(null);
		s.setVisible(true);

	}
}
	
	


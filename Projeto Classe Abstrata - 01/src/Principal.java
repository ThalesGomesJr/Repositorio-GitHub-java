import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Principal extends JFrame{
	JMenuBar barraprin;
	JMenu menuAss, menuCom, menuHor, menuRel;
	JMenuItem insAss, exiAss, insCom, exiCom, insHor, exiHor, exibeTodos;
	ArrayList<Empregado> Lista = new ArrayList<Empregado>();
	JDesktopPane aJanela;		
	public Principal() {
		super("Classe Abstrata Empregado");
		
		//Menu
		
		barraprin = new JMenuBar();
		barraprin.setBackground(Color.lightGray);
		setJMenuBar(barraprin);
		
		menuAss= new JMenu("Assalariado");
		menuCom= new JMenu("Comissionado");
		menuHor= new JMenu("Horista");
		menuRel= new JMenu("Relatorio");
		
		barraprin.add(menuAss);
		barraprin.add(menuCom);
		barraprin.add(menuHor);
		barraprin.add(menuRel);
		
		insAss = new JMenuItem("Insere Assalariado");
		exiAss = new JMenuItem("Exibe Assalariado");
		insCom = new JMenuItem("Insere Comissionado");
		exiCom = new JMenuItem("Exibe Comissionado");
		insHor = new JMenuItem("Insere Horista");
		exiHor = new JMenuItem("Exibe Horista");
		exibeTodos = new JMenuItem("Exibe folha de pagamento");
		
		menuAss.add(insAss);
		menuAss.add(exiAss);
		menuCom.add(insCom);
		menuCom.add(exiCom);
		menuHor.add(insHor);
		menuHor.add(exiHor);
		menuRel.add(exibeTodos);
		
		//Fim do menu
		
		//Janelas
		
		aJanela = new JDesktopPane();
		add(aJanela);
		
		
		eventosCadastro funcaoCad = new eventosCadastro();
		insAss.addActionListener(funcaoCad);
		insCom.addActionListener(funcaoCad);
		insHor.addActionListener(funcaoCad);
		
		
		eventosListagem funcaoLista = new eventosListagem();
		exiAss.addActionListener(funcaoLista);
		exiCom.addActionListener(funcaoLista);
		exiHor.addActionListener(funcaoLista);
		exibeTodos.addActionListener(funcaoLista);
		
		
		
		//Fim Janelas
		
	}
	

	private class eventosListagem implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int i;
			String saida = "\n Listagem \n";
		
			if(e.getSource() == exibeTodos) {
				for(i=0; i<Lista.size(); i++) {
					saida += Lista.get(i).toString() + "Salario = $" + Lista.get(i).vencto()+"\n\n";
				}
			}else if (e.getSource() == exiAss) {
				for(i=0; i<Lista.size(); i++) {
					if(Lista.get(i) instanceof Assalariado) {
						saida += Lista.get(i).toString() + "Salario = $" + Lista.get(i).vencto()+"\n\n";
					}
				}
			}else if(e.getSource() == exiHor) {
				for(i=0; i<Lista.size(); i++) {
					if(Lista.get(i) instanceof Horista) {
						saida += Lista.get(i).toString() + "Salario = $" + Lista.get(i).vencto()+"\n\n";
					}
				}
			}else if(e.getSource() == exiCom) {
				for(i=0; i<Lista.size(); i++) {
					if(Lista.get(i) instanceof Comissionado) {
						saida += Lista.get(i).toString() + "Salario = $" + Lista.get(i).vencto()+"\n\n";
					}
				}
			}
		
			JOptionPane.showMessageDialog(null, saida);
	}
}

	private class eventosCadastro implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JInternalFrame tela = new JInternalFrame("Insere na Lista", true, true, true, true);
			if(e.getSource() == insAss) {
				PainelAss painelAss = new PainelAss();
				tela.add(painelAss, BorderLayout.CENTER);
				tela.setSize(400, 300);
				tela.setVisible(true);
				aJanela.add(tela);
			}
			
			if(e.getSource() == insCom) {
				PainelCom painelCom = new PainelCom();
				tela.add(painelCom, BorderLayout.CENTER);
				tela.setSize(400, 300);
				tela.setVisible(true);
				aJanela.add(tela);
			}
			
			if(e.getSource() == insHor) {
				PainelHor painelHor = new PainelHor();
				tela.add(painelHor, BorderLayout.CENTER);
				tela.setSize(400, 300);
				tela.setVisible(true);
				aJanela.add(tela);
			}
			
			
		}
	}

	private class PainelAss extends JPanel{
		JButton buttOK;
		JLabel lNome, lSalMensal;
		JTextField tNome, tSalMensal;
		
		
		
		public PainelAss() {
			setLayout(new GridLayout(3, 2));
			lNome = new JLabel("Insira nome:");
			lSalMensal = new JLabel("Salario Mensal:");
			tNome = new JTextField(40);
			tSalMensal = new JTextField(20);
			buttOK = new JButton("Terminar");
			
			add(lNome);
			add(tNome);
			add(lSalMensal);
			add(tSalMensal);
			add(buttOK);
			
			buttOK.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String n = tNome.getText();
						String salario = tSalMensal.getText();
						float salmens = Float.parseFloat(salario);
						Assalariado a = new Assalariado(n, salmens);
						Lista.add(a);
						JOptionPane.showMessageDialog(null, "Empregado adicionado");
						tNome.setText("");
						tSalMensal.setText("");
					}
				}
			);
		}
	}
	
	private class PainelCom extends JPanel{
		JButton buttOK;
		JLabel lNome, lBrutoVendas, lTaxa;
		JTextField tNome, tBrutoVendas, tTaxa;
		
		public PainelCom() {
			setLayout(new GridLayout(4, 2));
			lNome = new JLabel("Insira nome:");
			lBrutoVendas = new JLabel("Bruto nas Vendas:");
			lTaxa = new JLabel("Taxa:");
			tNome = new JTextField(40);
			tBrutoVendas = new JTextField(20);
			tTaxa = new JTextField(20);
			buttOK = new JButton("Terminar");
			
			add(lNome);
			add(tNome);
			add(lBrutoVendas);
			add(tBrutoVendas);
			add(lTaxa);
			add(tTaxa);
			add(buttOK);
			
			buttOK.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String n = tNome.getText();
						String taxa = tTaxa.getText();
						String bv = tBrutoVendas.getText();
						
						float fTaxa = Float.parseFloat(taxa);
						float fbv = Float.parseFloat(bv);
						Comissionado a = new Comissionado(n, fbv, fTaxa);
						Lista.add(a);
						JOptionPane.showMessageDialog(null, "Empregado adicionado");
						tNome.setText("");
						tBrutoVendas.setText("");
						tTaxa.setText("");
					}
				}
			);
		}
	}
	
	private class PainelHor extends JPanel{
		JButton buttOK;
		JLabel lNome, lHorasTrab, lValHora;
		JTextField tNome, tHorasTrab, tValHora;
		
		public PainelHor() {
			setLayout(new GridLayout(4, 2));
			lNome = new JLabel("Insira nome:");
			lHorasTrab = new JLabel("Horas Trabalhadas:");
			lValHora = new JLabel("Valor da Hora:");
			tNome = new JTextField(40);
			tHorasTrab = new JTextField(20);
			tValHora = new JTextField(20);
			buttOK = new JButton("Terminar");
			
			add(lNome);
			add(tNome);
			add(lHorasTrab);
			add(tHorasTrab);
			add(lValHora);
			add(tValHora);
			add(buttOK);
			
			buttOK.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String n = tNome.getText();
						String htrab = tHorasTrab.getText();
						String vHora = tValHora.getText();
						
						int ftrab = Integer.parseInt(htrab);
						float fvHora = Float.parseFloat(vHora);
						Horista a = new Horista(n, ftrab, fvHora);
						Lista.add(a);
						JOptionPane.showMessageDialog(null, "Empregado adicionado");
						tNome.setText("");
						tHorasTrab.setText("");
						tValHora.setText("");
					}
				}
			);
		}
	}
	
	
	public static void main (String[] args) {
		Principal p = new Principal();
		p.setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setSize(600, 400);
		p.setLocation(400, 100);
		p.setVisible(true);
	}
}
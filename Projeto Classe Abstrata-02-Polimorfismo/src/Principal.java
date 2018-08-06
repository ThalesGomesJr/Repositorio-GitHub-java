//Principal
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
	JMenu menuFis, menuJur,menuRel;
	JMenuItem insFis, exiFis, insJur, exiJur,exibeTodos;
	ArrayList<Contribuinte> Lista = new ArrayList<Contribuinte>();
	JDesktopPane aJanela;	
	
	
	public Principal() {
		super("Calculo de Imposto de renda");
		
		//Menu
		
		barraprin = new JMenuBar();
		barraprin.setBackground(Color.lightGray);
		setJMenuBar(barraprin);
		
		menuFis= new JMenu("Pessoa Fisica");
		menuJur= new JMenu("Pessoa Juridica");
		menuRel= new JMenu("Relatorio");
		
		barraprin.add(menuFis);
		barraprin.add(menuJur);
		barraprin.add(menuRel);
		
		insFis = new JMenuItem("Insere Pessoa Fisica");
		exiFis = new JMenuItem("Exibe Pessoa Fisica");
		insJur = new JMenuItem("Insere Pessoa Juridica");
		exiJur = new JMenuItem("Exibe Pessoa Juridica");
		exibeTodos = new JMenuItem("Exibe folha de Impostos");
		
		menuFis.add(insFis);
		menuFis.add(exiFis);
		menuJur.add(insJur);
		menuJur.add(exiJur);
		menuRel.add(exibeTodos);
		
		//Fim do menu
		
		//Janelas
		aJanela = new JDesktopPane();
		add(aJanela);
		
		eventosCadastro funcaoCad = new eventosCadastro();
		insFis.addActionListener(funcaoCad);
		insJur.addActionListener(funcaoCad);
		
		
		eventosListagem funcaoLista = new eventosListagem();
		exiFis.addActionListener(funcaoLista);
		exiJur.addActionListener(funcaoLista);
		exibeTodos.addActionListener(funcaoLista);
		
		//Fim Janelas
	}
	

	private class eventosListagem implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int i;
			String saida = "\n Listagem \n";
		
			if(e.getSource() == exibeTodos) {
				for(i=0; i<Lista.size(); i++) {
					saida += Lista.get(i).toString() + "Imposto = $" + Lista.get(i).arrecadaImposto()+"\n\n";
				}
				
			}else if (e.getSource() == exiFis) {
				for(i=0; i<Lista.size(); i++) {
					if(Lista.get(i) instanceof PessoaFisica) {
						saida += Lista.get(i).toString() + "Imposto = $" + Lista.get(i).arrecadaImposto()+"\n\n";
					}
				}
				
			}else if(e.getSource() == exiJur) {
				for(i=0; i<Lista.size(); i++) {
					if(Lista.get(i) instanceof Juridica) {
						saida += Lista.get(i).toString() + "Imposto = $" + Lista.get(i).arrecadaImposto()+"\n\n";
					}
				}
			JOptionPane.showMessageDialog(null, saida);
			}
		}
	}
	
	private class eventosCadastro implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JInternalFrame tela = new JInternalFrame("Insere na Lista", true, true, true, true);
			if(e.getSource() == insFis) {
				PainelFis painelFis = new PainelFis();
				tela.add(painelFis, BorderLayout.CENTER);
				tela.setSize(400, 300);
				tela.setVisible(true);
				aJanela.add(tela);
			}
			
			if(e.getSource() == insJur) {
				PainelJur painelJur = new PainelJur();
				tela.add(painelJur, BorderLayout.CENTER);
				tela.setSize(400, 300);
				tela.setVisible(true);
				aJanela.add(tela);
			}
		}
	}

	private class PainelFis extends JPanel{
		JButton buttOK;
		JLabel lNome, lRendaBrutaAnual,lCpf,lNumD,lGastoSaude,lGastoEduca;
		JTextField tNome, tRendaBrutaAnual,tCpf,tNumD,tGastoSaude,tGastoEduca;
		
		
		
		public PainelFis() {
			setLayout(new GridLayout(8,3,5,5));
			lNome = new JLabel("Nome:");
			lCpf = new JLabel("CPF:");
			lNumD = new JLabel("Numero de dependentes:");
			lRendaBrutaAnual = new JLabel("Renda Bruta Anual:");
			lGastoSaude = new JLabel("Valor gasto com saude:");
			lGastoEduca = new JLabel("Valor gasto com Educação:");
			
			tNome = new JTextField(40);
			tCpf = new JTextField(14);
			tNumD = new JTextField(20);
			tRendaBrutaAnual = new JTextField(20);
			tGastoSaude = new JTextField(20);
			tGastoEduca = new JTextField(20);
			
			buttOK = new JButton("Concluir");
			
			add(lNome);
			add(tNome);
			add(lCpf);
			add(tCpf);
			add(lNumD);
			add(tNumD);
			add(lRendaBrutaAnual);
			add(tRendaBrutaAnual);
			add(lGastoSaude);
			add(tGastoSaude);
			add(lGastoEduca);
			add(tGastoEduca);
			add(buttOK);
			
			buttOK.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String n = tNome.getText();
						String rendaBrAnual = tRendaBrutaAnual.getText();
						String numDep = tNumD.getText();
						String gSaude = tGastoSaude.getText();
						String gEduca = tGastoEduca.getText();
						String cpf = tCpf.getText();
						float rB = 0;
						try {
							rB = Float.parseFloat(rendaBrAnual);
						}catch(NumberFormatException erro) {
        					rB = 0;
        				}
						int nD = 0;
						try {
							nD = Integer.parseInt(numDep);
						}catch(NumberFormatException erro) {
        					nD = 0;
        				}
						float gS = 0;
						try {
							gS = Float.parseFloat(gSaude);
						}catch(NumberFormatException erro) {
        					gS = 0;
        				}
						float gE = 0;
						try {
							gE = Float.parseFloat(gEduca);
						}catch(NumberFormatException erro) {
        					gE = 0;
        				}
						
						PessoaFisica a = new PessoaFisica(rB,n,nD,cpf,gS,gE);
						Lista.add(a);
						JOptionPane.showMessageDialog(null, "Pessoa Fisica cadastrada");
						tNome.setText("");
						tRendaBrutaAnual.setText("");
						tCpf.setText("");
						tNumD.setText("");
						tGastoSaude.setText("");
						tGastoEduca.setText("");
					}
				}
			);
		}
	}
	
	private class PainelJur extends JPanel{
		JButton buttOK;
		JLabel lNome, lRendaBrutaAnual,lCnpj,lGastoEmp,lGastoEqui;
		JTextField tNome,tRendaBrutaAnual,tCnpj,tGastoEmp,tGastoEqui;
		
		public PainelJur() {
			setLayout(new GridLayout(8,3,5,5));
			lNome = new JLabel("Nome da Empresa:");
			lRendaBrutaAnual = new JLabel("Renda Bruta Anual:");
			lCnpj = new JLabel("CNPJ:");
			lGastoEmp = new JLabel("Gasto com empregados:");
			lGastoEqui = new JLabel("Gasto com equipamentos:");
			tNome = new JTextField(40);
			tRendaBrutaAnual= new JTextField(20);
			tCnpj = new JTextField(20);
			tGastoEmp = new JTextField(20);
			tGastoEqui = new JTextField(20);
			buttOK = new JButton("Concluir");
			
			add(lNome);
			add(tNome);
			add(lRendaBrutaAnual);
			add(tRendaBrutaAnual);
			add(lCnpj);
			add(tCnpj);
			add(lGastoEmp);
			add(tGastoEmp);
			add(lGastoEqui);
			add(tGastoEqui);
			add(buttOK);
			
			buttOK.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String n = tNome.getText();
						String cnpj = tCnpj.getText();
						String rendaBrAnual = tRendaBrutaAnual.getText();
						String gEmp = tGastoEmp.getText();
						String gEqui = tGastoEqui.getText();
						float rB = 0;
						try {
							rB = Float.parseFloat(rendaBrAnual);
						}catch(NumberFormatException erro) {
        					rB = 0;
        				}
						
						float gEm = 0;
						try {
							gEm = Float.parseFloat(gEmp);
						}catch(NumberFormatException erro) {
        					gEm = 0;
        				}
						float gEq = 0;
						try {
							gEq = Float.parseFloat(gEqui);
						}catch(NumberFormatException erro) {
        					gEq = 0;
        				}
						
						Juridica a = new Juridica(rB,n,cnpj,gEm,gEq);
						Lista.add(a);
						JOptionPane.showMessageDialog(null, "Pessoa Juridica Cadastrada");
						tNome.setText("");
						tRendaBrutaAnual.setText("");
						tCnpj.setText("");
						tGastoEmp.setText("");
						tGastoEqui.setText("");
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

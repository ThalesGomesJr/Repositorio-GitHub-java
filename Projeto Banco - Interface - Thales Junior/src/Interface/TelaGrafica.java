package Interface;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//Classe principal de Tela Grafica 
public class TelaGrafica extends JFrame {
	JMenuBar barraPrin;
	JMenu menuCad, menuMov, menuRelatorio, menuSair;
	JMenuItem inCaixa, inCliente,inConta,iSaque, iDep, exiAutentica, exiClientes,iSair;
	JRadioButton rdContaCom,rdContaEsp;
	ButtonGroup grupo;
	//ArrayList de Contas
	ArrayList<ContaSimples> ListaConta = new ArrayList<ContaSimples>();
	//ArrayList de Clientes e Caixas
	ArrayList<Autentica> ListaAutentica = new ArrayList<Autentica>();
	//Declaração do JComboBox
	JComboBox<Cliente> combo = new JComboBox<Cliente>(); 

	JDesktopPane aJanela;
	Caixa caixa;
	Cliente cli;
	ContaSimples nConta;
	Autentica c;
	String senha = "admin";
	JPanel pContaCom, pContaEsp;
	
	//Inicio do construtor da tela grafica
	public TelaGrafica() {
		super("Banco Digital");
		String s = JOptionPane.showInputDialog(null,"Senha de adminstrador necessaria ");
		if(senha.equals(s)) {
			//Barra de JMenu
			barraPrin = new JMenuBar();
			barraPrin.setBackground(Color.cyan);
			setJMenuBar(barraPrin);
			
			//menu principal
			menuCad = new JMenu("Cadastro");
			menuMov = new JMenu("Movimento");
			menuRelatorio = new JMenu("Relatorio");
			menuSair= new JMenu("Sair");
			
			//adicionando os JMenus na barra principal
			barraPrin.add(menuCad);
			barraPrin.add(menuMov);
			barraPrin.add(menuRelatorio);
			barraPrin.add(menuSair);
			
			//Nomeando os JMenuIten
			inCaixa = new JMenuItem("Caixa");
			inCliente = new JMenuItem("Cliente");
			inConta = new JMenuItem("Criar conta");
			iSaque = new JMenuItem("Saque");
			iDep = new JMenuItem("Deposito");
			exiAutentica = new JMenuItem("Todas as autenticações realizadas");
			exiClientes = new JMenuItem("Todos os Clientes cadatrados");
			iSair = new JMenuItem("Sair do Sistema");
			
			//Adicionando os JMenuIten aos JMenus
			menuCad.add(inCaixa);
			menuCad.add(inCliente);
			menuCad.add(inConta);
			menuMov.add(iSaque);
			menuMov.add(iDep);
			menuRelatorio.add(exiAutentica);
			menuRelatorio.add(exiClientes);
			menuSair.add(iSair);
			
			aJanela = new JDesktopPane();
			add(aJanela);
			
			//adicionando eventos aos JMenuIten
			Eventos funcao = new Eventos();
			inCaixa.addActionListener(funcao);
			inCliente.addActionListener(funcao);
			inConta.addActionListener(funcao);
			iSaque.addActionListener(funcao);
			iDep.addActionListener(funcao);
			iSair.addActionListener(funcao);
			
			//adicionando evento aos JMenuiten de listagem 
			EventosListagem funcaoLista = new EventosListagem();
			exiAutentica.addActionListener(funcaoLista);
			exiClientes.addActionListener(funcaoLista);
		}
		else {
			JOptionPane.showMessageDialog(null,"Senha incorreta");
			System.exit(0);
		}
	}
		
	//Classe  para criar o evento de cada JMenuIten 	
	private class Eventos implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int i;
			JInternalFrame tela = new JInternalFrame("Insere", true, true, true, true);
			
			//JMenuIten inCaixa
			if(e.getSource() == inCaixa) {
				PainelCaixa painelCaixa = new PainelCaixa();
				tela.add(painelCaixa, BorderLayout.CENTER);
				tela.setSize(300, 200);
				tela.setVisible(true);
				aJanela.add(tela);
			}	
			
			//JMenuIten inCliente
			if(e.getSource() == inCliente) {
				PainelCliente painelCli = new PainelCliente();
				tela.add(painelCli, BorderLayout.CENTER);
				tela.setSize(300, 200);
				tela.setVisible(true);
				aJanela.add(tela);
			}
			
			//JMenuIten inConta
			if(e.getSource() == inConta) {
				PainelConta painelConta = new PainelConta();
				tela.add(painelConta, BorderLayout.CENTER);
				tela.setSize(480, 535);
				tela.setVisible(true);
				aJanela.add(tela);
			}
			
			//JMenuIten iSaque
			if(e.getSource() == iSaque) {
				String nConta = JOptionPane.showInputDialog(null,"Numero da conta para saque: ");
				//percorre o array de contas
				for(i=0; i<ListaConta.size();i++) {
					//Compara o numero de conta digitado 
					//aos numeros de conta existentes no array
					if(ListaConta.get(i).getNumConta().equals(nConta)) {
						String s = JOptionPane.showInputDialog(null,"Senha: ");
						//Compara a senha digitada 
						//as senhas existentes no array
						if(ListaConta.get(i).getCliente().autenticar(s)){
							String v = JOptionPane.showInputDialog(null,"Qual o valor do saque: ");
							float valor = Float.parseFloat(v);
							//Chama o metodo saque
							if(ListaConta.get(i).saque(valor)) {
								JOptionPane.showMessageDialog(null,"Saque realizado com sucesso");
								break;							
							}
							else{
								JOptionPane.showMessageDialog(null,"Saldo Insuficiente para saque do valor desejado");							
								break;
							}
						}						
						else {
							JOptionPane.showMessageDialog(null,"Senha incorreta");
							break;
						}
					}
				}
				if(i == ListaConta.size())
					JOptionPane.showMessageDialog(null,"Numero de conta não encontrado");
			}
		
			//JMenuIten iDep
			if(e.getSource() == iDep) {
				String nConta = JOptionPane.showInputDialog(null,"Numero da conta para deposito:");
				//percorre o array de contas
				for(i=0; i<ListaConta.size();i++) {
					//Compara o numero de conta digitado 
					//aos numeros de conta existentes no array
					if(ListaConta.get(i).getNumConta().equals(nConta)) {
							String v = JOptionPane.showInputDialog(null,"Valor que deseja depositar: ");
							float valor = Float.parseFloat(v);
							//Chama a funçaõ deposito
							ListaConta.get(i).deposito(valor);											
							JOptionPane.showMessageDialog(null,"Deposito realizado com sucesso");
							
						
					}
					
					if(i == ListaConta.size()) 
						JOptionPane.showMessageDialog(null,"Numero de conta não encontrado");
				}
			}
		
			//JMenuIten iSair
			if(e.getSource()==iSair) {
				System.exit(0);
			}
		}
	}
	
	//Adicionando os eventos nos JMenuIten de listagem
	private class EventosListagem implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int i;
			String saida = "\n Listagem \n";
		
			//Listagem de todas as autenticações realizadas
			if(e.getSource() == exiAutentica) {
				for(i=0; i<ListaAutentica.size(); i++) {
					saida += ListaAutentica.get(i).toString() +"\n\n";
				}	
			}
			
			//Listagem de todas as contas e saldos existentes
			if (e.getSource() == exiClientes) {
				for(i=0; i<ListaConta.size(); i++) {
					saida +=ListaConta.get(i).toString()+"\n\n";
				}
			}
				
			JOptionPane.showMessageDialog(null, saida);
		}
	}
	
	//Classe para adicionar função aos botões radio
	private class Botoesradio implements ItemListener{
        public void itemStateChanged(ItemEvent evento){
            if(evento.getSource()==rdContaCom) {
                pContaEsp.setVisible(false);
            	pContaCom.setVisible(true);
            }
            else { 
                pContaEsp.setVisible(true);
            	pContaCom.setVisible(true);
            }
        }
    }
	
	//Painel adicionar Caixa
	private class PainelCaixa extends JPanel{
		JButton buttOK;
		JLabel lNome, lSalario,lsenha;
		JTextField tNome, tSalario;
		JPasswordField senha;
			
		public PainelCaixa() {
			
			setLayout(new GridLayout(5, 3, 5, 5));
			lNome = new JLabel("Insira nome:");
			lSalario = new JLabel("Salario:");
			lsenha = new JLabel("Senha:");
			tNome = new JTextField(40);
			tSalario = new JTextField(20);
			senha = new JPasswordField(20);
			buttOK = new JButton("Concluir");
				
			add(lNome);
			add(tNome);
			add(lSalario);
			add(tSalario);
			add(lsenha);
			add(senha);
			add(buttOK);
				
			//Adiciona função ao botão OK
			buttOK.addActionListener(
				new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String n = tNome.getText();
							String salario = tSalario.getText();
							String s = new String(senha.getPassword());
						 
							float sal = Float.parseFloat(salario);
							
							Caixa caix = new Caixa(n,sal,s);
							ListaAutentica.add(caix);
							JOptionPane.showMessageDialog(null, "Caixa cadastrado");
							tNome.setText("");
							tSalario.setText("");
							senha.setText("");
						}
					}
				);
			}
		}
		
		//Painel para adicionar clientes
		private class PainelCliente extends JPanel{
			JButton buttOK;
			JLabel lNome, lcpf, lsenha;
			JTextField tNome, tcpf;
			JPasswordField senha;
			
			public PainelCliente() {
				
				setLayout(new GridLayout(5, 3, 5, 5));
				lNome = new JLabel("Insira nome:");
				tNome = new JTextField(40);
				lcpf = new JLabel("CPF:");
				tcpf = new JTextField(20);
				lsenha = new JLabel("Senha:");
				senha = new JPasswordField(20);
				
				buttOK = new JButton("Concluir");
				
				add(lNome);
				add(tNome);
				add(lcpf);
				add(tcpf);
				add(lsenha);
				add(senha);
				add(buttOK);
				
				//Adiciona função ao botão OK
				buttOK.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String n = tNome.getText();
							String c = tcpf.getText();
							String s = new String(senha.getPassword());
				            		
							Cliente cl = new Cliente (n,c,s);
							ListaAutentica.add(cl);
							//Adiciona o Cliente na JCombobox para selecionar e criar uma conta
							combo.addItem(cl);								
							JOptionPane.showMessageDialog(null, "Cliente cadastrado");
									
							tNome.setText("");
							tcpf.setText("");
							senha.setText("");
						}
					});
				}
		}
		
		//Painel para adicionar Contas
		private class PainelConta extends JPanel{
			JButton buttOK;
			JLabel  lNumC,lSaldo,lLimite,lcombo;
			JTextField tNumC,tSaldo,tLimite;
			Cliente c;
			
			public PainelConta() {
			
				rdContaCom = new JRadioButton("Conta Cliente Comum");
		        rdContaEsp = new JRadioButton("Conta Cliente Especial");
		        grupo = new ButtonGroup();
		        grupo.add(rdContaCom);
		        grupo.add(rdContaEsp);
		        
		        //Adiciona funcionalidade aos botões radio
		        Botoesradio tarefa = new Botoesradio();
				rdContaCom.addItemListener(tarefa);
				rdContaEsp.addItemListener(tarefa);
				
		        JPanel norte= new JPanel(new FlowLayout());
		        norte.add(rdContaCom);
		        norte.add(rdContaEsp);
		        add(norte,BorderLayout.NORTH);
		    
				pContaCom = new JPanel(new GridLayout(7, 2, 5, 5 ));	
				pContaCom.setVisible(false);
				pContaEsp = new JPanel(new GridLayout(7, 2 , 5, 5));
				pContaEsp.setVisible(false);
		        JPanel painelCentro = new JPanel(new GridLayout(4, 4, 5, 5));
		        painelCentro.add(pContaCom);
		        painelCentro.add(pContaEsp);
		        add(painelCentro,BorderLayout.CENTER);
		        JPanel painelok = new JPanel(new FlowLayout());
		        painelCentro.add(painelok);
		        
		        lcombo = new JLabel("Selecione o Cliente:");
				lNumC = new JLabel("Numero da Conta:");
				tNumC = new JTextField(20);
				lSaldo = new JLabel("Saldo:");
				tSaldo = new JTextField(40);
				lLimite = new JLabel("Limite:");
				tLimite = new JTextField(40);
				buttOK = new JButton("Concluir");
				
				pContaCom.add(lcombo);
				//Adiciona a JCombobox ao painel
				pContaCom.add(combo);
				pContaCom.add(lNumC);
				pContaCom.add(tNumC);
				pContaCom.add(lSaldo);
				pContaCom.add(tSaldo);
				pContaEsp.add(lLimite);
				pContaEsp.add(tLimite);
				
				painelok.add(buttOK);
		
				//Adiciona função ao botão OK
				buttOK.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//Instancia e cria um new Cliente
							//Para adicionar na Super Classe ContaSimples
							c  = new Cliente();
							String nC = tNumC.getText();
							String sl = tSaldo.getText();
					
							float saldo = Float.parseFloat(sl);
							
							//Se o botão radio Conta Comum estiver selecionado
							if(rdContaCom.isSelected()){	
								//Pega os dados do cliente selecionado na JCombobox
								c =  (Cliente) combo.getSelectedItem();
																	
								ContaSimples cS = new ContaSimples(c,nC,saldo);
								ListaConta.add(cS);		
								JOptionPane.showMessageDialog(null, "Cliente cadastrado");
							}
							
							//Se o botão radio Conta Especial estiver selecionado
							if(rdContaEsp.isSelected()){
								//Pega os dados do cliente selecionado na JCombobox
								c =  (Cliente) combo.getSelectedItem();
								
								String l = tLimite.getText();
								float lim = Float.parseFloat(l);	
								ContaEspecial cE = new ContaEspecial(c,nC,saldo,lim);
								ListaConta.add(cE);
								JOptionPane.showMessageDialog(null, "Cliente cadastrado");
							}
								
							tNumC.setText("");
							tSaldo.setText("");
							tLimite.setText("");
					}
				});
			}
		}
		
	 public static void main(String args[]) {
		  TelaGrafica t = new TelaGrafica();
		  t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  t.setSize(800,600);
		  t.setLocation(350,100);
		  t.setVisible(true);
	 }
}


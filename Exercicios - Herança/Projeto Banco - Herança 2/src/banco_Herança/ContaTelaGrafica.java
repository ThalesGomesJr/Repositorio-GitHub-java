package banco_Herança;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

public class ContaTelaGrafica extends JFrame{
	private static final long serialVersionUID = -6061103332L;
	//array de contas
	List <ContaCorrente> listaConta = new ArrayList<ContaCorrente>();
	//declaração dos botões
	JButton btExibe, btInsere, btDeposito, btSaque;
	JRadioButton rdContaCom,rdContaEsp;
	ButtonGroup grupo;
	JLabel lnumConta,lsaldo,lLim;
    JTextField tnumConta,tsaldo,tLim;
    JPanel painelContaCom;
    JPanel painelContaEsp;
    ContaCorrente conta;
    ContaEspecial contaE;
    
    public ContaTelaGrafica() {
    	super("Banco Digital");
    	//ContaCorrente conta;
    	//Parte sul
    	//listaConta.clear();
    	btExibe = new JButton("Exibe contas");
    	btInsere = new JButton("Insere");
        btDeposito = new JButton("Deposito");
        btSaque = new JButton("Saque");
        JPanel sul= new JPanel(new FlowLayout());
        sul.add(btExibe);
        sul.add(btInsere);
        sul.add(btDeposito);
        sul.add(btSaque);
        add(sul,BorderLayout.SOUTH);
        
        //Parte norte
        rdContaCom = new JRadioButton("Conta Comum");
        rdContaEsp = new JRadioButton("Conta Especial");
        grupo = new ButtonGroup();
        grupo.add(rdContaCom);
        grupo.add(rdContaEsp);
        JPanel norte= new JPanel(new FlowLayout());
        norte.add(rdContaCom);
        norte.add(rdContaEsp);
        add(norte,BorderLayout.NORTH);
        
        //Parte centro
        painelContaCom = new JPanel(new GridLayout(3,2,5,5));
        painelContaCom.setVisible(false);
        painelContaEsp = new JPanel(new GridLayout(2,2,5,5));
        JPanel painelCentro = new JPanel(new GridLayout(2,2,5,5));
        painelCentro.add(painelContaCom);
        painelCentro.add(painelContaEsp);
        add(painelCentro,BorderLayout.CENTER);
        
        //Painel Conta Comum
        lnumConta = new JLabel("------------|Numero da conta:");
        tnumConta = new JTextField();
        lsaldo = new JLabel("------------|Saldo:");
        tsaldo = new JTextField();
        painelContaCom.add(lnumConta);
        painelContaCom.add(tnumConta);
        painelContaCom.add(lsaldo);
        painelContaCom.add(tsaldo);
        painelContaEsp.setVisible(false);
        
        //Painel Conta especial
        lLim = new JLabel("------------|Limite:");
        tLim = new JTextField();
        painelContaEsp.add(lLim);
        painelContaEsp.add(tLim);
     
        Botoesradio tarefa = new Botoesradio();
        rdContaCom.addItemListener(tarefa);
        rdContaEsp.addItemListener(tarefa);    
        
        //Botão exibir contas comuns
        btExibe.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                 String saida = "-----|Lista de Contas comuns|-----";
                 int i=0;
                 for(ContaCorrente c:listaConta){
                     saida +="\n--|Conta:"+i+":"+c.toString()+"\n\n";
                     i++;
                 }
                 JTextArea area = new JTextArea(saida,20,10);
                 JOptionPane.showMessageDialog(null,area,"Lista de Contas comuns e Especiais",JOptionPane.INFORMATION_MESSAGE);
           } 
       }); 
        
        //Botão inserir
        btInsere.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                      float saldo = 0;
                      //Usei esse while para adicionar i ao numero da conta
                      //para impedir que seja adicionado mais de uma vez 
                      //o mesmo numero de conta
                      int i = -1;
                      while(i<=listaConta.size())
                    	  i++;
                      
                      String numConta = tnumConta.getText()+String.format("%d",i);
                      String s= tsaldo.getText();
                      //Converte o valor saldo inserido em String para float
                      try{
                          saldo= Float.parseFloat(s);
                      }catch(NumberFormatException erro){
                          saldo=0;
                      }
                     //Insere o limite em contas especiais
                      float limite = 0;
                      if(rdContaEsp.isSelected()){
                    	  String lim = tLim.getText();
                          try{
                        	  limite= Float.parseFloat(lim);
                          }catch(NumberFormatException erro){
                              limite=0;
                          }
                      }
                    //cria contas comuns com dados preencidos direto
                      if(rdContaCom.isSelected()){  
                          ContaCorrente c = new ContaCorrente(numConta,saldo);
                          listaConta.add(c);
                          i++;
                          JOptionPane.showMessageDialog(null,"Conta comum cadastrada com sucesso!");
                     }
                    //cria contas especiais com dados preencidos direto
                      if(rdContaEsp.isSelected()){ 
                          ContaEspecial ce = new ContaEspecial(numConta,saldo,limite);
                          listaConta.add(ce);
                          JOptionPane.showMessageDialog(null,"Conta especial cadastrada com sucesso!");
                      }
                    }
                  
              });
      
         //Botão deposito 
        btDeposito.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String nCont = JOptionPane.showInputDialog(null,"Qual o Numero da conta?");
        		ContaCorrente nConta;
        		float valor = 0;
        		//Percorre o array de contas
        		for(int i = 0;i<listaConta.size();i++) {
        			nConta = listaConta.get(i);
        			//Compara para saber se a conta existe
        			if(nConta.getNumConta().equals(nCont)) {  
        				//Lê o valor para ser depositado
        				String v = JOptionPane.showInputDialog(null,"Conta localizada. Qual o valor do deposito?");
        				//Converte o valor de String para float
        				try {
        					valor = Float.parseFloat(v);
        				}catch(NumberFormatException erro) {
        					valor = 0;
        				}
        				//Chama a função deposito da SuperClasse ContaCorrente
        		        nConta.deposito(valor);
        		        listaConta.set(i,nConta);
        			}
        		}
        	}
        });
        
        //Botão de saque
        btSaque.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String nCont = JOptionPane.showInputDialog(null,"Qual o Numero da conta?");
        		ContaCorrente nConta; 
        		float valor = 0;
        		//Percorre o vetor para encontrar a conta digitada
        		for(int i = 0;i<listaConta.size();i++) {
        			//passa uma posição do array para a variavel
        			nConta = listaConta.get(i);
        			//Compara se os numeros de contas no array é equivalente a conta digitada
        			if(nConta.getNumConta().equals(nCont)) { 
        				//Lê o valor para ser depositado
        		    	String v = JOptionPane.showInputDialog(null,"Conta localizada. Qual o valor do saque?");
        				//Converte o valor de String para float
        		    	try {
        					valor = Float.parseFloat(v);
        				}catch(NumberFormatException erro) {
        					valor = 0;
        				}
        		    	//Recebe a resposta do metodo boolean saque
        				if(nConta.saque(valor)) {
        					JOptionPane.showMessageDialog(null,"Saque feito com sucesso");
        					listaConta.set(i,nConta);
        				} else
        					JOptionPane.showMessageDialog(null,"Saldo insuficente para saque do valor desejado");
        				
        			}// se achou a conta
        		}// for do vetor listaConta
        	}
        });
    }//construtor tela grafica

    private class Botoesradio implements ItemListener{
        public void itemStateChanged(ItemEvent evento){
            if(evento.getSource()==rdContaCom) {
                painelContaEsp.setVisible(false);
            	painelContaCom.setVisible(true);
            }
            else { 
                painelContaEsp.setVisible(true);
            	painelContaCom.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        ContaTelaGrafica c = new ContaTelaGrafica();
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setSize(450,350);
        c.setLocation(400,200);
        c.setVisible(true);
    }
	
}

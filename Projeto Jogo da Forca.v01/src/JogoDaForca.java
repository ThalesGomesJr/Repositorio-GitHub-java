
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoDaForca extends JFrame {
	private String palavra;
	JButton jbotao[];
	Icon iForca;
	JButton btOk;
	JLabel lLetra, lforca;
    JTextField tLetra;
    JPanel pCentro, pSul, pNorte;
    int acerto = 0;
    int erro = 0;
    ButtonGroup grupo;
    //JLabel.setIcon(iForca);
    public JogoDaForca() {
    	super ("Jogo da Forca");
		setLayout(new BorderLayout());

		palavra = JOptionPane.showInputDialog(null,"Qual a Palavra:");
		jbotao = new JButton[palavra.length()];
		
		
		pSul = new JPanel(new FlowLayout());
		lLetra = new JLabel("Entre com a letra:");
		tLetra = new JTextField(5);
    	btOk = new JButton("OK");
    	pSul.add(lLetra);
    	pSul.add(tLetra);
    	pSul.add(btOk);	
    	add(pSul, BorderLayout.SOUTH);
	    //-------------------------------------------
    	pCentro = new JPanel(new FlowLayout());
    	int i;
    	JPanel pbotao = new JPanel(new FlowLayout());
    	pbotao.setBackground(Color.RED);
    	for (i=0;i<palavra.length();i++) {
    		jbotao[i] = new JButton(String.format(""));
    		pbotao.add(jbotao[i]);
    	}
   
    	lforca = new JLabel(new ImageIcon(getClass().getResource("branco.png")));
 		lforca.setPreferredSize(new Dimension (180,305));
 		pCentro.add(lforca);    	
 		pCentro.add(pbotao);
 		add(pCentro,BorderLayout.CENTER);
 	
 		
 	    
    	btOk.addActionListener(
    			new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
    					char l = tLetra.getText().charAt(0);
    					if (l==' ') l = tLetra.getText().charAt(1);
    					int posicao = palavra.indexOf(l);
    					boolean status = false;
    					while(posicao!=-1) {
    						jbotao[posicao].setText(String.format("%s",l));
    						posicao = palavra.indexOf(l,posicao+1);
    						//JOptionPane.showMessageDialog(null,String.format( "nao sai do while posicao= %d", posicao));
    						status = true;
    						acerto++;
    					}
    					
    					if(!status) 
    						erro++;
   
    					switch(erro) {
    						case 1:iForca = new ImageIcon(getClass().getResource("soTronco.jpg"));
    								lforca.setIcon(iForca);
    								break;
    						case 2:iForca = new ImageIcon(getClass().getResource("troncoUmaPerna.jpg"));
    								lforca.setIcon(iForca);
    								break;
    						case 3:iForca = new ImageIcon(getClass().getResource("troncoDuasPernas.jpg"));
    						   		lforca.setIcon(iForca);
    						   		break;
    						case 4:iForca = new ImageIcon(getClass().getResource("semUmBraço.jpg"));
    					       		lforca.setIcon(iForca);	
    					       		break;
    						case 5:iForca = new ImageIcon(getClass().getResource("semCabeça.jpg"));
    					       		lforca.setIcon(iForca);	
    					       		break;
    						case 6:iForca = new ImageIcon(getClass().getResource("bonecoCompleto.jpg"));
    								lforca.setIcon(iForca); 
    								break;
    					}
    				
    				tLetra.setText("");
    				if(erro == 6)
    					JOptionPane.showMessageDialog(null," Fim de Jogo \n Você perdeu");
    				
    			}			
    		});       
    	}
    
	public static void main (String[] args) {
			JogoDaForca f = new JogoDaForca();
			f.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setSize(600, 400);
			f.setLocation(400, 100);
			f.setVisible(true);
		}
	}	




package Versao01;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoDaVelha extends JFrame implements ActionListener {
	private static final long serialVersionUID = -6061103332L;
	
	private JButton btMat[][] = new JButton[3][3];
	private Icon iUsuario, iComputador;
	private int vetlinU[] = new int[3];
	private int vetcolU[] = new int[3];
	private int vetlinC[] = new int[3];
	private int vetcolC[] = new int[3];
	private int diagPrincU;
	private int diagPrincC;
	private int diagSecU;
	private int diagSecC;
	private boolean matbool[][] = new boolean[3][3];
	private boolean v;

	
	public JogoDaVelha(){
		super("Jogo da Velha");
		setLayout(new GridLayout(3,3,2,2));
		iniciar();
		componentes();
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++){
				add(btMat[i][j]);
			}
		
	}
	//Inicia o jogo
	public void iniciar(){
		int i,j;
		diagPrincU = 0;
		diagPrincC = 0;
		diagSecU = 0;
		diagSecC = 0;
		
		for(i=0;i<3;i++){
			vetlinU[i] = 0;
			vetcolU[i] = 0;
			vetlinC[i] = 0;
			vetcolC[i] = 0;
		}
		
		for(i=0;i<3;i++){
			for(j=0;j<3;j++) {
				matbool[i][j] = false;
			}
		}
	}
	//Verifica se existe vencedor
	public boolean vencedor(){
		
		if((diagPrincU == 3)||(diagSecU == 3)){
			String saida = "Você Venceu";
			JOptionPane.showMessageDialog(null, saida);
			return true;
		}
		
		for(int i=0;i<3;i++){
			if((vetlinU[i] == 3)||(vetcolU[i] == 3)){
				String saida = "Você Venceu";
				JOptionPane.showMessageDialog(null, saida);
				return true;
			}
		}
		
		if((diagPrincC == 3)||(diagSecC == 3)){
			String saida = "Computador Venceu";
			JOptionPane.showMessageDialog(null, saida);
			return true;
		}
		
		for(int i=0;i<3;i++){
			if((vetlinC[i] == 3)||(vetcolC[i] == 3)){
				String saida = "Computador Venceu";
				JOptionPane.showMessageDialog(null, saida);
				return true;
			}
		}
		return false;
	}
	
	public boolean cheia(){
		int i, j;
		for(i=0;i<3;i++){
			for(j=0;j<3;j++){
				if(matbool[i][j] == false)
					return false;
			}
		}
		return true;
	}
	//Cria as imagens dos componentes
	public void componentes(){
		int i, j;
		iUsuario = new ImageIcon(getClass().getResource("usuario.png"));
		iComputador = new ImageIcon(getClass().getResource("computador.png"));
		
		for(i=0;i<3;i++)
			for(j = 0; j < 3; j++){
				btMat[i][j] = new JButton();
				btMat[i][j].addActionListener(this);
			}
	}
	//recomeÃ§a o jogo
	public void recomecar() {
		int resposta;
		resposta = JOptionPane.showConfirmDialog(null, "Jogar novamente?", null, JOptionPane.YES_NO_OPTION);
		if(resposta == JOptionPane.YES_OPTION) {
			int res;
			iniciar();
			for(int i=0;i<3;i++)
				for(int j=0;j<3;j++)
					btMat[i][j].setIcon(null);
			
			res = JOptionPane.showConfirmDialog(null, "Deseja começar?", null, JOptionPane.YES_NO_OPTION);
	        if (res == JOptionPane.NO_OPTION) {
	        	v = false;
	        	computador();
	        }
	        else v = true;
		}
		
		if(resposta == JOptionPane.NO_OPTION)
			System.exit(0);
		if(resposta == JOptionPane.CLOSED_OPTION)
			System.exit(0);
	}
	//Sequencia de mÃ©todos de jogo do computador
	public void aJogadaComputador() {
		if(matbool[1][1] == false) {
			btMat[1][1].setIcon(iComputador);
			vetlinC[1]++;
			vetcolC[1]++;
			diagPrincC++;
			diagSecC++;
			matbool[1][1] = true;
		}
		
		else{
			btMat[2][0].setIcon(iComputador);
			vetlinC[2]++;
			vetcolC[0]++;
			diagSecC++;
			matbool[2][0] = true;
		}
	}
	
	public boolean bJogadaComputador() {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++) {
				if(matbool[i][j] == false) {
					btMat[i][j].setIcon(iComputador);
					vetlinC[i]++;
					vetcolC[j]++;
					if(i == j)
						diagPrincC++;
					if((i + j) == 2)
						diagSecC++;
					matbool[i][j] = true;
					return true;
				}
			}
		return false;
	}
	
	public boolean computadorAtaca(){
		int i, j;
		for(i=0;i<3;i++){
			if(vetlinC[i] == 2){
				for(j=0;j<3;j++){
					if(matbool[i][j] == false){
						btMat[i][j].setIcon(iComputador);
						vetlinC[i] ++;
				        vetcolC[j] ++;
				   		if(i == j)	
				   			diagPrincC ++;
				   		if((i + j) == 2)  
				        	diagSecC ++;
				   		matbool[i][j] = true;
						return true;	
					}
				}
			}
		}
		for(i=0;i<3;i++){
			if(vetcolC[i] == 2){
				for(j=0;j<3;j++){
					if(matbool[j][i] == false){
						btMat[j][i].setIcon(iComputador);
						vetlinC[j] ++;
				        vetcolC[i] ++;
				        if(i == j)	
				        	diagPrincC ++;
				        if((i + j) == 2)
				        	diagSecC ++;
				        matbool[j][i] = true;
						return true;		
					}
				}			
			} 
		}
				
		if(diagPrincC == 2){
			for(i=0;i<3;i++)
				for(j=0;j<3;j++){
					if((i == j) && (matbool[i][j] == false)){
						btMat[i][j].setIcon(iComputador);
						vetlinC[i] ++;
				        vetcolC[j] ++;
				        diagPrincC ++;
				        if((i + j) == 2)
				        	diagSecC ++;
				        matbool[i][j] = true;
						return true;	
					}
				}
		}
					
		if(diagSecC == 2){
			for(i=0;i<3;i++)
				for(j=0;j<3;j++){
					if(((i + j) == 2) && (matbool[i][j] == false)){
						btMat[i][j].setIcon(iComputador);
						vetlinC[i] ++;
				        vetcolC[j] ++;
				        if(i == j)
				        	diagPrincC ++;
				        diagSecC ++;
				        matbool[i][j] = true;
				        return true;
					}
				}
		}
		return false;
	}
	
	public boolean  computadorDefende(){
		int i, j;
		for(i=0;i<3;i++){
			if(vetlinU[i] == 2){
				for(j=0;j<3;j++){
					if(matbool[i][j] == false){
						 btMat[i][j].setIcon(iComputador);
						vetlinC[i] ++;
		        		vetcolC[j] ++;
		        		if(i == j)
		        			diagPrincC ++;
		        		if((i + j) == 2)
		        			diagSecC ++;
		        		matbool[i][j] = true;
		        		return true;
					}
				}
			}
		}
		for(i = 0; i < 3; i++){	
			if(vetcolU[i] == 2){
				for(j = 0; j < 3; j++){
					if(matbool[j][i] == false){
						btMat[j][i].setIcon(iComputador);
						vetlinC[j] ++;
		        		vetcolC[i] ++;
		        		if(i == j)
		        			diagPrincC ++;   		
		        		if((i + j) == 2)
		        			diagSecC ++;
		        		matbool[j][i] = true;
						return true;
					}
				}
			}
			
		}
	
		if(diagPrincU == 2){
			for(i=0;i<3;i++)
				for(j=0;j<3;j++){
					if((i == j) && (matbool[i][j] == false)){
						btMat[i][j].setIcon(iComputador);
						matbool[i][j] = true;
						vetlinC[i] ++;
		        		vetcolC[j] ++;
		        		if(i == j)
		        			diagPrincC ++;
		        		if((i + j) == 2)
		        			diagSecC ++;
		        		matbool[i][j] = true;
						return true;
					}
				}
			}
	
	
		if(diagSecU == 2){
			for(i=0;i<3;i++)
				for(j=0;j<3;j++){
					if(((i + j) == 2) && (matbool[i][j] == false)){
						btMat[i][j].setIcon(iComputador);
						vetlinC[i] ++;
		        		vetcolC[j] ++;
		        		if(i == j)
		        			diagPrincC ++;
		        		if((i + j) == 2)
		        			diagSecC ++;
		        		matbool[i][j] = true;
						return true;
					}
					
				}
		}
		return false;
	
	}
	
	public boolean matrizBool(boolean m00, boolean m01, boolean m02, boolean m10, boolean m11, boolean m12, boolean m20, boolean m21, boolean m22) {
		if((matbool[0][0] == m00) && (matbool[0][1] == m01) && (matbool[0][2] == m02) && (matbool[1][0] == m10) && (matbool[1][1] == m11) && (matbool[1][2] == m12) && (matbool[2][0] == m20) && (matbool[2][1] == m21) && (matbool[2][2] == m22))
			return true;
		else return false;
	}
	//MÃ©todo para o computador nunca perder
	public boolean nuncaPerder(){
		if(matrizBool(false, false, true, false, true, false, true, false, false)) {
			if((btMat[0][2].getIcon().equals(iUsuario))&&(btMat[1][1].getIcon().equals(iUsuario))&&(btMat[2][0].getIcon().equals(iComputador))) {
				if(v == true) {
					btMat[2][2].setIcon(iComputador);
					vetlinC[2]++;
					vetcolC[2]++;
					diagPrincC++;
					matbool[2][2] = true;
					return true;
				}
			}
			else if((btMat[0][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][0].getIcon().equals(iUsuario))) {
				btMat[0][1].setIcon(iComputador);
				vetlinC[0]++;
				vetcolC[1]++;
				matbool[0][1] = true;
				return true;
			}
		}
		if(matrizBool(false, false, true, false, true, false, false, false, false)) {
			if((btMat[0][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador))){
				btMat[2][1].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[1]++;
				matbool[2][1] = true;
				return true;
				
			}
			
		}
		if((matrizBool(false, true, false, false, true, false, false, false, false))){
			if((btMat[0][1].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador))) {
				if(v == true) {
					btMat[0][0].setIcon(iComputador);
					vetlinC[0]++;
					vetcolC[0]++;
					diagPrincC++;
					matbool[0][0] = true;
					return true;
				}
			}
		}
		if((matrizBool(true, true, false, false, true, false, false, false, true))){
			if((btMat[0][0].getIcon().equals(iComputador)) && (btMat[0][1].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][2].getIcon().equals(iUsuario))) {
				btMat[1][0].setIcon(iComputador);
				vetlinC[1]++;
				vetcolC[0]++;
				matbool[1][0] = true;
				return true;
			}
		}
	
		if((matrizBool(false, false, true, false, true, false, false, false, false))){
			if((btMat[0][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador))) {
				btMat[1][0].setIcon(iComputador);
				vetlinC[1]++;
				vetcolC[0]++;
				diagPrincC++;
				matbool[1][0] = true;
				return true;
			}
		}
		if((matrizBool(false, false, false, true, true, false, false, false, false))){
			if((btMat[1][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador))) {
				btMat[2][0].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[0]++;
				diagSecC++;
				matbool[2][0] = true;
				return true;
			}
		}
		if((matrizBool(false, false, true, true, true, false, true, false, false))){
			if((btMat[0][2].getIcon().equals(iUsuario)) && (btMat[1][0].getIcon().equals(iUsuario)) &&(btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][0].getIcon().equals(iComputador))) {
				btMat[2][1].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[1]++;
				matbool[2][1] = true;
				return true;
			}
		}
		if((matrizBool(false, false, false, false, true, true, false, false, false))){
			if((btMat[1][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador))) {
				btMat[2][2].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[2]++;
				diagPrincC++;
				matbool[2][2] = true;
				return true;
			}
		}
		if((matrizBool(true, false, false, false, true, true, false, false, true))){
			if((btMat[0][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[1][2].getIcon().equals(iUsuario)) && (btMat[2][2].getIcon().equals(iComputador))) {
				btMat[2][1].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[1]++;
				matbool[2][1] = true;
				return true;
			}
		}
		if((matrizBool(false, false, false, false, true, false, true, false, false))){
			if((btMat[2][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador))) {
				btMat[0][1].setIcon(iComputador);
				vetlinC[0]++;
				vetcolC[1]++;
				matbool[0][1] = true;
				return true;
			}
		}
		if((matrizBool(false, false, false, false, true, false, false, true, false))){
			if((btMat[2][1].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador))) {
				btMat[2][0].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[0]++;
				diagSecC++;
				matbool[2][0] = true;
				return true;
			}
		}
		if((matrizBool(false, false, true, false, true, false, true, true, false))){
			if((btMat[0][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][0].getIcon().equals(iComputador)) && (btMat[2][1].getIcon().equals(iUsuario))) {
				btMat[1][0].setIcon(iComputador);
				vetlinC[1]++;
				vetcolC[0]++;
				matbool[1][0] = true;
				return true;
			}
		}
		if((matrizBool(false, true, false, false, true, false, false, false, false))){
			if((btMat[0][1].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador))) {
				btMat[0][0].setIcon(iComputador);
				vetlinC[0]++;
				vetcolC[0]++;
				diagPrincC++;
				matbool[0][0] = true;
				return true;
			}
		}
		if((matrizBool(true, true, false, false, true, false, false, false, true))){
			if((btMat[0][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][0].getIcon().equals(iComputador)) && (btMat[2][1].getIcon().equals(iUsuario))) {
				btMat[1][0].setIcon(iComputador);
				vetlinC[1]++;
				vetcolC[0]++;
				matbool[1][0] = true;
				return true;
			}
		}
		if((matrizBool(false, true, false, false, true, false, true, false, false))){
			if((btMat[0][1].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][0].getIcon().equals(iComputador))) {
				btMat[0][0].setIcon(iComputador);
				vetlinC[0]++;
				vetcolC[0]++;
				diagPrincC++;
				matbool[0][0] = true;
				return true;
			}
		}
		if((matrizBool(false, true, false, false, true, false, false, true, false))){
			if((btMat[0][1].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][1].getIcon().equals(iUsuario))) {
				btMat[0][0].setIcon(iComputador);
				vetlinC[0]++;
				vetcolC[0]++;
				diagPrincC++;
				matbool[0][0] = true;
				return true;
			}
		}
		if((matrizBool(false, true, false, false, true, false, false, false, true))){
			if((btMat[0][1].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][2].getIcon().equals(iUsuario))) {
				btMat[1][0].setIcon(iComputador);
				vetlinC[1]++;
				vetcolC[0]++;
				matbool[1][0] = true;
				return true;
			}
		}
		if((matrizBool(true, false, false, false, true, false, false, true, false))){
			if((btMat[0][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][1].getIcon().equals(iUsuario))) {
				btMat[1][2].setIcon(iComputador);
				vetlinC[1]++;
				vetcolC[2]++;
				matbool[1][2] = true;
				return true;
			}
		}
		
		if((matrizBool(false, false, true, false, true, false, false, true, false))){
			if((btMat[0][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][1].getIcon().equals(iUsuario))) {
				btMat[1][0].setIcon(iComputador);
				vetlinC[1]++;
				vetcolC[0]++;
				matbool[1][0] = true;
				return true;
			}
		}
		
		if((matrizBool(true, false, false, false, true, false, false, false, true))){
			if((btMat[0][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][2].getIcon().equals(iUsuario))) {
				btMat[0][1].setIcon(iComputador);
				vetlinC[0]++;
				vetcolC[1]++;
				matbool[0][1] = true;
				return true;
			}
		}
		
		if((matrizBool(false, false, false, true, true, true, false, false, false))){
			if((btMat[1][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[1][2].getIcon().equals(iUsuario))) {
				btMat[0][0].setIcon(iComputador);
				vetlinC[0]++;
				vetcolC[0]++;
				diagPrincC++;
				matbool[0][0] = true;
				return true;
			}
		}
		
		if((matrizBool(true, false, false, false, true, true, false, false, false))){
			if((btMat[0][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[1][2].getIcon().equals(iUsuario))) {
				btMat[2][1].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[1]++;
				matbool[2][1] = true;
				return true;
			}
		}
		
		if((matrizBool(false, false, false, false, true, true, true, false, false))){
			if((btMat[1][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][0].getIcon().equals(iUsuario))) {
				btMat[2][2].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[2]++;
				diagPrincC++;
				matbool[2][2] = true;
				return true;
			}
		}
		
		if((matrizBool(false, false, true, true, true, false, false, false, false))){
			if((btMat[0][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[1][0].getIcon().equals(iUsuario))) {
				btMat[0][0].setIcon(iComputador);
				vetlinC[0]++;
				vetcolC[0]++;
				diagPrincC++;
				matbool[0][0] = true;
				return true;
			}
		}
		
		if((matrizBool(false, false, false, true, true, false, false, false, true))){
			if((btMat[1][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][2].getIcon().equals(iUsuario))) {
				btMat[2][0].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[0]++;
				diagSecC++;
				matbool[2][0] = true;
				return true;
			}
		}
		
		if((matrizBool(false, false, false, false, true, false, false, false, true))){
			if((btMat[2][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador))) {
				btMat[0][1].setIcon(iComputador);
				vetlinC[0]++;
				vetcolC[1]++;
				matbool[0][1] = true;
				return true;
			}
		}
		
		if((matrizBool(true, false, false, false, true, false, false, false, false))){
			if((btMat[0][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador))) {
				btMat[2][1].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[1]++;
				matbool[2][1] = true;
				return true;
			}
		}
		
		if((matrizBool(false, false, true, false, true, false, true, false, false))){
			if((btMat[0][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iUsuario)) && (btMat[2][0].getIcon().equals(iComputador))) {
				btMat[2][2].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[2]++;
				diagPrincC++;
				matbool[2][2] = true;
				return true;
			}
		}
		
		if((matrizBool(true, true, true, false, true, false, false, true, true))){
			if((btMat[0][0].getIcon().equals(iUsuario)) && (btMat[0][1].getIcon().equals(iUsuario)) && (btMat[0][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][1].getIcon().equals(iUsuario)) && (btMat[2][2].getIcon().equals(iComputador))) {
				btMat[1][2].setIcon(iComputador);
				vetlinC[1]++;
				vetcolC[2]++;
				matbool[1][2] = true;
				return true;
			}
		}
		
		if((matrizBool(true, false, false, false, true, false, false, true, true))){
			if((btMat[0][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][1].getIcon().equals(iUsuario)) && (btMat[2][2].getIcon().equals(iComputador))) {
				btMat[1][2].setIcon(iComputador);
				vetlinC[1]++;
				vetcolC[2]++;
				matbool[1][2] = true;
				return true;
			}
		}
		
		if((matrizBool(true, false, false, false, true, true, false, false, true))){
			if((btMat[0][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[1][2].getIcon().equals(iUsuario)) && (btMat[2][2].getIcon().equals(iComputador))) {
				btMat[2][1].setIcon(iComputador);
				vetlinC[2]++;
				vetcolC[1]++;
				matbool[2][1] = true;
				return true;
			}
		}
		
		if((matrizBool(true, false, false, true, true, false, false, false, true))){
			if((btMat[0][0].getIcon().equals(iComputador)) && (btMat[1][0].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][2].getIcon().equals(iUsuario))) {
				btMat[0][1].setIcon(iComputador);
				vetlinC[0]++;
				vetcolC[1]++;
				matbool[0][1] = true;
				return true;
			}
		}
		
		if((matrizBool(true, true, false, false, true, false, false, false, true))){
			if((btMat[0][0].getIcon().equals(iComputador)) && (btMat[0][1].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][2].getIcon().equals(iUsuario))) {
				btMat[1][0].setIcon(iComputador);
				vetlinC[1]++;
				vetcolC[0]++;
				matbool[1][0] = true;
				return true;
			}
		}
		if((matrizBool(true, true, true, false, true, false, false, true, false))){
			if((btMat[0][0].getIcon().equals(iUsuario)) && (btMat[0][1].getIcon().equals(iComputador)) && (btMat[0][2].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador))&& (btMat[2][1].getIcon().equals(iUsuario))) {
				btMat[1][0].setIcon(iComputador);
				vetlinC[1]++;
				vetcolC[0]++;
				matbool[1][0] = true;
				return true;
			}
		}
		
		if((matrizBool(false, true, false, false, true, false, true, true, true))){
			if((btMat[0][1].getIcon().equals(iUsuario)) && (btMat[1][1].getIcon().equals(iComputador)) && (btMat[2][0].getIcon().equals(iUsuario)) && (btMat[2][1].getIcon().equals(iComputador))&& (btMat[2][2].getIcon().equals(iUsuario))) {
				btMat[0][2].setIcon(iComputador);
				vetlinC[0]++;
				vetcolC[0]++;
				matbool[0][2] = true;
				return true;
			}
		}
		
		
		return false;
	}
	
	public void computador(){
		int cont = 0;	
	
		for(int i=0;i<3;i++) 
			for(int j = 0; j < 3; j++) {
				if(matbool[i][j] == true)
					cont++;
			}
		if(v == false) {
			if(nuncaPerder() == false)
				if(computadorAtaca() == false) {
					if(computadorDefende() == false) {
						if(cont == 7)
							bJogadaComputador();
						else if(cont == 8)
							bJogadaComputador();
					}
				}
			
			if(cont == 0)
				aJogadaComputador();	
			
			if(cont == 1) 
				aJogadaComputador();
		}

		if(vencedor()) 
			recomecar();
			
		if(cheia()) {
			JOptionPane.showMessageDialog(null, "---|Empate|--- \nFim de Jogo.");
			recomecar();
		}
		v = true;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(v == true){
			for ( int i=0;i<3;i++)
				for(int j=0;j<3;j++){
			         if (e.getSource() == btMat[i][j]){  
				         if(matbool[i][j] == false){
			        		 btMat[i][j].setIcon(iUsuario);
			        		 vetlinU[i] ++;
			        		 vetcolU[j] ++;
			        		 if(i == j)
			        			 diagPrincU ++;
			        		 if((i + j) == 2)
			        			 diagSecU ++;
			        		 matbool[i][j] = true;
			        		 v = false;
			        		 if(vencedor())
			        			 recomecar();
			        		 
			        		 else 
			        			 computador();
			        		 
			        		 if(cheia()) {
			        			 JOptionPane.showMessageDialog(null, "---|Empate|--- \nFim de Jogo.");
			        			 recomecar();
			        		 }
						}
			        }
			   }
		}
	}
	
	public static void main(String[] args){
		JogoDaVelha j = new JogoDaVelha();
		int resposta;
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(450,350);
        j.setLocation(400,100);
        j.setVisible(true);
        j.setSize(500, 500);
        
        resposta = JOptionPane.showConfirmDialog(null, "Deseja começar?", null, JOptionPane.ERROR_MESSAGE);
        if (resposta == JOptionPane.NO_OPTION) {
        	j.v = false;
        	j.computador();
        }
        else j.v = true;
	}
}
	
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.swing.JOptionPane;
        
//package Projeto1;

public class Vetor{
    List <Integer> vetor;
    boolean ordenado;
    int ponteiro;
   
    public Vetor(){
        vetor = new ArrayList<Integer>();
        ordenado = false;
        ponteiro = -1;
    }
    public void geracao(){
        Random rd = new Random();
        int i,n;
        for(i=0;i<100;i++){
            n = rd.nextInt(999);
            vetor.add(n);
        }
        ponteiro = -1;
        ordenado = false;
    }
    public String toString(){
        String saida = " ";
        int i;
        for(i=0;i<50;i++)
            saida+= String.format("\n v[%d]=%d  v[%d]=%d",i,vetor.get(i),(i+50),vetor.get(i+50));
        return saida;
    }
    public int buscaExaustiva(int num){//vetor desordenado
        ponteiro = -1;
        int i=0;
        while((i<vetor.size())&&(num!=vetor.get(i)))
                i++;
        if((i<vetor.size())&&(num == vetor.get(i)))
                ponteiro = i;
        return ponteiro;
    }
    
    public int buscaBinaria(int num){
        int inicio = 0, fim = 100, meio;
        meio = (inicio + fim)/2;
        while((inicio < fim)&&(num!=vetor.get(meio))){
            if(num < vetor.get(meio))
                fim = meio;
            else inicio = meio+1;
            
            meio = (inicio + fim)/2;
        }
        
        if(vetor.get(meio)==num)
            return meio;
        else return -1;
    }
    
    public void ordena(){
        Collections.sort(vetor);
        ordenado = true;
    }
    
    public static void main(String[] args){
         Vetor v = new Vetor();
         char opte = '0';
         while(opte!='5'){
             String opcao = JOptionPane.showInputDialog(null, "\n |--------------------| Classe Vetor |--------------------|"+ "\n 1 - Gerar um vetor de 100 elementos"+ "\n 2 - Exibir o vetor"+ "\n 3 - Fazer a busca de um determinado numero"+ "\n 4 - Ordenar o vetor"+ "\n 5 - Sair");
             opte = opcao.charAt(0);
             switch(opte){
                 case '1': v.geracao();
                            break;
                            
                 case '2': String saida = v.toString();
                           JOptionPane.showMessageDialog(null,saida);
                           break;
                           
                 case '3': int num, posicao;
                           String texto = JOptionPane.showInputDialog(null, "Entre com o numero a ser procurado");
                           num = Integer.parseInt(texto);
                           if(v.ordenado)
                              posicao = v.buscaBinaria(num);
                           else 
                        	   posicao = v.buscaExaustiva(num);
                           if(posicao == -1)
                               JOptionPane.showMessageDialog(null, "Não encontrou");
                           
                           else
                        	   JOptionPane.showMessageDialog(null,String.format("Encontrou na posicao %d", posicao));
                           break;
                           
                 case '4': v.ordena();
                 		   JOptionPane.showMessageDialog(null,"Vetor Ordenado com sucesso");
                           break;
                            
             }
         }
    }
}

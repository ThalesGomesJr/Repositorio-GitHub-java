package herança.project1;

//Classe pessoa comum
public class Pessoa {
    private String nome;
    private int dia,mes;
 
    //contrutor   
    public Pessoa(){
        this.nome="";
        this.dia=1;
        this.mes=1;
        
    }
    //Construtor
    public Pessoa(String n, int d,int m){
        this.nome = n;
        this.dia=d;
        this.mes=m;
        
    }
    public void setNome(String n){
        this.nome = n;
    }
    public String getNome(){
        return this.nome;
    }
    public void setDia(int d){
        this.dia = d;
    }
    public int getDia(){
        return this.dia;
    }
    public void setMes(int m){
        this.mes = m;
    }
    public int getMes(){
        return this.mes;
    }
    
    //Exibe as pessoas
    public String toString(){
        String saida;
        saida=String.format("Nome: %s Data Nasc.: %d-%d",nome,dia,mes);
        return saida;
    }
    //Encontra o signo da pessoa
    public String signo(){
        String s=" ";
        switch(mes){
            case 1: 
                if(dia<=21)
                    s="Capricórnio";
                else 
                    s="Aquário";
                break;
            case 2:
                if(dia<=21)
                    s="Aquário";
                else 
                    s="Peixes";
                break;
            case 3:
                if(dia<=21)
                    s="Peixes";
                else 
                    s="Áries";
                break;
            case 4: 
                if(dia<=21)
                    s="Áries";
                else 
                    s="Touro";
                break;
            case 5: 
                if(dia<=21)
                    s="Touro";
                else 
                    s="Gêmeos";
                break;
            case 6:
                if(dia<=21)
                    s="Gêmeos";
                else 
                    s="Câncer";
                break;
            case 7:
                if(dia<=21)
                    s="Câncer";
                else 
                    s="Leão";
                break;
            case 8:
                if(dia<=21)
                    s="Leão";
                else 
                    s="Virgem";
                break;
            case 9:
                if(dia<=21)
                    s="Virgem";
                else 
                    s="Libra";
                break;
            case 10:
                if(dia<=21)
                    s="Libra";
                else 
                    s="Escorpião";
                break;
            case 11:
                if(dia<=21)
                    s="Escorpião";
                else 
                    s="Sagitário";
                break;
            case 12:
                if(dia<=21)
                    s="Sagitário";
                else 
                    s="Capricónio";
                break;            
       
        }
         return s;
    }
      
}

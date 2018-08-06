package herança.project1;

//Classe estudante (herança da Classe Pessoa)
public class Estudante extends Pessoa {
    private int matricula; 
    private float nota1,nota2;

    //construtor    
    public Estudante(){
        this.matricula=0;
        this.nota1=0;
        this.nota2=0;
    }
    //Construtor recebendo a herança da Classe Pessoa
    public Estudante(String n, int d, int m, int mat, float n1,float n2){
        super(n,d,m);
        this.matricula = mat;
        this.nota1=n1;
        this.nota2=n2;
    }
    public void setMatricula(int mat){
        this.matricula = mat;
    }
    public int getMatricula(){
        return this.matricula;
    }
    public void setNota1(float n1){
        this.nota1 = n1;
    }
    public float getNota1(){
        return this.nota1;
    }
    public void setNota2(float n2){
        this.nota2 = n2;
    }
    public float getNota2(){
        return this.nota2;
    }
    
    //Exibe os estudantes
    public String toString(){
        String saida=" "; 
        saida = super.toString()+String.format("\nMatrícula: %d Nota 1:%f Nota 2:%f", matricula,nota1,nota2);
        return saida;
    }
    //Calcula Media
    public float calculaMedia(){
        return ((nota1 + nota2)/2);
    }
}

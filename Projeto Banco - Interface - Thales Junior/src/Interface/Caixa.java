package Interface;

//Classe Caixa que Implementa a Classe Abstract Interface Autentica 
public class Caixa implements Autentica{
	protected String nome;
	protected float salario;
	protected String senha;
	
	//Construtor Classe
	public Caixa() {
		this.nome = "";
		this.salario=0;
		this.senha="";
	}
	
	//Construtor Classe
	public Caixa(String n, float s, String se ) {
		this.nome=n;
		this.salario=s;
		this.senha=se;
	}
	
	//Construtor atributo
	public void setNome(String n) {
		this.nome=n;
	}
	//Construtor atributo
	public String getNome() {
		return this.nome;
	}
	
	//Construtor atributo
	public void setSalario(float s) {
		this.salario=s;
	}
	//Construtor atributo
	public float getSalario() {
		return this.salario;
	}
	
	//Construtor atributo
	public void setSenha(String se) {
		this.senha=se;
	}
	//Construtor atributo
	public String getSenha() {
		return this.senha;
	}
	
	//Exibir
	public String toString() {
		String saida;
		saida = String.format("\nNome:%s \nSalario:%5.2f", getNome(),getSalario());
		return saida;
	}
	
	//Implementação do metodo autenticar da Classe Abstract Interface Autentica
	public boolean autenticar(String sen) {
		if(this.senha.equals(sen)) {
			return true;
		}
		else 
			return false;	
	}	
}

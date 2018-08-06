package Interface;

//Classe Caixa que Implementa a Classe Abstract Interface Autentica
public class Cliente implements Autentica{
	protected String nome;
	protected String cpf;
	protected String senha;
	
	//Construtor Classe	
	public Cliente() {
		this.nome="";
		this.cpf="";
		this.senha="";
	}
	
	//Construtor Classe
	public Cliente(String n, String c, String se) {
		this.nome=n;
		this.cpf=c;
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
	public void setCpf(String c) {
		this.cpf=c;
	}
	
	//Construtor atributo
	public String getCpf() {
		return this.cpf;
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
		saida = String.format("\nNome: %s \nCPF:%s", getNome(),getCpf());
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
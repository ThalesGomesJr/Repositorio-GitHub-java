
public abstract class Empregado {
	protected String nome;
	protected float salario;
	
	public Empregado() {
		this.nome = "";
		this.salario = 0;
	}
	
	public Empregado(String n) {
		this.nome = n;
		this.salario = 0;
	}
	
	public void setNome(String n) {
		this.nome = n;
	}

		public String getNome() {
			return this.nome;
		}
		
	public void setSalario(float s) {
		this.salario = s;
	}
		
		public float getSalario() {
			return this.salario;
		}
		
	public float vencto() {
		return salario;
	}
		
	public String toString() {
		String saida;
		saida = String.format("\nNome:%s ", getNome());
		return saida;
	}
}

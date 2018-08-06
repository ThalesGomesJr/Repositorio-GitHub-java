
public class Assalariado extends Empregado {
	private float salarioMensal;
	
	public Assalariado() {
		super();
		this.salarioMensal = 0;
	}
	
	public Assalariado(String n, float sm) {
		super(n);
		this.salarioMensal = sm;
	}
		
	public void setSalariomensal(float sm) {
		this.salarioMensal = sm;
	}
	
		public float getSalariomensal() {
			return this.salarioMensal;
		}
	
	public float vencto() {
		salario = this.salarioMensal;
		return salario;
	}
	public String toString() {
		String saida;
		saida = super.toString() + String.format("\nSalario Mensal: %.2f", getSalariomensal());
		return saida;
	}
}

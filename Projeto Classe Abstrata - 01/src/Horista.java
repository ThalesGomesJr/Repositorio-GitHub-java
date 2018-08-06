
public class Horista extends Empregado {
	private int hstrab;
	private float valorhora;
	
	public Horista() {
		super();
		this.hstrab = 0;
		this.valorhora = 0;
	}
	
	public Horista(String n, int ht, float vh) {
		super(n);
		this.hstrab = ht;
		this.valorhora = vh;
	}
	
	public float vencto() {
		salario = this.hstrab * this.valorhora;
		return salario;
	}
	
	public void setHstrab(int ht) {
		this.hstrab = ht;
	}
	
		public int getHstrab() {
			return this.hstrab;
		}
		
	public void setValorhora(float vh) {
		this.valorhora = vh;
	}
		
		public float getValorhora() {
			return this.valorhora;
		}
	
	public String toString() {
		String saida;
		saida = super.toString() + String.format("\nHoras trabalhadas: %d \nValor hora: %.2f",getHstrab(),getValorhora());
		return saida;
	}
}

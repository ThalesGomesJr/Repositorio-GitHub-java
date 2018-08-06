
public class Comissionado extends Empregado {
	private float brutVendas;
	private float taxa;
	
	public Comissionado() {
		super();
		this.brutVendas = 0;
		this.taxa = 0;
	}
	
	public Comissionado(String n, float bv, float t) {
		super(n);
		this.brutVendas = bv;
		this.taxa = t;
	}
		
	public void setBrutvendas(float bv) {
		this.brutVendas = bv;
	}
	
		public float getBrutvendas() {
			return this.brutVendas;
		}
		
	public void setTaxa(float t) {
		this.taxa = t;
	}
		
		public float getTaxa() {
			return this.taxa;
		}
	
	public float vencto() {
		float soma = this.brutVendas/100;
		salario = soma * taxa;
		return salario;
	}
	public String toString() {
		String saida;
		saida = super.toString() + String.format("\nVenda bruta:%.2f \nTaxa:%.0f",getBrutvendas(),getTaxa());
		return saida;
	}
}

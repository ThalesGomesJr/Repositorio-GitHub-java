

public abstract class Contribuinte {
	protected float rendaBrutaAnual;
	protected String nome;
	
	public Contribuinte(){
		rendaBrutaAnual=0;
		nome="";
	}
	
	public Contribuinte(float r, String n){
		rendaBrutaAnual=r;
		nome=n;
	}
	
	public abstract float arrecadaImposto();
	
	public void setRendaBrutaAnual(float r){
		this.rendaBrutaAnual=r;
	}
	
	public float getRendaBrutaAnual(){
		return this.rendaBrutaAnual;
	}
	
	public void setNome(String n){
		this.nome=n;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String toString(){
		String saida;
		saida=String.format("\n Nome:%s Renda Bruta:%5.2f",getNome(),getRendaBrutaAnual());
		return saida;
	}
	
}

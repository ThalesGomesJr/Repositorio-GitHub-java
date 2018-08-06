package Interface;

//Classe ContaEspecial que é herança da Classe ContaSimples
public class ContaEspecial extends ContaSimples {
	protected float limite;
	
	//Construtor da classe
	public ContaEspecial() {
		super();
		this.limite = 0;
	}
	
	//Construtor da classe
	public ContaEspecial(Cliente cl,String nC, float sal, float l) {
		super(cl,nC,sal);
		this.limite = l;
	}
	
	//Construtor do atributo
	public void setLimite(float l){
		this.limite = l;
	}
	
	//Construtor do atributo
	public float getLimite(){
        return this.limite;
	}
	
	//Metodo exibir
	public String toString(){
        String saida=" "; 
        saida = super.toString()+String.format("\nLimite R$:%5.2f",getLimite());
        return saida;
    }
	
	//Metodo saque 
	public boolean saque(float valor) {
		if((this.getLimite()+this.getSaldo())>=valor) {
			this.setSaldo(this.getSaldo()-valor);
			return true;
		}
		else 
			return false;
	}
}

package banco_Herança;

public class ContaEspecial extends ContaCorrente{
	private float limite;
	//Contrutor
	public ContaEspecial() {
		this.limite = 0;
		//super();
	}
	//Construtor
	public ContaEspecial(String n,float s,float l) {
		super(n,s);
		this.limite = l;
	}
	
	public void setLimite(float l){
		this.limite = l;
	}

	public float getLimite(){
        return this.limite;
	}
	//toString - exibe
	public String toString(){
        String saida=" "; 
        saida = super.toString()+String.format("Limite de Saldo R$:%5.2f",limite);
        return saida;
    }
	
	public boolean saque(float valor) {
		if((this.getLimite()+this.getSaldo())>=valor) {
			this.setSaldo(this.getSaldo()-valor);
			return true;
		}
		else {
			return false;
		}
			
	}
	
	
}

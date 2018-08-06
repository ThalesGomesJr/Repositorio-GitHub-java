package Interface;

//Classe ContaSimples super classe da ContaEspecial 
public class ContaSimples{
	protected String numConta;
	protected float saldo;
	protected Cliente cliente;
	
	//Construtor da classe
	public ContaSimples() {
		this.cliente = new Cliente();
		this.numConta = "";
		this.saldo = 0;
	}
	
	//Construtor da classe
	public ContaSimples(Cliente cl,String nC, float sal) {
		//A Classe Cliente é instanciada para criar uma conta
		this.cliente = cl;
		this.numConta = nC;
		this.saldo = sal;
	}
	
	//Contrutor do atributo 
	public void setCliente(Cliente cl){
		this.cliente = cl;
	}
	
	//Contrutor do atributo
	public Cliente getCliente(){
		return this.cliente;
	}
	
	//Contrutor do atributo
	public void setNumConta(String nC){
		this.numConta = nC;
	}
	
	//Contrutor do atributo
	public String getNumConta(){
		return this.numConta;
	}
    
	//Contrutor do atributo
	public void setSaldo(float sal){
        this.saldo = sal;
    }
	
	//Contrutor do atributo
	public float getSaldo(){
        return this.saldo;
    }
	
	//Metodo Exibir
	public String toString() {
		String saida;
		saida = String.format("\nNome: %s \nCPF:%s \nNumero da Conta:%s \nSaldo R$:%5.2f",cliente.getNome(),cliente.getCpf(), getNumConta(),getSaldo());
		return saida;
	}
	
	//Metodo deposito
	public void deposito(float valor) {
		this.setSaldo(this.getSaldo()+valor);
	 }
		 
	//Metodo saque 
	 public boolean saque(float valor) {
		 if(this.getSaldo()>=valor) {
			this.setSaldo(this.getSaldo()-valor);
			return true;
		}
		else 
			return false;			
		    }
	}

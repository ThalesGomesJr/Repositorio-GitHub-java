package banco_Herança;



public class ContaCorrente {
		private String numConta;
		private float saldo;
		ContaCorrente c;
		//Construtor
		public ContaCorrente(){
			this.numConta = "";
			this.saldo = 0;
			
		}
		
		//Construtor
		public ContaCorrente(String n,float s){
	        this.numConta = n;
	        this.saldo=s;
	    }
		 
		public void setNumConta(String n){
			this.numConta = n;
		}
		
		public String getNumConta(){
			return this.numConta;
		}
	    
		public void setSaldo(float s){
	        this.saldo = s;
	    }
		
		public float getSaldo(){
	        return this.saldo;
	    }
		
	    //toString - exibe
	    public String toString(){
	        String saida;
	        saida=String.format("Numero da conta: %s | Saldo R$:%5.2f",numConta,saldo);
	        return saida;
	    }
	    
	    //metodo de deposito
	    public void deposito(float valor) {
			this.setSaldo(this.getSaldo()+valor);
	    }
	    
	    //metodo de saque 
	    public boolean saque(float valor) {
	    	if(this.getSaldo()>=valor) {
				this.setSaldo(this.getSaldo()-valor);
				return true;
			}
			else 
				return false;
			
	    }
	}

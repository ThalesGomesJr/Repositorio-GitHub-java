
public class PessoaFisica extends Contribuinte {
	protected int numDepend;
	protected String Cpf;
	protected float gastoSaude;
	protected float gastoEduca;
	protected float totalImp;
	
	public PessoaFisica(){
		super();
		numDepend=0;
		Cpf="";
		gastoSaude=0;
		gastoEduca=0;
		totalImp=0; 
	}
	
	public PessoaFisica(float r, String n,int numD, String c, float gS, float gE){
		super(r,n);
		numDepend=numD;
		Cpf=c;
		gastoSaude=gS;
		gastoEduca=gE;
		//totalImp=tI;
	}
	
	public void setNumDepend(int numD){
		this.numDepend=numD;
	}
	
	public int getNumDepend(){
		return this.numDepend;
	}
	
	public void setCpf(String c){
		this.Cpf=c;
	}
	
	public String getCpf(){
		return this.Cpf;
	}
	
	public void setGastoSaude(float gS){
		this.gastoSaude=gS;
	}
	
	public float getGastoSaude(){
		return this.gastoSaude;
	}
	
	public void setGastoEduca(float gE){
		this.gastoEduca=gE;
	}
	
	public float getGastoEduca(){
		return this.gastoEduca;
	}

	public void setTotalImp(float tI) {
		this.totalImp=tI;
	}
	
	public float getTotalImp() {
		return this.totalImp;
	}
	
	public float arrecadaImposto() {
		float imposto = 0;
		float desconto=0;
		float total = 0;
		total = (this.getRendaBrutaAnual()/100)*27;
		if(getNumDepend()>0) {
			desconto+= getNumDepend()*3000;
			if(getGastoSaude()>0)
				desconto+=getGastoSaude();
			if(getGastoEduca()>0)
				desconto+=getGastoEduca();
			imposto = total - desconto;
			setTotalImp(imposto);
			return imposto;
		}
		else {
			if(this.getGastoSaude()>0)
				desconto+=this.getGastoSaude();
			if(this.getGastoEduca()>0)
				desconto+=this.getGastoEduca();
			imposto = total - desconto;
			setTotalImp(imposto);
			return imposto;	
		}
		
	}
	
	public String toString() {
		String saida;
		saida = super.toString() + String.format("\n Total de imposto pago:%5.2f",getTotalImp());
		return saida;
	}
}


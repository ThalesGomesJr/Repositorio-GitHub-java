
public class Juridica extends Contribuinte {
	protected String Cnpj;
	protected float gastoEmpregado;
	protected float gastoEquipamento;
	protected float totalImp;
	
	public Juridica(){
		super();
		Cnpj="";
		gastoEmpregado=0;
		gastoEquipamento=0;
		//totalImp=0; 
	}
	
	public Juridica(float r, String n,String c, float gEm, float gEq){
		super(r,n);
		Cnpj=c;
		gastoEmpregado=gEm;
		gastoEquipamento=gEq;
		//totalImp=tI;
	}
	
	public void setCnpj(String c){
		this.Cnpj=c;
	}
	
	public String getCnpj(){
		return this.Cnpj;
	}
	
	public void setGastoEmpregado(float gEm){
		this.gastoEmpregado=gEm;
	}
	
	public float getGastoEmpregado(){
		return this.gastoEmpregado;
	}
	
	public void setGastoEquipamento(float gEq){
		this.gastoEquipamento=gEq;
	}
	
	public float getGastoEquipamento(){
		return this.gastoEquipamento;
	}
	
	public void setTotalImp(float tI) {
		this.totalImp=tI;
	}
	
	public float getTotalImp() {
		return this.totalImp;
	}
	
	public float arrecadaImposto() {
		float imposto = 0;
		float total = 0;
		float desconto = 0;
		total = (this.getRendaBrutaAnual()/100)*20;
		if(getGastoEmpregado()>=0)
			desconto=getGastoEmpregado();
		if(getGastoEquipamento()>=0)
			desconto+=getGastoEquipamento();
		
		imposto = total - desconto;		
		return imposto;
	}
	
	public String toString() {
		String saida;
		saida = super.toString() + String.format("\n Total de imposto pago:%.2f",getTotalImp());
		return saida;
	}
}


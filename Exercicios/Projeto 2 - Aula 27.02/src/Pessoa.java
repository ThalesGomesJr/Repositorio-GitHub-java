
public class Pessoa {
	private String nome;
	private String rg;
	private int mes,ano;
	
	public Pessoa() {
		this.nome="";
		this.rg="";
		this.mes=0;
		this.ano=0;
	}
	
	public Pessoa(String n,String numrg,int m,int a) {
		this.nome=n;
		this.rg=numrg;
		this.mes=m;
		this.ano=a;
	}
	public void setNome(String n) {
		this.nome = n;
	}
	public String getNome() {
		return this.nome;
	}
	public void setRg(String numrg) {
		this.rg = numrg;
	}
	public String getRg() {
		return this.rg;
	}
	public void setMes(int m) {
		this.mes = m;
	}
	public int getMes() {
		return this.mes;
	}
	public void setAno(int a) {
		this.ano = a;
	}
	public int getAno() {
		return this.ano;
	}
	public String ToString() {
		String saida="";
		saida=String.format("\n Nome:%s \n RG:%s \n Mês =%d, Ano=%d",this.nome,this.rg,this.mes,this.ano);
		
		return saida;
	}
}


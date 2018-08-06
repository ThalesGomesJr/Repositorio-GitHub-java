
public class Equacao {

	private double a, b, c;
	private double delta;
	private double x1, x2;
	
//Construtor
	public Equacao() {
		this.a = 0;
		this.b = 0;
		this.c = 0;
		this.delta = 0;
		this.x1 = 0;
		this.x2 = 0;
	}
	
	public Equacao (double a1, double a2, double a3, double del , double first, double second){
		this.a = a1;
		this.b = a2;
		this.c = a3;
		this.delta = del;
		this.x1 = first;
		this.x2 = second;
	}

	public double getA() {
		return this.a;
	}

	public void setA(double a1) {
		this.a = a1;
	}

	public double getB() {
		return this.b;
	}

	public void setB(double a2) {
		this.b = a2;
	}

	public double getC() {
		return this.c;
	}

	public void setC(double a3) {
		this.c = a3;
	}

	public double getDelta() {
		return this.delta;
	}

	public void setDelta(double del) {
		this.delta = del;
	}
	
	public double getX1() {
		return this.x1;
	}

	public void setX1(double first) {
		this.x1 = first;
	}
	
	public double getX2() {
		return this.x2;
	}

	public void setX2(double second) {
		this.x2 = second;
	}

	public String toStringDelta() {
		String saida = "";
		saida = String.format("\nDelta = %f", this.delta);
	
		return saida;
	}
	
	public String toStringRaizes() {
		String saida = "";
		saida = String.format("\nRaizes: \n\nX1 = %f \nX2 = %f", this.x1, this.x2);
	
		return saida;
	}
	
	public String toStringEquacao() {
		String saida = "*****Formula de Bhaskara*****\n ";
		saida = String.format("\n x = (-b + (Math.sqrt(delta)))/(2 * a) \n");
	
		return saida;
	}
	
}


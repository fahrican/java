
public class Vektor {
	
	private int x;
	private int y;
	private int z;
	
	public Vektor(){
		this(0, 0, 0);
	}
	
	public Vektor(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vektor(Vektor testObj) {
		x = testObj.x;
		y = testObj.y;
		z = testObj.z;
	}
	
	public void bildschirmAnzeige() {
		System.out.println("(" + this.x + ", " + this.y + ", " + this.z + ")");
	}
	
	public Vektor erzeugenVektorObj(int a, int b, int c) {
		
		this.x = this.x + a;
		this.y = this.y + b;
		this.z = this.z + c;
		return this;
	}
	
	public Vektor erzeugenVektorObj(Vektor testVektor) {
		

		x = x + testVektor.x;
		y = y + testVektor.y;
		z = z + testVektor.z;
		return this;
	}
	
	public Vektor neu1(int a, int b, int c) {
		Vektor vektor = new Vektor(this);
		vektor.x = x+a;
		vektor.y = y+b;
		vektor.z = z+c;
		return vektor;
		}
	
}//end of class

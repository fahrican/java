
public class VektorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Erzeugen von Vektor-Objekten mit den unterschiedlichen
		// Konstruktoren
		Vektor v1 = new Vektor();
		v1.bildschirmAnzeige();
		Vektor v2 = new Vektor(1,1,1);
		v2.bildschirmAnzeige();
		Vektor v3 = new Vektor(v2);
		v3.bildschirmAnzeige();
		// Erzeugen eines neuen Vektor-Objektes durch Veränderung des
		// aufrufenden Objektes
		Vektor vneu = v1.erzeugenVektorObj(3,3,3);
		v1.bildschirmAnzeige();
		vneu.bildschirmAnzeige();
		// oder
		v1 = new Vektor();
		Vektor vcopy = v1.erzeugenVektorObj(new Vektor(3,3,3));
		v1.bildschirmAnzeige();
		vcopy.bildschirmAnzeige();
		// Erzeugen eines neuen Vektor-Objektes durch Beibehalten des
		// aufrufenden Objektes
		v1 = new Vektor();
		Vektor vneu1 = v1.neu1(3,3,3);
		v1.bildschirmAnzeige();
		vneu1.bildschirmAnzeige();

	}

}

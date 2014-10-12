package reusing;

class Insect {
	private int i = 9;
	protected int j;
	Insect() {
		System.out.println("i = " + i + ", j = " + j);
		j = 39;
	}
	private static int x1 = 
			printInit("static Insect.x1 zainicjanowana");
	static int printInit(String s) {
		System.out.println(s);
		return 47;
	}
}

public class Beetle extends Insect {
	private int k = printInit("Beetle.k zainicjowana");
	public Beetle() {
		System.out.println("k = " + k);
		System.out.println("j = " + j);
	}
	private static int x2 = 
			printInit("static Beetle.x zainicjalizowana");
	public static void main(String[] args) {
		System.out.println("Konstruktor klasy Beetle");
		//Beetle b = new Beetle();
	}
}

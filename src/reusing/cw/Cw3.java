package reusing.cw;

class Z {
	Z() {
		System.out.println("Z");
	}
}

public class Cw3 extends Z {
	public static void main(String[] args) {
		Cw3 cw3 = new Cw3();
	}
}

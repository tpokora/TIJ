package test;

class Pr {
	protected String msg = "Siemanko";
	
	protected void wypisz() {
		System.out.println(msg);
	}
}

class Pro extends Pr {
	
}

public class Prot {
	public static void main(String[] args) {
		Pro p = new Pro();
		p.wypisz();
	}
}

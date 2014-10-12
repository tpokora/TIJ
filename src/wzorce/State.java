package wzorce;

public class State {
	public static void main(String[] args) {
		Kontekst kont1 = new Kontekst(1, "kontekst1", 10);
		Kontekst kont2 = new Kontekst(2, "kontekst2", 21);
		
		System.out.println(kont1);
		System.out.println(kont2);
	}
}

class Kontekst {
	int numer;
	int wiek;
	String nazwa;
	double oplataRoczna;
	TypKarty typKarty;
	
	Kontekst(int numer, String nazwa, int wiek) {
		this.numer = numer; 
		this.nazwa = nazwa;
		this.wiek = wiek;
		if(wiek < 18)
			this.typKarty = new StanJunior();
		else
			this.typKarty = new StanSenior();
		this.oplataRoczna = typKarty.oplataRoczna();
	}
	
	public String toString() {
		return "Kontekst: #" + numer + " | " + nazwa + " " + wiek + " lat " + 
				typKarty + ", oplata roczna: " + oplataRoczna;
	}
}

abstract class TypKarty implements Oplaty {
	
}

interface Oplaty {
	double oplataRoczna();
	double oplataKarna();
}

class StanJunior extends TypKarty {
	@Override
	public double oplataRoczna() {
		return 12 * 8;
	}

	@Override
	public double oplataKarna() {
		return 0;
	}
	
	public String toString() {
		return "Karta typu Junior";
	}
}

class StanSenior extends TypKarty {
	@Override
	public double oplataRoczna() {
		return 12 * 12;
	}

	@Override
	public double oplataKarna() {
		return 0;
	}
	
	public String toString() {
		return "Karta typu Senior";
	}
}

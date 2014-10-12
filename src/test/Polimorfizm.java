package test;

interface X {
	int x = 3;
	void wypisz();	// w interfejsie metody sa tylko publiczne
}

abstract class AX implements X {
	
}

class AXK extends AX {
	@Override
	public void wypisz() {
		System.out.println("yooo");
	}
	
}

class A1 {
	void a() {};
}

class B1 extends A1 {
	void a() {
		System.out.println("Metoda a() wydziecziona z klasy A1: " +
				getClass().getName());
	}
}

class B2 extends A1 implements X {
	void a() {
		System.out.println("Metoda a() wydziecziona z klasy A1: " +
				getClass().getName());
	}
	public void wypisz() {
		System.out.println("Metoda wypisz z interfejsu X: " + 
				getClass().getName());
	}
}

class C1 extends B2 {
	
}

public class Polimorfizm {
	public static void main(String[] args) {
		B1 b1 = new B1();
		b1.a();
		
		B2 b2 = new B2();
		b2.a();
		b2.wypisz();
		
		C1 c1 = new C1();
		c1.wypisz();
		
		new AXK().wypisz();
		
	}
}

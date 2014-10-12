package reusing;

class A {
	A() {
		System.out.println("Konstruktor A"); // 1 - wywolanie przez konstruktor klasy C
	}
	
	public void f() {
		System.out.println("Funkcja A wywolana przez " + this);
	}
}

class B extends A {
	B() {
		System.out.println("Konstruktor B"); // 4, 11
		super.f();							// 5. wywolana wewnatrz klasy C
	}										// stad wynik Funkcja A wywolana przez Klasa C
											// 12. wywolane przy tworzeniu klasy B
											// stad wynik Funkcja A wywolana przez Klasa B

	{ System.out.println("Siema"); } // 2, 9. blok statyczny wywolywany zawsze przed konstruktorem
	public String toString() {
		return "Klasa B";
	}
	{ System.out.println("Siema2"); } // 3, 10.  blok statyczny wywolywany zawsze przed konstruktorem
}

class C extends B {
	//private D d = new D(1);			// 6
	C() {
		System.out.println("Konstruktor C");  // 7
		//D d1 = new D(2);					// 8
	}
	
	public String toString() {
		return "Klasa C";
	}
}

class D {
	D(int i) {
		System.out.println("Konstruktor D" + i);
	}
}

public class Konstruktory {
	public static void main(String[] args) {
		C c = new C();
		B b = new B();
		System.out.println("Wywolanie f() z klasy C:"); // 13
		((A)c).f();										// 14
		System.out.println("Wywolanie f() z klasy B:"); // 15
		((A)b).f();										// 16
	}
}

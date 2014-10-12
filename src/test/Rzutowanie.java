package test;

class A {
	protected String str = "siemanko";
}

class B extends A {
	public void xx() {
		System.out.println("metoda xx z klasy B: " + getClass().getName());
	}
}

public class Rzutowanie {
	public static void main(String[] args) {
		B b = new B();
		A a = b;
		
		Object o = b;
		Object ao = new A();
		//a.xx(); 
		((B)a).xx(); // rzutowanie z typu ogolnego na bardziej szczegolowy
		((B)o).xx();
		System.out.println(a.str);
		System.out.println(((A)ao).str);
	}
}

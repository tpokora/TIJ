package reusing.cw;

class A {
	A() {
		System.out.println("A");
	}
}

class B {
	B() {
		System.out.println("B");
	}
}

class C extends A {
	B b = new B();
	C() {
		System.out.println("C");
	}
	
	void f() {
		System.out.println("funkcja f()");
	}
	
	void dispose() {
		System.out.println("Usuwanie C");
	}
}

public class Cw5 {
	public static void main(String[] args) {
		C c = new C();
		c.dispose();
		c.f();
	}
}

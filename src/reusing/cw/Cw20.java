package reusing.cw;

class WithFinals {
	private final void f() {
		System.out.println("WithFinals.f()");
	}
	
	private void g() {
		System.out.println("WithFinals.f()");
	}
}

class OverridingPrivate extends WithFinals {
	private final void f() {
		System.out.println("OverridingPrivate.f()");
	}
	
	private void g() {
		System.out.println("OverridingPrivate.f()");
	}
}

class OverridingPrivate2 extends OverridingPrivate {
	public final void f() { System.out.println("OverridingPrivate2.f()"); }
	public void g() {
		System.out.println("OverridingPrivate2.f()");
	}
}

public class Cw20 {
	public static void main(String[] args) {
		OverridingPrivate2 op2 = new OverridingPrivate2();
		op2.f();
		op2.g();
		OverridingPrivate op = op2;
		//op.f();
		//op.g();
	}
}

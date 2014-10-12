package reusing;

class Gizmo {
	private int i;
	
	Gizmo(int i) {
		this.i = i;
	}
	
	public void setI(int i) {
		this.i = i;
	}
	
	public int getI() {
		return i;
	}
	
	public void spin() {}
	
	public final void yo(String s) {
		System.out.println(this.getClass().getName() + 
				" - final yo(): " + s);
	}
}

class Gimbo extends Gizmo {
	Gimbo() {
		super(3);
	}
	
	/*
	 * nie mozna nadpisac metody finalnej
	 * 
	@Override
	public final void yo(String s) {
		
	}
	*/ 
}

public class FinalArguments {
	void with(final Gizmo g) {
		System.out.println("With");
		System.out.println(g.getI());
		g.setI(2);
		System.out.println(g.getI());
		g.yo("yo");
	}
	void without(Gizmo g) {
		System.out.println("Without");
		System.out.println(g.getI());
		g.yo("yo1");
	}
	
	void gimbo(Gimbo g) {
		System.out.println("Gimbo");
		g.yo("gimbo yo");
	}
	
	public static void main(String[] args) {
		FinalArguments fa = new FinalArguments();
		fa.with(new Gizmo(3));
		fa.without(new Gizmo(2));
	}
}

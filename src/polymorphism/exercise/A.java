package polymorphism.exercise;

public class A implements IA {
	public int a;
	
	public A() {}
	
	public A(int a) {
		this.a = a;
	}
	
	public String getA() {
		return "Metoda getA(), wywolana z klasy: " + this.getClass() 
				+ "\nWartosc a = " + a;
	}
	
	public void printMsg(String msg) {
		System.out.println("Metoda implementowana z interfejsu: " + IA.class);
		System.out.println("wywołana w klasie: " + this.getClass());
		System.out.println("podany argument: " + msg);
	}

	@Override
	public String msg(String msg) {
		return "Msg: " + msg;
	}
}

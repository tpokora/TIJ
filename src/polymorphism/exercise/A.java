package polymorphism.exercise;

public class A implements IA {
	protected int a;
	
	public A(int a) {
		this.a = a;
	}
	
	public String getA() {
		return "Metoda getA(), wywołana z klasy: " + this.getClass() 
				+ "\nWartość a = " + a;
	}
	
	public void printMsg(String msg) {
		System.out.println("Metoda implementowana z interfejsu: " + IA.class);
		System.out.println("wywołana w klasie: " + this.getClass());
		System.out.println("podany argument: " + msg);
	}
}

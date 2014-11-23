package polymorphism.exercise;

class Home {
	public String name;
	
	public Home() {
		name = "dom";
	}
}

class T {
	private int a;
	
	public T(int a) {
		this.a = a;
	}
	
	public int getA() {
		return a;
	}
	
	public void addToA(int x) {
		this.a += x;
	}
	
	public void changeT(T t) {
		T tx = new T(33);
		t = tx;
	}
	
	public T changeT2(T t) {
		T tx = new T(33);
		t = tx;
		return  t;
	}
	
	public void printInt(int x) {
		System.out.println(x);
		x += 5;
		System.out.println(x);
	}
}

public class Test {
	public static void main(String[] args) {
		A a = new A(3);
		B b = new B(2);
		AA aa = new AAI();
		
		a.printMsg("Klasa A");
		b.printMsg("Klasa B");
		
		System.out.println(a.getA());
		System.out.println(b.getA());
		
		aa.implementedMethod();
		aa.unimplementedMethod();
		//aa.aaiMethod(); nie znaleziona poniewaz rzutujemy w gore na typ AA podczas deklaracji
		((AAI)aa).aaiMethod(); // rzutowanie w dol do typu AAI
		AAI aai = new AAI(); 
		aai.aaiMethod(); // dziala, poniewaz bazowy typ jest taki sam jak koncowy
		aai.methodForAbstractClassToImplementIntoOtherClass();
		
		Home home = new Home();
		Object obj = home;
		System.out.println("\nReferencja do obiektu home zostala przypisana do obiektu Object,\n" 
				+ "dlatego potrzebne jest rzutowanie obiektu typu Object, na typ Home\n" 
				+ "((Home)obj).name, dopiero wtedy mamy dostep do zmiennej dostepnej w obiekcie typu Home: " 
				+ ((Home)obj).name);
		
		T t = new T(3);
		System.out.println("t.a() = " + t.getA());
		T t2 = new T(5);
		System.out.println("t2.a() = " + t2.getA());
		t2.changeT(t2);
		System.out.println("t2.a() po zmianie = " + t2.getA());
		t2 = t2.changeT2(t2);
		System.out.println("t2.a() po drugiej zmianie = " + t2.getA());
		int y = 4;
		t2.printInt(y);
		System.out.println(y);
		
	}
}

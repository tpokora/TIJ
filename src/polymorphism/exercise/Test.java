package polymorphism.exercise;

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
		
	}
}

package polymorphism.exercise;

public class AAI extends AA {

	@Override
	public void unimplementedMethod() {
		System.out.println("Metoda unimplementedMethod(), odziedziczona po abstrakcyjnej klasie AA"
				+ " wymagajaca implementacji wewnatrz klasy dziedziczacej");
	}
	
	public void aaiMethod() {
		System.out.println("Metoda aaiMethod(), z klasy AAI");
	}

	@Override
	public void methodForAbstractClassToImplementIntoOtherClass() {
		System.out.println("Metoda z interfejsu IIA, nie zaimplementowana w abstrakcyjnej klasie AA," + 
				" musi być zaimplementowana w klasie dziedziczącej po klasie abstrakcyjnej");
		
	}

}

package polymorphism.exercise;

abstract public class AA implements IIA {
	
	public AA() {}
	
	public void implementedMethod() {
		System.out.println("Metoda implementedMethod(), zaimplementowana w abstrakcyjnej klasie AA");
	}
	
	public abstract void unimplementedMethod(); // needs abstract type noted, without generates error
}

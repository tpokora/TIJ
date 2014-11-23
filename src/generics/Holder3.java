package generics;

import polymorphism.exercise.A;
import polymorphism.exercise.B;

public class Holder3<T> {
	private T a;
	public Holder3(T a) {
		this. a = a;
	}
	
	public void set(T a) {
		this.a = a;
	}
	
	public T get() {
		return a;
	}
	
	public static void main(String[] args) {
		Holder3<A> h3 = new Holder3<A>(new A(3));
		A a = h3.get();
		h3.set(new B(2));
		h3.set(a);
	}
}

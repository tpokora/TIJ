package generics;

import polymorphism.exercise.A;

public class Holder4<T> {
	private T[] table;
	
	@SuppressWarnings("unchecked")
	public Holder4() {
		table = (T[])new Object[3];
	}
	
	public void set(T a, int index) {
		table[index] = a;
	}
	
	public T get(int index) {
		return table[index];
	}
	
	public static void main(String[] args) {
		Holder4<A> holder = new Holder4<A>();
		holder.set(new A(1), 0);
		holder.set(new A(2), 1);
		holder.set(new A(3), 2);
		for(int i = 0; i < 3; i++) {
			System.out.println(holder.get(i).getA());
		}
	}
}

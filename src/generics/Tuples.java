package generics;

class Tuple<A, B> {
	public final A first;
	public final B second;
	
	public Tuple(A a, B b) {
		first = a;
		second = b;
	}
	
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}

class SixTuple<A, B, C, D, E, F> extends Tuple<A, B> {
	public final C third;
	public final D fourth;
	public final E fifth;
	public final F sixth;
	
	public SixTuple(A a, B b, C c, D d, E e, F f) {
		super(a, b);
		third = c;
		fourth = d;
		fifth = e;
		sixth = f;
	}
	
	public String toString() {
		return "(" + first + ", " + second + ", " + third + 
				", " + fourth + ", " + fifth + ", " + sixth + ")";
	}
}

public class Tuples {
	public static void main(String[] args) {
		Tuple<String, Integer> tuple = new Tuple<String, Integer>("Hello", 3);
		System.out.println(tuple);
		SixTuple<String, Integer, Double, Float, Boolean, String> sixtuple =
				new SixTuple<String, Integer, Double, Float, Boolean, String>
									("Hello", 3, 2.1, 3.0f, true, " world!");
		System.out.println(sixtuple);
	}
}

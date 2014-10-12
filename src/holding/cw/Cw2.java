package holding.cw;

import java.util.Set;
import java.util.HashSet;

class Apple {
	protected String name;
	Apple() {}
	Apple(String name) {
		this.name = name;
	}
	private static int counter;
	private final long id = counter++;
	public long id() { return id; }
	public String name() { return name; }
}

class Orange {}

class Kiwi extends Apple {
	Kiwi(String name) {
		super(name);
	}
}

class Yo extends Apple {
	Yo(String name) {
		super(name);
	}
}

public class Cw2 {
	public static void main(String[] args) {
		Set<Apple> set = new HashSet<Apple>();
		
		set.add(new Apple("jablko1"));
		set.add(new Apple("jablko2"));
		set.add(new Kiwi("kiwi"));
		set.add(new Yo("yo"));
		
		for(Apple ap : set)
			System.out.println(ap.name() +
					", id: " + ap.id());
		
		Set<Integer> set2 = new HashSet<Integer>();
		
		set2.add(1);
		set2.add(1);
		set2.add(1);
		set2.add(2);
		set2.add(3);
		
		for(Integer integer : set2)
			System.out.println(integer);
	}
}

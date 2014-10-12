package test;

import java.util.ArrayList;
import java.util.List;

class Apple {
	private static int counter;
	private final long id = counter++;
	public long id() { return id; }
}

class Orange {}

class Kiwi extends Apple {}
class Yo extends Apple {}

public class Kontenery {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		
		Object o = new Object();
		Integer iint = new Integer(3);
		String s = new String("String");
		A a = new A();
		B b = new B();
		
		list.add(o);
		list.add(iint);
		list.add(s);
		list.add(a);
		list.add(b);
		
		// foreach
		for(Object le : list) 
			System.out.println("list: " + le.getClass().getName());
		
		//List apples = new ArrayList();
		List<Apple> apples = new ArrayList<Apple>();
		for(int i = 0; i < 3; i++)
			apples.add(new Apple());
		// blad kompilacji
		// apples.add(new Orange()); 
		//for(int i = 0; i < apples.size(); i++)
		//	System.out.println(((Apple)apples.get(i)).id());
		for(int i = 0; i < apples.size(); i++)
			System.out.println(apples.get(i).id());
		
		// lista z dziedziczonymi elementami
		List<Apple> elist = new ArrayList<Apple>();
		elist.add(new Apple());
		elist.add(new Kiwi());
		elist.add(new Yo());
		
		for(Apple ap : elist) 
			System.out.println(ap.getClass().getName() + 
					", id: " + ap.id());
	}
}

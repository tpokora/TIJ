package holding.cw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

class ActorGen {
	static Map<Integer, String> actors =
			new HashMap<Integer, String>();
	
	ActorGen() {
		actors.put(0, "Yo");
		actors.put(1, "Yo1");
		actors.put(2, "Yo2");
		actors.put(3, "Yo3");
	}
	
	public String next() {
		Random rand = new Random();
		int rint = rand.nextInt(4);
		String actor = actors.get(rint);
		// System.out.println("next(" + rint + "): " + actor);
		return actor;
	}
}

public class Cw4 {
	public static <T> void display(Iterator<T> it) {
		while(it.hasNext()) {
			T i = it.next();
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		List<String> actorsArray = new ArrayList<String>();
		List<String> actorsLinked = new LinkedList<String>();
		Set<String> actorsHashset = new HashSet<String>();
		Set<String> actorsLinkedHashset = new HashSet<String>();
		Set<String> actorsTreeset = new TreeSet<String>();
		
		ActorGen gen = new ActorGen();
		
		for(int i = 0; i < 4; i++) {
			actorsArray.add(gen.next());
			actorsLinked.add(gen.next());
			actorsHashset.add(gen.next());
			actorsLinkedHashset.add(gen.next());
			actorsTreeset.add(gen.next());
		}
		
		System.out.println("ArrayList:");
		display(actorsArray.iterator());
		System.out.println("LinkedList:");
		display(actorsLinked.iterator());
		System.out.println("HashSet:");
		display(actorsHashset.iterator());
		System.out.println("LinkedHashSet:");
		display(actorsLinkedHashset.iterator());
		System.out.println("TreeSet:");
		display(actorsTreeset.iterator());
	}
}

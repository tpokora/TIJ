package generics;

interface Selector<T> {
	boolean end();
	T current();
	void next();
}

class Sequence<T> {
	private T[] items;
	private int next = 0;
	@SuppressWarnings("unchecked")
	public Sequence(int size) {
		items = (T[])new Object[size];
	}
	public void add(T x) {
		if(next < items.length)
			items[next++] = x;
	}
	
	private class SequenceSelector implements Selector<T> {
		private int i = 0;
		public boolean end() {
			return i == items.length;
		}
		public T current() {
			return items[i];
		}
		public void next() {
			if(i < items.length)
				i++;
		}
	}
	
	public Selector<T> selector() {
		return new SequenceSelector();
	}
}

public class GenericSequence {
	public static void main(String[] args) {
		Sequence<Object> sequence = new Sequence<Object>(10);
		for(int i = 0; i < 10; i++) {
			sequence.add(Integer.toString(i));
		}
		Selector<Object> selector = sequence.selector();
		while(!selector.end()) {
			System.out.println(selector.current() + " ");
			selector.next();
		}
	}
}









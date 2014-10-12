package test;

public class Stos {
	private Object[] stos;
	
	public Stos() {}
	
	public void add(Object obj) {
		if(stos == null) {
			stos = new Object[1];
			stos[0] = obj;
		}
		else {
			Object[] temp = new Object[stos.length + 1];
			for(int i = 0; i < stos.length; i++)
				temp[i] = stos[i];
			temp[temp.length - 1] = obj;
			stos = temp;
		}
	}
	
	public Object showTop() {
		return stos.length > 0 ? stos[stos.length - 1] : new String("Stos jest pusty");
	}
	
	public Object getTop() {
		if(stos.length > 0) {
			Object top = stos[stos.length - 1];
			Object[] temp = new Object[stos.length - 1];
			for(int i = 0; i < temp.length; i++)
				temp[i] = stos[i];
			stos = temp;
			return top;
		} else
			return new String("Stos jest pusty");
	}
	
	public int getSize() {
		return stos.length;
	}
	
	public static void main(String[] args) {
		Stos stos = new Stos();
		stos.add(new String("Siema"));
		stos.add(new Integer(3));
		stos.add(new String("Siema1"));
		stos.add(new Integer(32));
		stos.add(new String("Siema3"));
		stos.add(new Integer(34));
		System.out.println("Stos size: " + stos.getSize());
		System.out.println("Stos getTop: " + stos.getTop());
		System.out.println("Stos showTop: " +stos.showTop());
		System.out.println("Stos size: " + stos.getSize());
		System.out.println("Stos getTop: " +stos.getTop());
		System.out.println("Stos showTop: " +stos.showTop());
		System.out.println("Stos size: " + stos.getSize());
		System.out.println("Stos getTop: " +stos.getTop());
		System.out.println("Stos size: " + stos.getSize());
	}
}

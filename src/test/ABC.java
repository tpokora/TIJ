package test;

class AB {
	private int a;
	private int b;
	
	AB() {}
	
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public int getB() {
		return b;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
	public void changeInAB(AB ab) {
		AB ab2 = new AB();
		ab2.setA(3);
		ab2.setB(9);
		
		ab = ab2;
	}
}

public class ABC {
	public static void changeInA(AB ab) {
		AB ab2 = new AB();
		ab2.setA(3);
		ab2.setB(9);
		
		ab = ab2;
	}
	
	public static String changeString(String str) {
		return "zmiana";
	}
	
	public static void main(String[] args) {
		AB ab = new AB();
		ab.setA(25);
		ab.setB(50);
		
		changeInA(ab);
		System.out.println(ab.getA() + ab.getB());
		
		String s = "Yoo";
		System.out.println(changeString(s));
		
		ab.changeInAB(ab);
		System.out.println(ab.getA() + ab.getB());
	}
}


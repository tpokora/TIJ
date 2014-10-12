package test;

public class Ex {
	public static void main(String[] args) {
		String x = null;
		String y = "siemanko";
		
		if(getString(y) != null) {
			System.out.println(y);
		} else {
			System.out.println("y = null");
		}
		
		y = x;
		
		if(getString(y) != null) {
			System.out.println(y);
		} else {
			System.out.println("y = null");
		}
		
		try {
			x = getString(null);
		} catch(NullPointerException npe) {
			System.out.println("npe");
		}
	}
	
	static String getString(String str) {
		return str;
	}
}

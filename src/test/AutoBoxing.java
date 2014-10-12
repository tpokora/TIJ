package test;

public class AutoBoxing {
	public static void main(String[] args) {
		int dwa = 2;
		Integer dwaI = new Integer(2);
		
		if(dwaI == dwa) {
			System.out.println("Integer(2) = dwa");
		}
	}
}

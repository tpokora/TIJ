package test;

interface IA {
	public void yo();
}

abstract class Aa {}

abstract class AIA implements IA {
	@Override 
	public void yo() {
		System.out.println(this.getClass().getName() + ": yo");
	}
} 

abstract class Ba extends Aa {}

class Yy extends AIA {
	
}

public class Abstrakcje {
	public static void main(String[] args) {
		AIA a = new Yy();
		a.yo();
	}
}

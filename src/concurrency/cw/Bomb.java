package concurrency.cw;

public class Bomb extends Thread {
	public static void main(String[] args) {
		Bomb b = new Bomb();
		b.start();
	}
	
	public void run() {
		System.out.println("Hello");
	}
}

package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Number {
	private int x;
	private Random rand = new Random();
	public Number() {}
	public int getX() {
		return x;
	}
	public synchronized void newNumber() {
		x = rand.nextInt(10);
	}
}

class EqualChecker implements Runnable {
	private Number a = new Number();
	private Number b = new Number();
	private int id = 0;
	private boolean canceled = false;
	public EqualChecker(int id) {
		this.id = id;
	}
	public synchronized void run() {
		try {
			while(!canceled) {
				a.newNumber();
				b.newNumber();
				System.out.println("#" + id + " Czy równe?...");
				TimeUnit.SECONDS.sleep(1);
				if(equalNumbers(a, b)) {
					System.out.println("#" + id + "(" + a.getX() + 
							", " + b.getX() + ")" + " Równe!");
					cancel();
				} else {
					System.out.println("#" + id + "(" + a.getX() + 
							", " + b.getX() + ")" + " nierówne!");
				}
				
			}
		} catch(InterruptedException e) {
			
		}
		
	}
	private void cancel() {
		canceled = true;
	}
	private boolean equalNumbers(Number a, Number b) {
		return a.getX() == b.getX() ? true : false;
	}
}

public class Equals {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			exec.execute(new EqualChecker(i));
		}
		exec.shutdown();
		System.out.println("KONIEC!");
	}
}

package concurrency.cw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class A {
	public void spanie() {
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch(InterruptedException e) {
			System.out.println("wybudzono A");
		}
	}
}

class Zadanie implements Runnable {
	public void run() {
		A a = new A();
		a.spanie();
	}
}

public class Cw18 {
	public static void main(String[] args) {
		Zadanie zadanie = new Zadanie();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(zadanie);
		for(int i = 0; i < 5; i++) {
			try{
				System.out.println(i);
				TimeUnit.SECONDS.sleep(1);
			} catch(InterruptedException e) {}
		}
		exec.shutdownNow();
	}
}

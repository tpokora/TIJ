package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class R implements Runnable {
	private static int count = 0;
	private final int id = ++count;
	private int counter = 0;
	@Override
	public void run() {
		while(counter < 10) {
			counter++;
			System.out.println("R" + id + " : counter : " + counter);
			
		}
		
	}
}

class T extends Thread {
	private static int count = 0;
	private final int id = ++count;
	private int counter = 0;
	@Override
	public void run() {
		while(counter < 10) {
			counter++;
			System.out.println("T" + id + " : counter : " + counter);
		}
	}
}

public class TvR {
	public static void main(String[] args) throws Exception {
		R r = new R();
		Thread t1 = new Thread(r);
		t1.start();
		Thread.sleep(1000);
		Thread t2 = new Thread(r);
		t2.start();
		Thread.sleep(1000);
		Thread t3 = new Thread(r);
		t3.start();
		
		System.out.println("===============");
		
		Thread tc1 = new T();
		tc1.start();
		Thread.sleep(1000);
		Thread tc2 = new T();
		tc2.start();
		Thread.sleep(1000);
		Thread tc3 = new T();
		tc3.start();
		
		System.out.println("===============");
		
		R r1 = new R();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(r1);
		exec.shutdown();
		
	}
}

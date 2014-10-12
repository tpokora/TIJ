package test;

import java.util.concurrent.TimeUnit;

class Tlo implements Runnable {
	private static int tloCount = 0;
	private final int tloId = ++tloCount; 
	private int counter = 0;
	private boolean canceled = false;
	
	public void run() {
		try {
			while(!canceled) {
				System.out.println("#" + tloId + "Tlo: " + counter++);
				TimeUnit.MILLISECONDS.sleep(200);
				if(counter == 100) cancel();
			}
		} catch(InterruptedException e) {
			
		}
	}
	
	private void cancel() {
		canceled = true;
	}
}

class TloT extends Thread {
	private static int tloCount = 0;
	private final int tloId = ++tloCount; 
	private int counter = 0;
	private int time = 0;
	
	public TloT(int time) {
		this.time = time;
	}
	
	public void run() {
		synchronized(this) {
			try {
				while(!isInterrupted()) {
					System.out.println("#" + tloId + "TloT: " + counter++);
					TimeUnit.MILLISECONDS.sleep(time);
					if(counter == 10) {
						System.out.println("#" + tloId + "TloT: czekam");
						wait(5000);
						counter += 10;
						System.out.println("#" + tloId + "TloT: wznawiam");
						notify();
					}
					if(counter == 30) interrupt();
				}
			} catch(InterruptedException e) {
				System.err.println("Przerwano!");
			}
		}
		
	}
}

public class WatekPlusPetla {
	public static void main(String[] args) {
		//ExecutorService exec = Executors.newCachedThreadPool();
		//exec.execute(new TloT(700));
		new TloT(700).start();
		//exec.shutdown();
		TloT t1 = new TloT(1000);
		t1.setDaemon(true);
		TloT t2 = new TloT(1500);
		
		for(int i = 0; i < 10; i++) {
			System.out.println("Petla: " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch(InterruptedException e) {}
		}
		
		t1.start();
		t2.start();
		
		System.out.println("KONIEC");
	}
}

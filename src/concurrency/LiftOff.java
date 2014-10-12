package concurrency;

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff() {}
	public LiftOff(int countDown) {
		this.countDown = countDown;
	}
	public String status() {
		return "#" + id + "(" +
				(countDown > 0 ? countDown : "Start!") + "), "; 
	}
	public void run() {
		try {
			while(countDown-- > 0) {
				System.out.println(status());
				TimeUnit.SECONDS.sleep(1);
				
			}
		} catch(InterruptedException e) {
			System.out.println("Przerwano LiftOff");
		}
		
	}

}
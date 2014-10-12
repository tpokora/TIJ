package test;

public class Runner {
	public static void main(String[] args) {
		MyRun[] notRunners = new MyRun[10];
		Thread[] threads = new Thread[10];
		
		for(int i = 0; i < 10; i++) {
			notRunners[i] = new MyRun(i);
		}
		
		for(int i = 0; i < 10; i++) {
			threads[i] = new Thread(notRunners[i]);
		}
		
		for(int i = 0; i < 10; i++) {
			threads[i].start();
		}
	}
}

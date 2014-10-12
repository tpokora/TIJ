package test;

public class MyRun implements Runnable {
	private int id;
	
	public MyRun(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("NieWatek " + id);
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

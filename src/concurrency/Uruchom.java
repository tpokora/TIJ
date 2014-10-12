package concurrency;

public class Uruchom {
	public static void main(String[] args) {
		Watek w = new Watek();
		
		(new Thread(w)).start();
	}
}

class Watek implements Runnable {

	@Override
	public void run() {
		System.out.println("yo");
	}
	
}

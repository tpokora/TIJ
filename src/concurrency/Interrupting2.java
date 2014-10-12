package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockedMutex {
	private Lock lock = new ReentrantLock(); // blokowanie zadan zablokowanych
	public BlockedMutex() {
		// natychmiastowe zalozenie blokady w celu zademonstrowania
		// przerywania zadania zawieszonego na blockadzie ReentrantLock
		lock.lock();
	}
	public void f() {
		try {
			// blokada niedostepna dla drugiego zadania
			lock.lockInterruptibly(); // wywolanie specjalne
		} catch(InterruptedException e) {
			System.out.println("Przerwanie zak³adania blokady w f()");
		}
	}
}

class Blocked2 implements Runnable {
	BlockedMutex blocked = new BlockedMutex();
	public void run() {
		System.out.println("Oczekiwanie na f() w BlockedMutex()");
		blocked.f();
		System.out.println("Wytr¹cony z zablokowanego wywo³ania");
	}
}

public class Interrupting2 {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Blocked2());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Wywo³anie t.interrupt()");
		t.interrupt();
	}
}

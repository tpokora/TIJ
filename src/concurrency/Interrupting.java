package concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepBlocked implements Runnable {
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch(InterruptedException e) {
			System.out.println("InterruptedException");
		}
		System.out.println("Opuszczanie metody SleepBlocked.run()");
	}
}

class IOBlocked implements Runnable {
	private InputStream in;
	public IOBlocked(InputStream is) {
		in = is;
	}
	public void run() {
		try{
			System.out.println("Oczekiwanie na read(): ");
			in.read();
		} catch(IOException e) {
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("Przerywany w zawieszeniu na operacje wejscia-wyjscia");
			} else {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Opuszczanie metody IOBlocked.run()");
	}
}

class SynchronizedBlocked implements Runnable {
	public synchronized void f() {
		while(true) // nigdy nie zwalnia blokady
			Thread.yield();
	}
	public SynchronizedBlocked() {
		new Thread() {
			public void run() {
				f(); // blokada pozyskana przez ten watek
			}
		}.start();
	}
	public void run() {
		System.out.println("Proba wywolania f()");
		f();
		System.out.println("Opuszczanie metody SynchronizedBlocked.run()");
	}
}

public class Interrupting {
	private static ExecutorService exec = Executors.newCachedThreadPool();
	static void test(Runnable r) throws InterruptedException {
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Przerwanie " + r.getClass().getName());
		f.cancel(true); // przerwanie jesli dziala
		System.out.println("Nakaz przerwania wys³any do " + r.getClass().getName());
	}
	public static void main(String[] args) throws Exception {
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Opuszczanie programu (System.exit(0)");
		System.exit(0); // dwa ostatnie przerwania zawiodly
	}
}

package concurrency.cw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import concurrency.LiftOff;

class Interupt {
	private static ExecutorService exec = Executors.newCachedThreadPool();
	public static void przeszkadzanie(Runnable r, int seconds) 
			throws InterruptedException {
		Future<?> f = exec.submit(r);
		//Thread t = new Thread(r);		// drugia mozliwosc uruchamiania watkow
		//t.start();
		System.out.println("Przerwanie " + r.getClass().getName() + 
				" z poziomu klasy Interupt nast¹pi za " + seconds + 
				" sekundy");
		TimeUnit.SECONDS.sleep(seconds);
		f.cancel(true);
		//t.interrupt();
		System.out.println("Przerwanie " + r.getClass().getName() + 
				" z poziomu klasy Interupt");
	}
}

public class Cw20 {
	public static void main(String[] args) throws Exception {
		Interupt.przeszkadzanie(new LiftOff(), 4);
		Interupt.przeszkadzanie(new LiftOff(), 4);
		Interupt.przeszkadzanie(new LiftOff(), 4);
	}
}

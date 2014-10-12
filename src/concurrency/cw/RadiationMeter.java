package concurrency.cw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Radiation {
	private double value = 0.0;
	private Random rand = new Random(47);
	private Random randRadiation = new Random();
	public synchronized double getMeasure() {
		double radiation = randRadiation.nextDouble();
		if(rand.nextBoolean())
			Thread.yield();
		return (value += radiation);
	}
	
	public synchronized double getValue() {
		return value;
	}
}

class RadiationMeasurment implements Runnable {
	private static Radiation radiation = new Radiation();
	private static List<RadiationMeasurment> radiations =
			new ArrayList<RadiationMeasurment>();
	private int number;
	private int id;
	private static volatile boolean canceled = false;
	public static void cancel() {
		canceled = true;
	}
	public RadiationMeasurment(int id) {
		this.id = id;
		radiations.add(this);
	}
	public void run() {
		while(!canceled) {
			synchronized(this) {
				++number;	
			}
			System.out.println(this + " Razem: " + radiation.getMeasure());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch(InterruptedException e) {
				System.out.println("przerwano uœpienie");
			}
		}
		System.out.println("Zatrzymanie: " + this);
	}
	public synchronized int getNumber() {
		return number;
	}
	public String toString() {
		return "Pomiar " + id + ": " + getNumber();
	}
	public static double getTotalCount() {
		return radiation.getValue();
	}
	public static int measurmentsNumber() {
		int number = 0;
		for(RadiationMeasurment rm : radiations) 
			number += rm.getNumber();
		return number;
	}
}

public class RadiationMeter {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++)
			exec.execute(new RadiationMeasurment(i));
		TimeUnit.SECONDS.sleep(3);
		RadiationMeasurment.cancel();
		exec.shutdown();
		if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
			System.out.println("Niektóre zadania wci¹¿ dzia³aj¹!");
		System.out.println("Razem: " + RadiationMeasurment.getTotalCount());
		System.out.println("Suma pomiarów: " + RadiationMeasurment.measurmentsNumber());
	}
}

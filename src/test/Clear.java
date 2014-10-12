package test;

import java.util.concurrent.TimeUnit;
import static java.lang.System.*;

public class Clear {
	public static void main(String[] args) {
		Thread a = new Thread(new CV());
		a.start();
	}
}

class CV implements Runnable {

	@Override
	public void run() {
		while(true) {
			try {
				search();
				clearConsole();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void search() throws Exception {
		out.print("Szukam");
		TimeUnit.SECONDS.sleep(1);
		out.print(".");
		TimeUnit.SECONDS.sleep(1);
		out.print(".");
		TimeUnit.SECONDS.sleep(1);
		out.print(".");
		TimeUnit.SECONDS.sleep(1);
		out.println("");
	}
	
	public void clearConsole() throws Exception {
		try {
	        final String os = System.getProperty("os.name");
	        out.println(os);
	        if (os.contains("Windows")) {
	            Runtime.getRuntime().exec("cls");
	        }
	        else {
	            Runtime.getRuntime().exec("clear");
	        }
	    } catch (final Exception e) {
	        out.println("Exception");
	    }
	}
	
}
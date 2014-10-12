package algorytmy;

import java.util.Random;

public class RandomIntGenerator {
	public static int[] randomTable(int size) {
		int[] table = new int[size];
		Random random = new Random();
		for(int i = 0; i < table.length; i++)
			table[i] = random.nextInt(100);
		return table;
	}
}

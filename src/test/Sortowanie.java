package test;

public class Sortowanie {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] tablica = {3, 6, 5, 10, 27, 11, 1, 4};
		
		System.out.println("Przed sortowanie: ");
		for(int i = 0; i < tablica.length; i++)
			System.out.print(tablica[i] + " ");
		
		for(int i = tablica.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				int a = tablica[j];
				int b = tablica[j + 1];
				if(a > b) {
					tablica[j] = b;
					tablica[j + 1] = a;
				}
			}
		}
		
		System.out.println("\nPo sortowanie: ");
		for(int i = 0; i < tablica.length; i++)
			System.out.print(tablica[i] + " ");
		
		System.out.println("\n" + Sortowanie.max(tablica));
		System.out.println(Sortowanie.min(tablica));
		
		long stop = System.currentTimeMillis();
		
		System.out.println("Czas wykonania: " + (stop - start) + "ms");
	}
	
	static String max(int[] tab) {
		int max = 0;
		int maxIndeks = 0;
		for(int i = 0; i < tab.length; i++) {
			if(tab[i] > max) {
				max = tab[i];
				maxIndeks = i;
			}
		}

		return "Najwyzsza wartosc: " + max + ", indeks " + maxIndeks;
	}
	
	static String min(int[] tab) {
		int min = 100000;
		int minIndeks = 0;
		for(int i = 0; i < tab.length; i++) {
			if(tab[i] < min) {
				min = tab[i];
				minIndeks = i;
			}
		}

		return "Najnizsza wartosc: " + min + ", indeks " + minIndeks;
	}
}

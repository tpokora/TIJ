package algorytmy;

public class WyszukiwanieLiniowe {
	public static void main(String[] args) {
		WyszukiwanieLiniowe wl = new WyszukiwanieLiniowe();
		int[] tab = RandomIntGenerator.randomTable(50000);
		int x = 13;
		System.out.println(wl.printTable(tab));
		System.out.println("Wyszukiwanie wartosci " + x + " w tabeli o wielkosci: " + tab.length);
		int odpowiedz = 0;
		long startTime = System.nanoTime();
		odpowiedz = wl.wyszukiwanieLiniowe(tab, x);
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Wyszukiwanie liniowe, indeks: " + odpowiedz +
				", czas: " + totalTime + "ns");
		
		startTime = System.nanoTime();
		odpowiedz = wl.lepszeWyszukiwanieLiniowe(tab, x);
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Lepsze wyszukiwanie liniowe, indeks: " + odpowiedz +
				", czas: " + totalTime + "ns");
		
		startTime = System.nanoTime();
		odpowiedz = wl.wyszukiwanieLinioweZWartownikiem(tab, x);
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Wyszukiwanie liniowe z wartownikiem, indeks: " + odpowiedz +
				", czas: " + totalTime + "ns");
	}
	
	public String printTable(int[] tablica) {
		System.out.println("Budowanie stringabuildera elementów tablicy.");
		long startTime = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for(int i : tablica)
			sb.append(i + " ,");
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Budowanie stringabuilder elementów tablicy zakończono po: " + totalTime + "ns");
		return sb.toString();
	}
	
	public int wyszukiwanieLiniowe(int[] tablica, int wartosc) {
		int odp = -1;
		for(int i = 0; i < tablica.length; i++)
			if(tablica[i] == wartosc)
				odp = i;
		return odp;
	}
	
	public int lepszeWyszukiwanieLiniowe(int[] tablica, int wartosc) {
		for(int i = 0; i < tablica.length; i++)
			if(tablica[i] == wartosc)
				return i;
		return -1;
	}
	
	public int wyszukiwanieLinioweZWartownikiem(int[] tablica, int wartosc) {
		int ostatni = tablica[tablica.length - 1];
		tablica[tablica.length - 1] = wartosc;
		int i = 0;
		while(tablica[i] != wartosc) {
			i++;
		}
		tablica[tablica.length - 1] = ostatni;
		if(i < tablica.length || ostatni == wartosc)
			return i;
		else
			return -1;
	}
}

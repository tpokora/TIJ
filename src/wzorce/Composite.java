package wzorce;

import java.util.ArrayList;

public class Composite {
	public static void main(String[] args) {
		KatalogRzeczowy kr = new KatalogRzeczowy();
		kr.kat.szukaj("bombaj");
	}
}

class KatalogRzeczowy {
	Kategoria kat = new Kategoria();
}

interface Poszukiwacz {
	void szukaj(String name);
}

class Kategoria implements Poszukiwacz {
	private ArrayList<Ksiazka> lista;
	
	Kategoria() {
		lista = new ArrayList<Ksiazka>();
		lista.add(new Ksiazka(1, "Harry Potter, yo i the park"));
		lista.add(new Ksiazka(2, "Harry Potter, yo 1"));
		lista.add(new Ksiazka(3, "Harry Potter, yo 3"));
		lista.add(new Ksiazka(4, "Bombaj murzynski"));
		lista.add(new Ksiazka(5, "cos tam bombaj"));
		lista.add(new Ksiazka(6, "niewidzialny"));
	}

	public void szukaj(String name) {
		for(Ksiazka k : lista) {
			k.szukaj(name);
		}
	}
}

class Ksiazka implements Poszukiwacz {
	int id;
	private String name;
	
	Ksiazka(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void szukaj(String name) {
		if(this.name.toLowerCase().contains(name.toLowerCase()))
			System.out.println(this.toString());
		else
			System.out.print("");
	}
	
	public String toString() {
		return "#" + id + ": " + this.name;
	}
}

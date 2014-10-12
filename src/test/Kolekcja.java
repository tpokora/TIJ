package test;

import java.util.ArrayList;
import java.util.List;


public class Kolekcja {
	// T... a - zmienna lista argumentow
	public static <T> List<T> jakoLista(T... a) {
		List<T> lista = new ArrayList<T>();
		for(T t : a) {
			lista.add(t);
		}
		return lista;
	}
	
	public static <T> void stringLista(List<String> lista, String... s) {
		for(String str : s) {
			lista.add(str);
		}
	}
	
	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>(
				Kolekcja.jakoLista(1, "dwa", 'c', true, 2.0));
		
		for(Object i : list)
			System.out.println(i);
		
		list.remove("dwa");
		
		System.out.println("Po usunieciu elementu \"dwa\":");
		for(Object i : list)
			System.out.println(i);
		
		System.out.println("Lista String�w:");
		List<String> lista = new ArrayList<String>();
		Kolekcja.stringLista(lista, "yo", "Bum", "123");
		
		for(String s : lista)
			System.out.println(s);
	}
}

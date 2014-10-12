package polymorphism;

import java.util.ArrayList;

public class Sklep {
	public static void main(String[] args) {
		Koszyk koszyk = new Koszyk();
		koszyk.koszyk.add(new Ksiazka(3.20));
		koszyk.koszyk.add(new CD(2.20));
		koszyk.koszyk.add(new Product(3.30));
		for(Product p : koszyk.koszyk) {
			System.out.println(p.toString() + ": " + p.getPrice());
		}
		System.out.println(koszyk.getTotalPrice());
	}
}

class Product {
	protected double price;
	
	public Product(double price) {
		this.price = price;
	}
	
	protected double getPrice() {
		return price;
	}
}

class Ksiazka extends Product {
	public Ksiazka(double price) {
		super(price);
	}
}

class CD extends Product {
	public CD(double price) {
		super(price);
	}
}

class Koszyk {
	public ArrayList<Product> koszyk = new ArrayList<Product>();
	
	public double getTotalPrice() {
		double totalPrice = 0.0;
		for(Product p : koszyk) 
			totalPrice += p.getPrice();
		return totalPrice;
	}
}
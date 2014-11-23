package generics;

interface CarMaker<T> {
	T create(int i);
}

class CarMakerImpl<T> implements CarMaker<T> {
	private Class[] types = { Mercedes.class, Audi.class, Ford.class };
	private T car;
	public T create(int i) {
		switch(i) {
			case 0:
				car = (T) new Mercedes();
				break;
			case 1:
				car = (T) new Audi();
				break;
			case 2: 
				car = (T) new Ford();
				break;
			default: 
				car = (T) new Car();
				break;
			
		}
		return car;
	}
}

class Car {
	protected String name;
	
	public Car() {
		this.name = "NONE";
	}
	
	public String toString() {
		return this.name;
	}
}

class Mercedes extends Car {
	public Mercedes() {
		this.name = "Mercedes";
	}
	
	public String toString() {
		return this.name;
	}
}

class Audi extends Car {
	public Audi() {
		this.name = "Audi";
	}
	
	public String toString() {
		return this.name;
	}
}

class Ford extends Car {
	public Ford() {
		this.name = "Ford";
	}
	
	public String toString() {
		return this.name;
	}
}

class Garage<T> {
	private int size;
	private T[] cars;
	
	public Garage(int size) {
		this.size = size;
		cars = (T[]) new Car[size];
		for(int i = 0; i < cars.length; i++)
			cars[i] = (T) new Car();
	}
	
	public int getGarageSize() {
		return size;
	}
	
	public String showGarageContent() {
		String output = "Garage status:\n";
		for(int i = 0; i < cars.length; i++) {
			if(isSpotFree(i)) {
				output += "Spot " + i + " is empty\n";
			} else {
				output += "Spot " + i + ": " + cars[i].toString() + "\n";
			}
		}
		return output;
	}
	
	public void parkCar(T car) {
		boolean carParked = false;
		int carSpot = 0;
		for(int i = 0; i < cars.length; i++) {
			if(isSpotFree(i)) {
				cars[i] = car;
				carParked = true;
				carSpot = i;
				break;
			}
		}
		if(carParked) {
			System.out.println("Car " + car.toString() + " parked at spot: " + carSpot);
		} else {
			System.out.println("All Spots are full, cannot park: " + car.toString());
		}
	}
	
	public String unparkCar(int index) {
		if(cars[index].getClass().getSimpleName().equals("Car")) {
			return "Spot " + index + " is free, no need to unpark";
		} else {
			String output = cars[index].toString() + " unparked from spot " + index;
			cars[index] = (T) new Car();
			return output;
		}
	}
	
	public boolean isSpotFree(int index) {
		if(cars[index].getClass().getSimpleName().equals("Car")) {
			return true;
		} else {
			return false;
		}
	}
	
	
}

public class GenericInterfaceTest {
	public static void main(String[] args) {
		CarMakerImpl<Car> carMaker = new CarMakerImpl<Car>();
		Garage<Car> garage = new Garage<Car>(4);
		System.out.println(garage.showGarageContent());
		garage.parkCar(carMaker.create(0));
		garage.parkCar(carMaker.create(2));
		garage.parkCar(carMaker.create(2));
		System.out.println(garage.showGarageContent());
		System.out.println(garage.unparkCar(1));
		System.out.println(garage.showGarageContent());
		garage.parkCar(carMaker.create(1));
		garage.parkCar(carMaker.create(2));
		System.out.println(garage.showGarageContent());
		garage.parkCar(carMaker.create(2));
		System.out.println(garage.showGarageContent());
	}
}

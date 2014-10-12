package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

class Student {
	private String name;
	private int age;
	private final SimpleDateFormat DATE_FORMAT = 
			new SimpleDateFormat("yyyy-MM-dd");
	private Date date;
	
	public Student(String name, int age, Date date) {
		this.name = name;
		this.age = age;
		this.date = date;
	}
	
	public String getName() { return name; }
	public int getAge() { return age; }
	public String getDate() { return DATE_FORMAT.format(date); }
	
	public String toString() {
		return name + ": " + age + " : " + getDate();
	}
}

public class Kont {
	public static void main(String[] args) throws Exception {
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Andrzej", 23, new SimpleDateFormat("yyyy-MM-dd").parse("2014-10-02")));
		studentList.add(new Student("Tomek", 24, new SimpleDateFormat("yyyy-MM-dd").parse("2014-06-02")));
		studentList.add(new Student("Ala", 16, new SimpleDateFormat("yyyy-MM-dd").parse("2014-09-02")));
		studentList.add(new Student("Kasia", 18, new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-02")));
		
		System.out.println("Przed sortowaniem:\n" + studentList);
		
		Collections.sort(studentList, new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
		});
		
		System.out.println("Po sortowaniem:\n" + studentList);
		
	}
}

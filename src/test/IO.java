package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
	private InputStreamReader in = null;
	private BufferedReader br = null;
	private FileReader fr = null;
	private String fileName = "F:\\JAVA\\TIJ\\src\\test\\plik.txt";
	
	public static void main(String[] args) {
		IO io = new IO();
		io.readDataFromConsole();
		io.readDataFromFile();
		io.readLineNumberFromFile();
	}
	
	public void readDataFromConsole() {
		try {
			in = new InputStreamReader(System.in);
			br = new BufferedReader(in); 
			System.out.print("Jak masz na imie?: ");
			String nameInput = br.readLine(); 
			System.out.println("Imie: " + nameInput);
			System.out.print("Ile masz lat?: ");
			int ageInput = Integer.parseInt(br.readLine());
			System.out.println("Wiek: " + ageInput);
		} catch(IOException e) {
			System.out.println("ERROR");
		} catch(Exception e) {
			System.out.println("qwe");
		} finally {
			try {
				in.close();
				br.close();
			} catch (IOException e) {
				System.out.println("B³¹d zamykania strumieni funkcji #1");
			}
		}
	}
	
	public void readDataFromFile() {
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line;
			System.out.println("ODCZYT Z PLIKU");
			while((line = br.readLine()) != null) 
				System.out.println(line);
			System.out.println("KONIEC PLIKU");
		} catch(FileNotFoundException e) {
			System.out.println("Nieznaleziono pliku!");
		} catch(IOException e) {
			System.out.println("B³¹d odczytu pliku!");
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				System.out.println("B³¹d zamykania strumieni funkcji #2");
			}
			
		}
	}
	
	public void readLineNumberFromFile() {
		try {
			in = new InputStreamReader(System.in);
			br = new BufferedReader(in);
			System.out.print("Podaj numer linii, który chcesz odczytaæ: ");
			int lineNumberToRead = Integer.parseInt(br.readLine());
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line = "";
			int lineNumber = 0;
			while((line = br.readLine()) != null) {
				++lineNumber;
				if(lineNumber == lineNumberToRead) {
					System.out.println("Linia " + lineNumberToRead + ": " + line);
					break;
				}
			}
			if(line == null)
				System.out.println("Nie znaleziono linie o takim numerze");
		} catch(FileNotFoundException e) {
			System.out.println("Nieznaleziono pliku!");
		} catch(IOException e) {
			System.out.println("B³¹d odczytu pliku!");
		} finally {
			try {
				in.close();
				fr.close();
				br.close();
			} catch (IOException e) {
				System.out.println("B³¹d zamykania strumieni funkcji #3");
			}
			
		}
	}
}

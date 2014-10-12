package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg {
	public static void main(String[] args) {
		for(int i = 0; i < args.length; i++)
			System.out.println("Argumenty[" + i + "] "  + args[i]);
		String patternStr = args[args.length - 1];
		System.out.println("Pattern from args: " + patternStr);
		String kodPocztowy = "32-050";
		//Pattern pattern = Pattern.compile("\\d{2}-\\d{3}");
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(kodPocztowy);
		if(matcher.matches()) 
			System.out.println(kodPocztowy + ": zgadza sie");
		else
			System.out.println(kodPocztowy + ": nie zgadza sie");
	}
}

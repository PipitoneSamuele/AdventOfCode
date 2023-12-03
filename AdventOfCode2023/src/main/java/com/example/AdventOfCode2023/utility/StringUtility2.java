package com.example.AdventOfCode2023.utility;

import java.util.HashMap;

public class StringUtility2 {
	
	public static boolean isValidGame(String s, HashMap<Character, Integer> validValues) {
		
		s = s.substring(4); //remove game
		
		String[] games = s.split("\\;");
		games[0] = games[0].split("\\:")[1]; //remove the number and :
		
		int currentValue = 0;
		char currentColor = 'z';
		
		for(String st : games) {
			st = st.substring(1); //remove the first space
			
			String[] extraction = st.split("\\, ");
			
			for(String str : extraction) {
				if(str.charAt(1) != ' ') {
					currentValue = Integer.parseInt(str.substring(0, 2));
					currentColor = str.charAt(3);
				} else {
					currentValue = str.charAt(0) - '0';
					currentColor = str.charAt(2);
				}
				if(currentValue > validValues.get(currentColor)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static int calculatePowerMinColors(String s) {
		
		s = s.substring(4); //remove game
		
		String[] games = s.split("\\;");
		games[0] = games[0].split("\\:")[1]; //remove the number and :
		
		int currentValue = 0;
		char currentColor = 'z';
		int maxValueBlue = 1;
		int maxValueRed = 1;
		int maxValueGreen = 1;
		
		for(String st : games) {
			st = st.substring(1); //remove the first space
			
			String[] extraction = st.split("\\, ");
			
			for(String str : extraction) {
				if(str.charAt(1) != ' ') {
					currentValue = Integer.parseInt(str.substring(0, 2));
					currentColor = str.charAt(3);
				} else {
					currentValue = str.charAt(0) - '0';
					currentColor = str.charAt(2);
				}
				switch(currentColor) {
				case 'g': {
					if(currentValue > maxValueGreen) maxValueGreen = currentValue;
					break;
				}
				case 'b': {
					if(currentValue > maxValueBlue) maxValueBlue = currentValue;
					break;
				}
				case 'r':  {
					if(currentValue > maxValueRed) maxValueRed = currentValue;
					break;
				}
				default: break;
				}
			}
		}
		return maxValueBlue * maxValueRed * maxValueGreen;
	}


}

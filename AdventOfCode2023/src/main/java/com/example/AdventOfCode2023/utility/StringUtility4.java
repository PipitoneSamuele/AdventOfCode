package com.example.AdventOfCode2023.utility;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringUtility4 {
	
	public static int calculateWinningNumbers(String s) {
		
		String[] splitString = s.split("\\:");
		s = splitString[1].substring(1);
		
		String[] divideCurrentFromWinning = s.split("\\|");
		String current = divideCurrentFromWinning[0];
		String winning = divideCurrentFromWinning[1].substring(1);
		
		Set<String> winningNumbersSet = new HashSet<String>();
		int pointer = 0;
		
		while(pointer < winning.length()) {
			winningNumbersSet.add(winning.substring(pointer, pointer+2));
			pointer += 3;
		}
		
		pointer = 0;
		int countWinning = 0;
		
		while(pointer < current.length()) {
			if(winningNumbersSet.contains(current.substring(pointer, pointer+2))) {
				countWinning += 1;
			}
			pointer += 3;
		}
		
		if(countWinning == 0) return 0;
		else if(countWinning == 1) return 1;
		else return (int) Math.pow(2, countWinning-1);
	}
	
	public static Map<Integer, Integer> calculateWinningNumbersCumulative(String s, Map<Integer, Integer> copies, int currentPos) {
		
		String[] splitString = s.split("\\:");
		s = splitString[1].substring(1);
		
		String[] divideCurrentFromWinning = s.split("\\|");
		String current = divideCurrentFromWinning[0];
		String winning = divideCurrentFromWinning[1].substring(1);
		
		Set<String> winningNumbersSet = new HashSet<String>();
		int pointer = 0;
		
		while(pointer < winning.length()) {
			winningNumbersSet.add(winning.substring(pointer, pointer+2));
			pointer += 3;
		}
		
		pointer = 0;
		int countWinning = 0;
		
		while(pointer < current.length()) {
			if(winningNumbersSet.contains(current.substring(pointer, pointer+2))) {
				countWinning += 1;
			}
			pointer += 3;
		}
		
		int currentValue;
		
		for(int i = 0; i < countWinning; i++) {
			copies.put(currentPos+i, copies.get(currentPos+i) + copies.get(currentPos-1));
		}
		
		return copies;
	}

}

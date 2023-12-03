package com.example.AdventOfCode2023.days;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.example.AdventOfCode2023.utility.StringUtility;
import com.example.AdventOfCode2023.utility.StringUtility2;

public class Day2 {

	public static int executeFirstProblem() throws IOException {
		int ret = 0;
		int count = 1;
		
		List<String> strings = StringUtility.readFileTxt("day2-first.txt");
		
		HashMap<Character, Integer> validValues = new HashMap<Character, Integer>();
		validValues.put('r', 12);
		validValues.put('g', 13);
		validValues.put('b', 14);
		
		for(String s : strings) {
			if(StringUtility2.isValidGame(s, validValues)) {
				ret += count;
			}
			count += 1;
		}
		return ret;
	}
	
	public static int executeSecondProblem() throws IOException  {
		int ret = 0;
		
		List<String> strings = StringUtility.readFileTxt("day2-first.txt");
		
		for(String s : strings) {
			ret += StringUtility2.calculatePowerMinColors(s);
		}
		return ret;
	}
	
}

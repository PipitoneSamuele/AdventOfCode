package com.example.AdventOfCode2023.days;

import java.io.IOException;
import java.util.List;

import com.example.AdventOfCode2023.utility.StringUtility;

public class Day1 {
	
	public static int executeFirstProblem() throws IOException {
		int ret = 0;
		
		List<String> strings = StringUtility.readFileTxt("day1-first.txt");
		
		for(String s : strings) {
			ret += StringUtility.calculateValueFirstLast(s);
		}
		return ret;
	}
	
	public static int executeSecondProblem() throws IOException {
		int ret = 0;
		
		List<String> strings = StringUtility.readFileTxt("day1-first.txt");
		
		for(String s : strings) {
			ret += StringUtility.calculateValueFirstLastWords(s);
		}
		return ret;
	}

}

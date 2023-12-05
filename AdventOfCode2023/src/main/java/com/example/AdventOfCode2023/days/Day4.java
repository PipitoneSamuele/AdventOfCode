package com.example.AdventOfCode2023.days;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.AdventOfCode2023.utility.StringUtility;
import com.example.AdventOfCode2023.utility.StringUtility4;

public class Day4 {
	
	public static int executeFirstProblem() throws IOException {
		int ret = 0;
		
		List<String> strings = StringUtility.readFileTxt("day4-first.txt");
		
		for(String s : strings) {
			ret += StringUtility4.calculateWinningNumbers(s);
		}
		return ret;
	}
	
	public static int executeSecondProblem() throws IOException {
		int ret = 0;
		
		List<String> strings = StringUtility.readFileTxt("day4-first.txt");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 1;
		
		for(int i = 0; i < strings.size(); i++) {
			map.put(i, 1);
		}
		for(String s : strings) {
			map = StringUtility4.calculateWinningNumbersCumulative(s, map, count);
			count += 1;
		}
		for(int i = 0; i < strings.size(); i++)  {
			ret += map.get(i);
		}
		return ret;
	}

}

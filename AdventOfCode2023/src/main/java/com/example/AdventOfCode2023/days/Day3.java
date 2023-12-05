package com.example.AdventOfCode2023.days;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.AdventOfCode2023.utility.StringUtility;

public class Day3 {
	
	public static int executeFirstProblem() throws IOException {
		
		List<String> strings = StringUtility.readFileTxt("day3-first.txt");
		char current;
		int ret = 0;
		
		char[][] inputMatrix = new char[strings.get(0).length()][strings.size()];
		Set<Integer> alreadyAdded = new HashSet<Integer>();
		
		for(int i = 0; i < inputMatrix.length; i++) {
			for(int j = 0; j < inputMatrix[0].length; j++) {
				inputMatrix[i][j] = strings.get(i).charAt(j);
			}
		}
		
		//controlla dimensione della matrice
		for(int i = 0; i < inputMatrix.length; i++) {
			for(int j = 0; j < inputMatrix[0].length; j++) {
				current = inputMatrix[i][j];
				alreadyAdded = new HashSet<Integer>();
				if(!Character.isDigit(current) && current != '.') {
					if(i > 0 && Character.isDigit(inputMatrix[i-1][j])) { //up
						ret = updateValueFromString(inputMatrix[i-1], j, ret, alreadyAdded);
					}
					if(i > 0 && j < inputMatrix[0].length - 1 && Character.isDigit(inputMatrix[i-1][j+1])) { //up-right
						ret = updateValueFromString(inputMatrix[i-1], j+1, ret, alreadyAdded);
					} 
					if(i > 0 && j > 0 && Character.isDigit(inputMatrix[i-1][j-1])) { //up-left
						ret = updateValueFromString(inputMatrix[i-1], j-1, ret, alreadyAdded);
					} 
					if(j > 0 && Character.isDigit(inputMatrix[i][j-1])) { //left
						ret = updateValueFromString(inputMatrix[i], j-1, ret, alreadyAdded);
					} 
					if(j < inputMatrix[0].length - 1 && Character.isDigit(inputMatrix[i][j+1])) { //right
						ret = updateValueFromString(inputMatrix[i], j+1, ret, alreadyAdded);
					} 
					if(i < inputMatrix.length - 1 && Character.isDigit(inputMatrix[i+1][j])) { //under
						ret = updateValueFromString(inputMatrix[i+1], j, ret, alreadyAdded);
					} 
					if(i < inputMatrix.length - 1 && j > 0 && Character.isDigit(inputMatrix[i+1][j-1])) { //under-left
						ret = updateValueFromString(inputMatrix[i+1], j-1, ret, alreadyAdded);
					} 
					if(i < inputMatrix.length - 1 && j < inputMatrix[0].length - 2 && Character.isDigit(inputMatrix[i+1][j+1])) { //under-right
						ret = updateValueFromString(inputMatrix[i+1], j+1, ret, alreadyAdded);
					}
				} 
			}
		}
		return ret;
	}
	
	private static int updateValueFromString(char[] string, int pos,
			int ret, Set<Integer> alreadyAdded) throws NumberFormatException {
		
		StringBuilder sb = new StringBuilder();
		int value;
		
		while(Character.isDigit(string[pos]) && pos > 0 && pos < string.length - 1) {
			pos -= 1;
		}
		if(pos != 0) pos += 1;
		else if(!Character.isDigit(string[pos])) pos += 1;
		
		while(Character.isDigit(string[pos]) && pos < string.length - 1) {
			sb.append(string[pos]);
			pos += 1;
		}
		
		value = Integer.valueOf(sb.toString());
		
		if(alreadyAdded.contains(value)) {
			return ret;
		} else {
			System.out.println(value);
			alreadyAdded.add(value);
			return ret + value;
		}
	}
	
	

}

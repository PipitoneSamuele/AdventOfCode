package com.example.AdventOfCode2023.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringUtility {
	
	public static List<String> readFileTxt(String fileName) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\samue\\Desktop\\projects\\AdventOfCode\\AdventOfCode2023\\src\\main\\resources\\files\\" + fileName))) {
			List<String> strings = new ArrayList<String>();
			String s;
			
			while((s = br.readLine()) != null) {
				strings.add(s);
			}
			
			return strings;
		}
	}
	
	public static int calculateValueFirstLast(String s) {
		char firstValue = 'a';
		char lastValue = 'a';
		
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				firstValue = s.charAt(i);
				break;
			}
		}
		
		for(int i = s.length()-1; i >= 0; i--) {
			if(Character.isDigit(s.charAt(i))) {
				lastValue = s.charAt(i);
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(firstValue != 'a') {
			sb.append(firstValue);
		} 
		if(lastValue != 'a') {
			sb.append(lastValue);
		}
		
		return Integer.parseInt(sb.toString());
	}
	
	/**
	 * Terrible solution but fast and working
	 * 
	 * @param s
	 * @return
	 */
	public static int calculateValueFirstLastWords(String s) {
		char firstValue = 'a';
		char lastValue = 'a';
		
		for(int i = 0; i < s.length(); i++) {
			if(firstValue != 'a') {
				break;
			} else if(Character.isDigit(s.charAt(i))) {
				firstValue = s.charAt(i);
				break;
			} else switch(s.charAt(i)) {
			case 'o': {
				try {
					if(firstValue == 'a' && s.charAt(i+1) == 'n' && s.charAt(i+2) == 'e') {
						firstValue = '1';
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			case 't': {
				try {
					if(firstValue == 'a' && s.charAt(i+1) == 'h') {
						if(s.charAt(i+2) == 'r' && s.charAt(i+3) == 'e' && s.charAt(i+4) == 'e') {
							firstValue = '3';
						}
					} else if(firstValue == 'a' && s.charAt(i+1) == 'w') {
						if(s.charAt(i+2) == 'o') {
							firstValue = '2';
						}
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			case 'f': {
				try {
					if(firstValue == 'a' && s.charAt(i+1) == 'o') {
						if(s.charAt(i+2) == 'u' && s.charAt(i+3) == 'r') {
							firstValue = '4';
						}
					} else if(firstValue == 'a' && s.charAt(i+1) == 'i') {
						if(s.charAt(i+2) == 'v' && s.charAt(i+3) == 'e') {
							firstValue = '5';
						}
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			case 's': {
				try {
					if(firstValue == 'a' && s.charAt(i+1) == 'i') {
						if(s.charAt(i+2) == 'x') {
							firstValue = '6';
						}
					} else if(firstValue == 'a' && s.charAt(i+1) == 'e') {
						if(s.charAt(i+2) == 'v' && s.charAt(i+3) == 'e' && s.charAt(i+4) == 'n') {
							firstValue = '7';
						}
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			case 'e': {
				try {
					if(firstValue == 'a' && s.charAt(i+1) == 'i' && s.charAt(i+2) == 'g' 
							&& s.charAt(i+3) == 'h' && s.charAt(i+4) == 't') {
						firstValue = '8';
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			case 'n': {
				try {
					if(firstValue == 'a' && s.charAt(i+1) == 'i' && s.charAt(i+2) == 'n' 
							&& s.charAt(i+3) == 'e') {
						firstValue = '9';
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			default: break;
			}
		}
		
		for(int i = s.length()-1; i >= 0; i--) {
			if(lastValue != 'a') {
				break;
			} else if(Character.isDigit(s.charAt(i))) {
				lastValue = s.charAt(i);
				break;
			} else switch(s.charAt(i)) {
			case 'o': {
				try {
					if(lastValue == 'a' && s.charAt(i+1) == 'n' && s.charAt(i+2) == 'e') {
						lastValue = '1';
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			case 't': {
				try {
					if(lastValue == 'a' && s.charAt(i+1) == 'h') {
						if(s.charAt(i+2) == 'r' && s.charAt(i+3) == 'e' && s.charAt(i+4) == 'e') {
							lastValue = '3';
						}
					} else if(lastValue == 'a' && s.charAt(i+1) == 'w') {
						if(s.charAt(i+2) == 'o') {
							lastValue = '2';
						}
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			case 'f': {
				try {
					if(lastValue == 'a' && s.charAt(i+1) == 'o') {
						if(s.charAt(i+2) == 'u' && s.charAt(i+3) == 'r') {
							lastValue = '4';
						}
					} else if(lastValue == 'a' && s.charAt(i+1) == 'i') {
						if(s.charAt(i+2) == 'v' && s.charAt(i+3) == 'e') {
							lastValue = '5';
						}
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			case 's': {
				try {
					if(lastValue == 'a' && s.charAt(i+1) == 'i') {
						if(s.charAt(i+2) == 'x') {
							lastValue = '6';
						}
					} else if(lastValue == 'a' && s.charAt(i+1) == 'e') {
						if(s.charAt(i+2) == 'v' && s.charAt(i+3) == 'e' && s.charAt(i+4) == 'n') {
							lastValue = '7';
						}
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			case 'e': {
				try {
					if(lastValue == 'a' && s.charAt(i+1) == 'i' && s.charAt(i+2) == 'g' 
							&& s.charAt(i+3) == 'h' && s.charAt(i+4) == 't') {
						lastValue = '8';
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			case 'n': {
				try {
					if(lastValue == 'a' && s.charAt(i+1) == 'i' && s.charAt(i+2) == 'n' 
							&& s.charAt(i+3) == 'e') {
						lastValue = '9';
					}
				} catch(Exception e) {
					break;
				}
				break;
			}
			default: break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(firstValue != 'a') {
			sb.append(firstValue);
		} 
		if(lastValue != 'a') {
			sb.append(lastValue);
		}
		
		return Integer.parseInt(sb.toString());
	}

	
}

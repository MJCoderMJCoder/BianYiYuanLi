package com.by;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NiBoLan {

	public static void main(String[] args) throws IOException {
		int i = 0, j = 0; 
		String str;
		System.out.println("请输入一串中序表达式：");
		BufferedReader buf = new BufferedReader( new InputStreamReader(System.in));
		str = buf.readLine(); 
		char m[] = new char[20]; 
		for (int o = 0; o < str.length(); o++) { 
			m[o] = str.charAt(o); 
		}
		for (int o = str.length(); o < 20; o++) { 
			m[o] = ' '; 
		}
		char n[] = new char[m.length]; 
		for (int o = 0; o < n.length; o++) 
			n[o] = ' '; 
		System.out.println("逆波兰式为：");
		while (i <= str.length()) { 
			if (m[i] == ' ') { 
				if (n[j] == ' ') { 
					System.out.println("\n"+"结束！");
					System.exit(0); 
				} else { 
					do { 
						if (n[j] != '('&&n[j] != ')') 
							System.out.print( n[j]); 
						n[j] = ' '; 
						if (j >= 1) 
							j--; 
					}
					while (n[j] != ' '); 
					j = j + 1; 
				}
			} else if (isOperator(m[i])) { 
				while (isOperator(m[i])) { 
					if (n[j] == ' ') { 
						n[j] = m[i]; 
						i++; 
					} else if (priority(n[j],m[i] ) == '<') { 
						j++; 
						n[j] = m[i]; 
						i++; 
					} else if (m[i] == '(') {
						while (j > 0) {
							if (n[j] == ')') { 
								n[j] = ' '; 
								i++; 
							} else { 
								if (n[0] == ' ') { 
									System.out.println("Error"); 
								} else { 
									if (n[j] != '('&&n[j] != ')') 
										System.out.print( n[j]); 
									n[j] = ' '; 
									if (j >= 1) 
										j--; 
									i++; 
								}
							}
						}
					} else { 
						if (n[j] != '('&&n[j] != ')')
							System.out.print( n[j]); 
						n[j] = ' '; 
						if (j >= 1) 
							j--; 
					}
				}
			} else { 
				System.out.print(m[i]); 
				i++; 
			}
		}
	}
	public static char priority(char operator1, char operator2) { 
		int a = 0, b = 0;
		char operatorPriorMatrix[][] = { { '>', '>', '<', '<', '<', '>' }, 
				{ '>', '>', '<', '<', '<', '>' }, 
				{ '>', '>', '>', '>', '<', '>' }, 
				{ '>', '>', '>', '>', '<', '>' }, 
				{ '<', '<', '<', '<', '<', '=' }, 
				{ '>', '>', '>', '>', ' ', '>' } 
		};
		switch (operator1) { 
		case '+': 
			a = 0; 
			break; 
		case '-': 
			a = 1; 
			break; 
		case '*': 
			a = 2; 
			break; 
		case '/': 
			a = 3; 
			break; 
		case '(': 
			a = 4; 
			break;
		case ')': 
			a = 5; 
			break; 
		}
		switch (operator2) { 
		case '+': 
			b = 0; 
			break; 
		case '-': 
			b = 1; 
			break; 
		case '*': 
			b = 2; 
			break; 
		case '/': 
			b = 3; 
			break; 
		case '(': 
			b = 4; 
			break;
		case ')': 
			b = 5; 
			break; 
		}
		return operatorPriorMatrix[a][b]; 
	}
	public static boolean isOperator(char operator) {
		if (operator == '+' || operator == '-' || operator == '*'|| operator == '/' || operator == '(' || operator == ')')
			return true; 
		else 
			return false; 
	}

}

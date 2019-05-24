package com.by;

/**
 * 整数部分.小数部分E±指数部分
 * w：尾数累加器，初值0
 * ：指数累加器，初值0
 * j：十进制小数计数器，初值0
 * e：符号，初值为1，当遇到E后面的负号是改为-1.
 * 	1正，-1负
 * 无符号数：
 * 	num=w*10(e*p-j)
 * 遇到整数的每一位数字d时，做10*w+d=>w。
 * 遇到小数的每一位数字d,w*10+d=>w     j+1=>j
 * 指数部分：扫描到E之后为负号，做-1=>e.
 * 	  扫描到十进制指数中的每一位数字时，做10*p+d=>p
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WuFHCiFaFX {
	public static void main(String[] args) throws IOException {
		int p=0, w=0, w1=0, j=0, i=0, d=0, e=1;
		double w2=0;
		String str;
		System.out.println("请输入一串字符以分号结束：");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));  
		str = buf.readLine();
		char m[] = new char[100]; 
		for (i = 0; i < str.length(); i++) {
			m[i] = str.charAt(i);  
		}
		i = 0;
		while (i < str.length()) { 
			if (m[i] < 48 || m[i] > 57) {
				i++; 
			}else { 
				do { 
					d = m[i] - 48;
					w = w * 10 + d; 
					j++; 
					i++; 
				}
				while (m[i] >= 48 && m[i] <= 57); 	// System.out.println("chesi"+m[i]);
				if (m[i] != '.') { 
					if (m[i] != 'E') { 
						System.out.println("整型数为：" + w); 
						j = 0;
						w = 0; 
					} else { 
						i++; 
						if (m[i] == '-') { 
							e = -1; 
							i++; 
							if (m[i] >= 48 && m[i] <= 57) { 
								do { 
									d = m[i] - 48; 
									p = p * 10 + d; 
									i++;  
								}
								while (m[i] >= 48 && m[i] <= 57); 
								if (j > 1) 
									w2 = w / (Math.pow(10.0, j - 1));
								System.out.println("实型数为：" + w2 + "*10" + "  " + (e * (p - j + 1)));  
								j = 0;
								w2 = 0;
								w = 0; 
								p = 0;
								}else 
									System.out.println("您输入有误！");  
						} else if (m[i] == '+') { 
							i++; 
							if (m[i] >= 48 && m[i] <= 57) { 
								do { 
									d = m[i] - 48; 
									p = p * 10 + d; 
									i++;  
								}
								while (m[i] >= 48 && m[i] <= 57); 
								if (j > 1)
									w2 = w / (Math.pow(10.0, j - 1));  
								System.out.println("实型数为：" + w2 + "*10" + " " + (e * (p + j - 1)));
								j = 0;
								w2 = 0; 
								w = 0;
								p = 0;
							}else 
								System.out.println("您输入有误！");  
						}else {
							if (m[i] >= 48 && m[i] <= 57) { 
								do { 
									d = m[i] - 48; 
									p = p * 10 + d; 
									i++; 
								}
								while (m[i] >= 48 && m[i] <= 57); 
								if (j > 1) 
									w2 = w / (Math.pow(10.0, j - 1));
								System.out.println("实型数为：" + w2 + "*10" + " " + (e * (p + j - 1)));
								j = 0;
								w2 = 0; 
								w = 0; 
								p = 0; 
							}else 
								System.out.println("您输入有误！");  
						}
					}
				}else { 
					i++; 
					if (m[i] >= 48 && m[i] <= 57) { 
						do { 
							d = m[i] - 48; 
							w1 = w1 * 10 + d; 
							// j = j + 1; 
							i++;  
						}
						 while (m[i] >= 48 && m[i] <= 57); 
					}else 
						System.out.println("您输入有误！");
					if (m[i] != 'E') { 
						System.out.println("小数为：" + w + '.' + w1);
						w = 0; 
						w1 = 0; 
						j = 0;  
					} else if (m[i] == 'E') { 
						i++; 
						if (m[i] == '-') { 
							e = -1; 
							i++; 
							if (m[i] >= 48 && m[i] <= 57) { 
								do { 
									d = m[i] - 48; 
									p = p * 10 + d; 
									i++;  
								}
								while (m[i] >= 48 && m[i] <= 57); 
								if (j > 1) { 
									w2 = w / (Math.pow(10.0, j - 1)); 
									System.out.println("实型数为：" + w2 + w1 + "*10" + " " + (e * (p - j + 1)));
									w = 0;
									w1 = 0; 
									j = 0; 
									w2 = 0; 
									p = 0;  
								}else { 
									System.out.println("实型数为：" + w + '.' + w1 + "*10" + " " + (e * (p - j + 1)));
									w = 0;
									w1 = 0;
									j = 0; 
									w2 = 0; 
									p = 0;  
								}
							}else
								System.out.println("您输入有误！");  
						}else if (m[i] == '+') { 
							i++;  
							if (m[i] >= 48 && m[i] <= 57) { 
								do { 
									d = m[i] - 48; 
									p = p * 10 + d; 
									i++;  
								}
								while (m[i] >= 48 && m[i] <= 57); 
								if (j > 1) { 
									w2 = w / (Math.pow(10.0, j - 1)); 
									System.out.println("实型数为：" + w2 + w1 + "*10" + " " + (e * (p + j - 1)));
									w = 0; 
									w1 = 0; 
									j = 0; 
									w2 = 0; 
									p = 0;  
								} else { 
									System.out.println("实型数为：" + w + '.' + w1 + "*10" + " " + (e * (p + j - 1)));
									w = 0;
									w1 = 0; 
									j = 0; 
									w2 = 0; 
									p = 0;
								}
							}else 
								System.out.println("您输入有误！");
						}else { 
							if (m[i] >= 48 && m[i] <= 57) {
								do { 
									d = m[i] - 48; 
									p = p * 10 + d; 
									i++; 
								}
								while (m[i] >= 48 && m[i] <= 57); 
								if (j > 1) { 
									w2 = w / (Math.pow(10.0, j - 1));  
									System.out.println("实型数为：" + w2 + w1 + "*10" + " " + (e * (p + j - 1)));
									w = 0; 
									w1 = 0; 
									j = 0;
									w2 = 0; 
									p = 0;  
								} else { 
									System.out.println("实型数为：" + w + '.' + w1 + "*10" + " " + (e * (p + j - 1)));
									w = 0;
									w1 = 0; 
									j = 0; 
									w2 = 0; 
									p = 0;  
								}
							} else 
								System.out.println("您输入有误！");
						}
					} else 
						System.out.println("您输入有误！");
				}
			}
		}
	}	
}
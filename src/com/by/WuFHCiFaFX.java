package com.by;

/**
 * ��������.С������E��ָ������
 * w��β���ۼ�������ֵ0
 * ��ָ���ۼ�������ֵ0
 * j��ʮ����С������������ֵ0
 * e�����ţ���ֵΪ1��������E����ĸ����Ǹ�Ϊ-1.
 * 	1����-1��
 * �޷�������
 * 	num=w*10(e*p-j)
 * ����������ÿһλ����dʱ����10*w+d=>w��
 * ����С����ÿһλ����d,w*10+d=>w     j+1=>j
 * ָ�����֣�ɨ�赽E֮��Ϊ���ţ���-1=>e.
 * 	  ɨ�赽ʮ����ָ���е�ÿһλ����ʱ����10*p+d=>p
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WuFHCiFaFX {
	public static void main(String[] args) throws IOException {
		int p=0, w=0, w1=0, j=0, i=0, d=0, e=1;
		double w2=0;
		String str;
		System.out.println("������һ���ַ��ԷֺŽ�����");
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
						System.out.println("������Ϊ��" + w); 
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
								System.out.println("ʵ����Ϊ��" + w2 + "*10" + "  " + (e * (p - j + 1)));  
								j = 0;
								w2 = 0;
								w = 0; 
								p = 0;
								}else 
									System.out.println("����������");  
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
								System.out.println("ʵ����Ϊ��" + w2 + "*10" + " " + (e * (p + j - 1)));
								j = 0;
								w2 = 0; 
								w = 0;
								p = 0;
							}else 
								System.out.println("����������");  
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
								System.out.println("ʵ����Ϊ��" + w2 + "*10" + " " + (e * (p + j - 1)));
								j = 0;
								w2 = 0; 
								w = 0; 
								p = 0; 
							}else 
								System.out.println("����������");  
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
						System.out.println("����������");
					if (m[i] != 'E') { 
						System.out.println("С��Ϊ��" + w + '.' + w1);
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
									System.out.println("ʵ����Ϊ��" + w2 + w1 + "*10" + " " + (e * (p - j + 1)));
									w = 0;
									w1 = 0; 
									j = 0; 
									w2 = 0; 
									p = 0;  
								}else { 
									System.out.println("ʵ����Ϊ��" + w + '.' + w1 + "*10" + " " + (e * (p - j + 1)));
									w = 0;
									w1 = 0;
									j = 0; 
									w2 = 0; 
									p = 0;  
								}
							}else
								System.out.println("����������");  
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
									System.out.println("ʵ����Ϊ��" + w2 + w1 + "*10" + " " + (e * (p + j - 1)));
									w = 0; 
									w1 = 0; 
									j = 0; 
									w2 = 0; 
									p = 0;  
								} else { 
									System.out.println("ʵ����Ϊ��" + w + '.' + w1 + "*10" + " " + (e * (p + j - 1)));
									w = 0;
									w1 = 0; 
									j = 0; 
									w2 = 0; 
									p = 0;
								}
							}else 
								System.out.println("����������");
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
									System.out.println("ʵ����Ϊ��" + w2 + w1 + "*10" + " " + (e * (p + j - 1)));
									w = 0; 
									w1 = 0; 
									j = 0;
									w2 = 0; 
									p = 0;  
								} else { 
									System.out.println("ʵ����Ϊ��" + w + '.' + w1 + "*10" + " " + (e * (p + j - 1)));
									w = 0;
									w1 = 0; 
									j = 0; 
									w2 = 0; 
									p = 0;  
								}
							} else 
								System.out.println("����������");
						}
					} else 
						System.out.println("����������");
				}
			}
		}
	}	
}
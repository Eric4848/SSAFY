package baekjoon;

import java.util.Scanner;

public class bj1254 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] alphs = sc.next().toCharArray();
		int L = alphs.length;
		int answer = L;
		for(int i = L; i <= 2*L; i++) {
			boolean able = true;
			if(i % 2 == 0) {
				for(int d = 0; d < i / 2; d++) {
					if(i/2-1-d < 0 || i/2+d >= L) break;
					if(alphs[i/2-1-d] != alphs[i/2+d]) able = false;
				}
			}
			else {
				for(int d = 1; d <= i / 2; d++) {
					if(i/2-d < 0 || i/2 + d >= L) break;
					if(alphs[i/2-d] != alphs[i/2+d]) able = false;
				}
			}
			if(able) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}


//public class bj1254 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		char[] alphs = sc.next().toCharArray();
//		int L = alphs.length;
//		int answer = 2 * L-1;
//		for(int i = L-1; L / 2 <= i; i--) {
//			int tmp = 0;
//			for(int d = 1; d < L; d++) {
//				if(i+d == L || i-d == -1) break;
//				if(alphs[i+d] != alphs[i-d]) break;
//				tmp++;
//			}
//			answer = Math.min(answer, 2 * (L - tmp) - 1);
//			
//			tmp = 0;
//			for(int d = 0; d < L; d++) {
//				if(i+d == L || i-d-1 == -1) break;
//				if(alphs[i+d] != alphs[i-1-d]) break;
//				tmp++;
//			}
//			if(i + tmp < L) continue;
//			answer = Math.min(answer, 2 * (L - tmp));
//		}
//		System.out.println(answer);
//	}
//}

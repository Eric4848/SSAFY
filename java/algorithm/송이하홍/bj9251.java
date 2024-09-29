package 송이하홍;

import java.util.Scanner;

public class bj9251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();	// 원본(기준)
		String str2 = sc.next();	// 비교
		
		int L1 = str1.length();
		int L2 = str2.length();
		
		// cnt =  2
		// dp =   0123
		// str1 = ABCD
		// str2 = BCD
		
		int[] dp = new int[L1];		// 원본이니까 원본의 index까지 알파벳의 최장 공통 부분문자열의 길이
		for(int s2 = 0; s2 < L2; s2++) {	// 비교하는 문자열의 알파벳을 들고와서 쭉 비교하는거지
			int cnt = 0;	// 현재 알파벳 기준으로 최장 공통 부분문자열(LCS) 초기화
			for(int s1 = 0; s1 < L1; s1++) {	// 원본에다가 비교
				if(cnt < dp[s1])	// 이미 저장된거랑 비교해서 이미 저장된게
					cnt = dp[s1];
				else if(str1.charAt(s1) == str2.charAt(s2))
					dp[s1] = cnt + 1;
			}
		}
		
		int answer = 0;
		for(int i = 0; i < L1; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
}

package 송이하홍;

import java.util.*;
import java.io.*;

class swea5215
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[] scores = new int[N+1];
			int[] calories = new int[N+1];
			for(int i = 1; i <= N; i++) {
				scores[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			
			int[] dp = new int[L+1];
			for(int i = 1; i <= N; i++) {
				int score = scores[i];
				int calory = calories[i];
				for(int j = L; calory <= j; j--) {
					dp[j] = Math.max(dp[j], dp[j-calory] + score);
				}
			}
			System.out.println("#" + tc + " " + dp[L]);
		}
	}
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		for(int tc = 1; tc <= T; tc++) {
//			int N = sc.nextInt();
//			int L = sc.nextInt();
//			int[] scores = new int[N+1];
//			int[] calories = new int[N+1];
//			for(int i = 1; i <= N; i++) {
//				scores[i] = sc.nextInt();
//				calories[i] = sc.nextInt();
//			}
//			
//			int[][] dp = new int[N+1][L+1];
//			for(int i = 1; i <= N; i++) {
//				int score = scores[i];
//				int calory = calories[i];
//				for(int j = 0; j <= L; j++) {
//					if(j < calory)
//						dp[i][j] = dp[i-1][j];
//					else
//						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-calory] + score);
//				}
//			}
//			System.out.println(dp[N][L]);
//		}
//	}
	
// 중복
//public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		for(int tc = 1; tc <= T; tc++) {
//			int N = sc.nextInt();
//			int L = sc.nextInt();
//			int[] scores = new int[N+1];
//			int[] calories = new int[N+1];
//			for(int i = 1; i <= N; i++) {
//				scores[i] = sc.nextInt();
//				calories[i] = sc.nextInt();
//			}
//			
//			int[] dp = new int[L+1];
//			for(int i = 1; i <= N; i++) {
//				int score = scores[i];
//				int calory = calories[i];
//				for(int j = calory; j <= L; j++) {
//					dp[j] = Math.max(dp[j], dp[j-calory] + score);
//				}
//				System.out.println(Arrays.toString(dp));
//			}
//			System.out.println(dp[L]);
//		}
//	}
	
}
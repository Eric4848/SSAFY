package baekjoon;

import java.util.Scanner;

public class bj1535 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] healths = new int[N];
		int[] joies = new int[N];
		int[][]dp = new int[N+1][100];
		
		for(int i = 0; i < N; i++) {
			healths[i] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) {
			joies[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			int health = healths[i];
			for(int j = 0; j < 100; j++)
				dp[i+1][j] = dp[i][j];
			for(int j = health; j < 100; j++) {
				dp[i+1][j] = Math.max(dp[i][j], dp[i][j-health] + joies[i]);
			}
		}
		
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			answer = Math.max(answer, dp[i][99]);
		}
		
		System.out.println(dp[N][99]);
	}
}

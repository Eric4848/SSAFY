package baekjoon;

import java.util.Scanner;

public class bj12015 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		int[] dp = new int[N];
		for(int front = 0; front < N-1; front++) {
			for(int back = front; back < N; back++) {
				if(nums[front] < nums[back])
					dp[back] = Math.max(dp[back], dp[front]+1);
			}
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer+1);
	}
}

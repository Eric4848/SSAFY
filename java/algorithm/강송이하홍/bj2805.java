package 강송이하홍;

import java.util.Scanner;

public class bj2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] trees = new int[N];
		int left = 0;
		int right = 0;
		long answer = 0;
		
		for(int i = 0; i < N; i++) {
			trees[i] = sc.nextInt();
			right = Math.max(right, trees[i]);
		}
		
		while(left <= right) {
			int mid = (left + right) / 2;
			long tmp = 0;
			
			for(int i = 0; i < N; i++) {
				if(mid <= trees[i])
					tmp += trees[i] - mid;
			}
			if(M <= tmp) {
				left = mid + 1;
				answer = mid;
			}
			else
				right = mid - 1;
		}
		
		System.out.println(answer);
	}
}

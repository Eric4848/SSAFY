import java.util.ArrayList;
import java.util.Scanner;

public class swea1959 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T;
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N, M;
			N = sc.nextInt();
			M = sc.nextInt();
			int[] listA = new int[N];
			int[] listB = new int[M];
			for (int i = 0; i < N; i++) {
				listA[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				listB[i] = sc.nextInt();
			}
			
			int maximum = Integer.MIN_VALUE;
			
			if(N < M) {
				for (int d = 0; d < M - N + 1; d++) {
					int total = 0;
					for (int i = 0; i < N; i++) {
						total += listA[i] * listB[i+d];
					}
					maximum = Math.max(maximum,  total);
				}
			} else {
				for (int d = 0; d < N - M + 1; d++) {
					int total = 0;
					for (int i = 0; i < M; i++) {
						total += listA[i+d] * listB[i];
					}
					maximum = Math.max(maximum, total);
				}
			}
			System.out.println("#"+tc+" "+maximum);
			
		}

	}

}

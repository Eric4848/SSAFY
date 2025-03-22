package 종만북;

import java.util.Scanner;

public class winningRate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			long N = sc.nextLong();
			long M = sc.nextLong();
			
			if(N == M) {
				System.out.println(-1);
				continue;
			}

			long rate = 100 * M / N;
			long L = 0;
			long R = 2_000_000_000;
			while(L <= R) {
				long mid = (L + R) / 2;
				long nrate = 100 * (M + mid) / (N + mid);
				if(rate == nrate)
					L = mid + 1;
				else
					R = mid - 1;
			}
			System.out.println(R+1);
		}
	}
}

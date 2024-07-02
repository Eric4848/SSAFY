import java.util.Scanner;

public class swea1859 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N;
			N = sc.nextInt();
			long[] prices = new long[N];
			for(int i = 0; i < N; i++) {
				prices[i] = sc.nextInt();
			}
			long answer = 0;
			long maxPrice = 0;
			for(int i = N-1; 0 <= i; i--) {
				if (maxPrice < prices[i]) {
					maxPrice = prices[i];
				} else {
					answer += maxPrice - prices[i];
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
		
	}

}

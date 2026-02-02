import java.util.Scanner;

public class bj9527 {
	static long[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long A = sc.nextLong();
		Long B = sc.nextLong();
		Long ans = 0L;
		int blen = Long.toBinaryString(B).length();
		dp = new long[blen + 1];
		
		dp[0] = 1;
		for(int i = 1; i <= blen; i++) {
			dp[i] = (dp[i-1] << 1) + (1L << i);
		}

		ans = sum(B) - sum(A-1);
		System.out.println(ans);
		System.out.println(dp[B] - dp[A-1]);
	}
	
	static long sum(long num) {
		long cnt = num & 1;
		int size = Long.toBinaryString(num).length();
		for(int i = size; 0 < i; i--) {
			if((num & (1L<<i)) != 0L) {
				cnt += dp[i-1] + (num - (1L << i) + 1);
				num -= (1L << i);
			}
		}
		return cnt;
	}
}

// 
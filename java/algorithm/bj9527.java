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
		
		// 2진수 i번째 자리까지의 합을 dp에 저장
		dp[0] = 1;
		for(int i = 1; i <= blen; i++) {
			dp[i] = (dp[i-1] << 1) + (1L << i);	// 이전 자리까지의 갯수 + 2의 자릿수 승 ex) 100(2) 자리의 누적갯수 = 10(2)자리까지의 갯수의 2배 + 2의 자릿수 승 (원래 누적합 + 1씩 앞에 더한 원래 누적갯수 반복)
		}

		ans = sum(B) - sum(A-1);
		System.out.println(ans);
	}
	
	static long sum(long num) {
		long cnt = num & 1;
		int size = Long.toBinaryString(num).length();
		for(int i = size; 0 < i; i--) {
			if((num & (1L<<i)) != 0L) {	// 맨앞자리에 1이 있다면
				cnt += dp[i-1] + (num - (1L << i) + 1);	// 해당 자릿수 이전까지의 누적합 + 이후 그 뒷자리의 값들이 변하는동안 계속 맨 앞자리가 존재하므로 맨 현재 계산할 전체 숫자 - 맨 앞만 1인 현재 자리의 숫자개 + 100...일 때 1개를 더함
				num -= (1L << i);	// 계산할 숫자를 맨 앞만 1인 경우만큼 뺌
			}
		}
		return cnt;
	}
}

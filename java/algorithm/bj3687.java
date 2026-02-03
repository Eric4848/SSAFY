import java.util.Arrays;
import java.util.Scanner;

public class bj3687 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] matches = new long[101];
		int[] nums = {1, 7, 4, 2, 0, 8};
		Arrays.fill(matches, Long.MAX_VALUE);
		matches[2] = 1;
		matches[3] = 7;
		matches[4] = 4;
		matches[5] = 2;
		matches[6] = 6;
		matches[7] = 8;
		matches[8] = 10;
		for(int i = 9; i <= 100; i++) {
			for(int j = 2; j <= 7; j++) {
				String tmp = String.valueOf(matches[i - j]) + String.valueOf(nums[j - 2]);
				matches[i] = Math.min(matches[i], Long.valueOf(tmp));
			}
		}
		for(int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			System.out.print(matches[n] + " ");
			String max = "1";
			if(n % 2 == 1) {
				max = "7";
			}
			int repeat = n / 2;
			for(int i = 1; i < repeat; i++) {
				max += "1";
			}
			System.out.println(max);
		}
	}
}

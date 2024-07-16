import java.util.Arrays;
import java.util.Scanner;

public class swea1945 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] primes = {2, 3, 5, 7, 11};
		int T = sc.nextInt();
		for(int tc = 1; tc <= T;  tc++) {
			int[] cnts = new int[5];
			int num = sc.nextInt();
			for(int i = 0; i < 5; i++) {
				while (true) {
					if (num % primes[i] != 0)
						break;
					num /= primes[i];
					cnts[i] += 1;
				}
			}
//			System.out.print("#" + tc);
//			for(int cnt : cnts) {
//				System.out.print(" " + cnt);
//			}
//			System.out.println();
			System.out.print("#" + tc + " " + Arrays.toString(cnts));
		}
	}
}

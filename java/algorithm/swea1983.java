import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class swea1983 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N, K, target = 0;
			N = sc.nextInt();
			K = sc.nextInt();
			int[] scores = new int[N];
			for(int i = 0; i < N; i++) {
				int tmp = 0;
				tmp += sc.nextInt() * 35;
				tmp += sc.nextInt() * 45;
				tmp += sc.nextInt() * 20;
				scores[i] = tmp;
				if(i+1 == K) {
					target = tmp;
				}
			}
			
			
			Arrays.sort(scores);
						
			int d = N / 10;
			for(int i = 0; i < N; i++) {
				if(scores[i] == target) {
					if(i < d) {
						System.out.println("#" + tc + " D0");
					}else if(i < 2 * d) {
						System.out.println("#" + tc + " C-");
					}else if(i < 3 * d) {
						System.out.println("#" + tc + " C0");
					}else if(i < 4 * d) {
						System.out.println("#" + tc + " C+");
					}else if(i < 5 * d) {
						System.out.println("#" + tc + " B-");
					}else if(i < 6 * d) {
						System.out.println("#" + tc + " B0");
					}else if(i < 7 * d) {
						System.out.println("#" + tc + " B+");
					}else if(i < 8 * d) {
						System.out.println("#" + tc + " A-");
					}else if(i < 9 * d) {
						System.out.println("#" + tc + " A0");
					}else {
						System.out.println("#" + tc + " A+");
					}
				}
			}
		}

	}

}

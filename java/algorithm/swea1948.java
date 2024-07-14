import java.util.Scanner;

public class swea1948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int tc = 1; tc <= T; tc++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			int answer = 1;
			for(int i = m1; i < m2; i++) {
				answer += months[i];
			}
			answer -= d1;
			answer += d2;
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}

import java.util.Scanner;

public class swea1984 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int total = 0;
			int minimum = Integer.MAX_VALUE;
			int maximum = Integer.MIN_VALUE;
			for(int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				total += num;
				minimum = Math.min(minimum, num);
				maximum = Math.max(maximum, num);
			}
			total -= minimum;
			total -= maximum;
			total = total / 8;
			int answer = (int)Math.round(total / 8.0);
//			int answer = (int) total;
//			if (0.5 <= total % 1) {
//				answer += 1;
//			}
//			String answer = String.format("%.0f", total);
			System.out.println("#" + tc + " " + answer);
		}

	}

}

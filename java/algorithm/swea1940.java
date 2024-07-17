import java.util.Scanner;

public class swea1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int speed = 0;
			int answer = 0;
			for(int i = 0; i < N; i++) {
				int gear = sc.nextInt();
				if (gear == 0) {
					answer += speed;
				} else if (gear == 1) {
					speed += sc.nextInt();
					answer += speed;
				} else if( gear == 2) {
					speed -= sc.nextInt();
					if(speed < 0)
						speed = 0;
					answer += speed;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}

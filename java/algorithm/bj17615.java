import java.util.Scanner;

public class bj17615 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] balls = sc.next().toCharArray();
		int cntr = 0;
		int cntb = 0;
		for(int i = 0; i < N; i++) {
			if(balls[i] == 'R')
				cntr++;
			else
				cntb++;
		}
		
		int answer = Math.min(cntr, cntb);
		
		char color = balls[0];
		int stay = 1;
		for(int i = 1; i < N; i++) {
			if(balls[i] != color)
				break;
			stay++;
		}
		if(color == 'R')
			answer = Math.min(answer, cntr - stay);
		else
			answer = Math.min(answer, cntb - stay);
		
		color = balls[N-1];
		stay = 1;
		for(int i = N - 2; 0 <= i; i--) {
			if(balls[i] != color)
				break;
			stay++;
		}
		if(color == 'R')
			answer = Math.min(answer, cntr - stay);
		else
			answer = Math.min(answer, cntb - stay);
		
		System.out.println(answer);
	}
}

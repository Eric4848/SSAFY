import java.util.Arrays;
import java.util.Scanner;

public class bj2138 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int answer = N+1;
		char[] start = sc.next().toCharArray();
		char[] end = sc.next().toCharArray();
		
		char[] off = Arrays.copyOf(start, N);
		int change = 0;
		for(int i = 1; i < N; i++) {
			if(off[i-1] != end[i-1]) {
				turn(off, i);
				change++;
			}
		}
		if(off[N-1] == end[N-1])
			answer = Math.min(answer, change);
		System.out.println(answer);
		
		char[] on = Arrays.copyOf(start, N);
		turn(on, 0);
		change = 1;
		for(int i = 1; i < N; i++) {
			if(on[i-1] != end[i-1]) {
				turn(on, i);
				change++;
			}
		}
		if(on[N-1] == end[N-1])
			answer = Math.min(answer, change);
		System.out.println(answer);

		if(answer == N+1)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	
	static void turn(char[] bulbs, int idx) {
		for(int i = -1; i <= 1; i++) {
			if(0 <= idx + i && idx + i < N) {
				if(bulbs[idx+i] == '1')
					bulbs[idx+i] = '0';
				else
					bulbs[idx+i] = '1';
			}
		}
	}
}

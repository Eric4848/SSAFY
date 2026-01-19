import java.util.Scanner;

public class BJ22251 {
	static int[][] changes = new int[][] {
		{0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
		{4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
		{3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
		{3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
		{4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
		{3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
		{2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
		{3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
		{1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
		{2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int P = sc.nextInt();
		int X = sc.nextInt();
		int answer = 0;
		for(int floor = 1; floor <= N; floor++) {
			if(floor == X) continue;
			
			int change = 0;
			int start = X;
			int end = floor;
			for(int i = 0; i < K; i++) {
				change += changes[start % 10][end % 10];
				start /= 10;
				end /= 10;
			}
			
			if(change <= P) answer++;
		}
		System.out.println(answer);
	}
}

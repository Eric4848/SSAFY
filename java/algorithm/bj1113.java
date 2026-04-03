import java.util.Scanner;

public class bj1113 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int N, M;
	static int[][] pools, waters;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		pools = new int[N][M];
		waters = new int[N][M];
		for(int r = 0; r < N; r++) {
			String str = sc.next();
			for(int c = 0; c < M; c++) {
				pools[r][c] = str.charAt(c) - '0';
				if(r == 0 || r == N-1 || c == 0 || c == M-1)
					waters[r][c] = pools[r][c];
				else
					waters[r][c] = 10;
			}
		}
		
		System.out.println(calc());
	}
	static int calc() {
		boolean done = false;
		while(!done) {
			done = true;
			for(int r = 1; r < N-1; r++) {
				for(int c = 1; c < M-1; c++) {
					int now = waters[r][c];
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						now = Math.min(now, Math.max(pools[nr][nc], waters[nr][nc]));
					}
					if(now < waters[r][c]) {
						waters[r][c] = now;
						done = false;
					}
				}
			}
		}
		
		int answer = 0;
		for(int r = 1; r < N-1; r++) {
			for(int c = 1; c < M-1; c++) {
				if(pools[r][c] < waters[r][c])
					answer += waters[r][c] - pools[r][c];
			}
		}
		return answer;
	}
}

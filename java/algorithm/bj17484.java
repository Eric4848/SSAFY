import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj17484 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] spaces = new int[N][M];
		int[] dc = {-1, 0, 1};
		int[][][] dp = new int[N][M][3];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				spaces[r][c] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[r][c], Integer.MAX_VALUE);
			}
		}
		
		for(int c = 0; c < M; c++) {
			for(int d = 0; d < 3; d++) {
				dp[0][c][d] = spaces[0][c];
			}
		}
		
		for(int r = 0; r < N-1; r++) {
			for(int c = 0; c < M; c++) {
				for(int d = 0; d < 3; d++) {
					if(dp[r][c][d] == Integer.MAX_VALUE) continue;
					for(int nd = 0; nd < 3; nd++) {
						if(d == nd) continue;
						int nc = c + dc[nd];
						if(nc == -1 || nc == M) continue;
						dp[r+1][nc][nd] = Math.min(dp[r+1][nc][nd], dp[r][c][d] + spaces[r+1][nc]);
					}
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int c = 0; c < M; c++) {
			for(int d = 0; d < 3; d++) {
				answer = Math.min(answer, dp[N-1][c][d]);
			}
		}
		
		System.out.println(answer);
	}
}

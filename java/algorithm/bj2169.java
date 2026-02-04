import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2169 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maps = new int[N][M];
		int[][] values = new int[N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				maps[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		values[0] = maps[0];
		for(int r = 1; r < N; r++) {
			Arrays.fill(values[r], Integer.MIN_VALUE);
		}
		for(int c = 1; c < M; c++) {
			values[0][c] += values[0][c-1];
		}
		for(int r = 1; r < N; r++) {
			for(int c = 0; c < M; c++) {
				values[r][c] = values[r-1][c] + maps[r][c];
			}
			for(int c = 0; c < M; c++) {
				int calc = values[r-1][c] + maps[r][c];
				int right = calc;
				int left = calc;
				for(int cr = c+1; cr < M; cr++) {
					right += maps[r][cr];
					values[r][cr] = Math.max(values[r][cr], right);
				}
				for(int cl = c-1; 0 <= cl; cl--) {
					left += maps[r][cl];
					values[r][cl] = Math.max(values[r][cl], left);
				}
			}
		}
		System.out.println(values[N-1][M-1]);
	}
}

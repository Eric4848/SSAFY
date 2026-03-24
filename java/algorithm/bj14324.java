import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14324 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int R, C;
	static int[][] grounds, rains;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			grounds = new int[R][C];
			rains = new int[R][C];
			for(int r = 0; r < R; r ++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < C; c++) {
					grounds[r][c] = Integer.parseInt(st.nextToken());
					if(r == 0 || r == R - 1 || c == 0 || c == C - 1) 
						rains[r][c] = grounds[r][c];
					else
						rains[r][c] = 1001;
				}
			}
			System.out.println("Case #" +tc + ": " + calc());
		}
	}
	static int calc() {
		boolean iscontinue = true;
		while(iscontinue) {
			iscontinue = false;
			for(int r = 1; r < R - 1; r++) {
				for(int c = 1; c < C - 1; c++) {
					int now = rains[r][c];
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						now = Math.min(now, Math.max(grounds[nr][nc], rains[nr][nc]));
					}
					if(now < rains[r][c]) {
						rains[r][c] = now;
						iscontinue = true;
					}
				}
			}
		}
		int total = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(grounds[r][c] < rains[r][c])
					total += rains[r][c] - grounds[r][c];
			}
		}
		return total;
	}
}

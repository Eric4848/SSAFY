import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1249 {
	static int answer;
	static int N;
	static int[] dr = {1, 0, 0, -1};
	static int[] dc = {0, 1, -1 ,0};
	static int[][] fields;
	static int[][] answers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			fields = new int[N][N];
			answers = new int [N][N];
			for(int r = 0; r < N; r++) {
				String[] nums = br.readLine().split("");
				for(int c = 0; c < N; c++) {
					fields[r][c] = Integer.parseInt(nums[c]);
					answers[r][c] = Integer.MAX_VALUE;
				}
			}
			dfs(0, 0, 0);
			System.out.println("#" + tc + " " + answers[N-1][N-1]);
		}
	}
	static void dfs(int r, int c, int cnt) {
		if (answers[r][c] < cnt)
			return;
		
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(0 <= nr && nr < N && 0 <= nc && nc < N && cnt + fields[nr][nc] < answers[nr][nc]) {
				answers[nr][nc] = cnt + fields[nr][nc];
				dfs(nr, nc, answers[nr][nc]);
			}
		}
	}
}


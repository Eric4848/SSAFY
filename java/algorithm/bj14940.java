import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14940 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = 0;
		int c = 0;
		int[][] maps = new int[n][m];
		int[][] answers = new int[n][m];
		Queue<int[]> q = new LinkedList<int[]>();
		for(r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for(c = 0; c < m; c++) {
				maps[r][c] = Integer.parseInt(st.nextToken());
				if(maps[r][c] == 2) {
					q.add(new int[] {r, c});
					answers[r][c] = 0;
				}
				else if(maps[r][c] == 1) {
					answers[r][c] = -1;
				}
			}
		}
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			r = curr[0];
			c = curr[1];
			int dist = answers[r][c];
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || n <= nr || nc < 0 || m <= nc)
					continue;
				else if(answers[nr][nc] == -1) {
					q.add(new int[] {nr, nc});
					answers[nr][nc] = dist + 1;
				}
			}
		}
		for(r = 0; r < n; r++) {
			for(c = 0; c < m; c++) {
				System.out.print(answers[r][c] + " ");
			}
			System.out.println();
		}
	}
}

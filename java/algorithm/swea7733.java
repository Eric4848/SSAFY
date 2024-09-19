import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea7733 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int N;
	static int[][] cheezes;
	static int ate;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cheezes = new int[N][N];
			int max = 0;
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					cheezes[r][c] = Integer.parseInt(st.nextToken());
					max = Math.max(max, cheezes[r][c]);
				}
			}
			int answer = 1;
			ate = 1;
			while(ate <= max) {
				visited = new boolean[N][N];
				int tmp = 0;
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						if(!visited[r][c] && cheezes[r][c] > ate) {
							tmp++;
							bfs(r, c);
						}
					}
				}
				answer = Math.max(answer, tmp);
				ate++;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r ,c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if(0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && cheezes[nr][nc] > ate) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
	}
}

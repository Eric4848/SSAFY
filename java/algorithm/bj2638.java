import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2638 {
	static int N, M, cheeze;
	static int[][] maps;
	static int[][] tmp;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheeze = 0;
		maps = new int[N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				maps[r][c] = Integer.parseInt(st.nextToken());
				if(maps[r][c] == 1) cheeze++;
			}
		}
		q = new LinkedList<int[]>();
		int answer = 0;
		while(0 < cheeze) {
			time();
			answer++;
		}
		System.out.println(answer);
	}
	
	static void time() {
		tmp = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		q.add(new int[] {0, 0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			visited[r][c] = true;
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr == -1 || nr == N || nc == -1 || nc == M) continue;
				tmp[nr][nc]++;
				if(maps[nr][nc] == 0 && !visited[nr][nc]) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(maps[r][c] == 1 && 1 < tmp[r][c]) {
					maps[r][c] = 0;
					cheeze--;
				}
			}
		}
	}
}

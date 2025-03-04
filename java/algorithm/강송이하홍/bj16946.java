package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16946 {
	static int N, M;
	static char[][] maps;
	static int[][] cnts;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maps = new char[N][M];
		cnts = new int[N][M];
		for(int r = 0; r < N; r++) {
			maps[r] = br.readLine().toCharArray();
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(maps[r][c] == '0' && cnts[r][c] == 0) {
					calc(r, c);
				}
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(maps[r][c] == '1') {
					int answer = 1;
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(nr < 0 || N <= nr || nc < 0 || M <= nc) continue;
						answer += cnts[nr][nc];
					}
					sb.append(answer);
				}
				else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void calc(int r, int c) {
		int cnt = 1;
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		List<int[]> tochange = new ArrayList<int[]>();
		q.add(new int[] {r, c});
		tochange.add(new int[] {r, c});
		visited[r][c] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if(nr < 0 || N <= nr || nc < 0 || M <= nc || visited[nr][nc] || maps[nr][nc] == '1') continue;
				q.add(new int[] {nr, nc});
				tochange.add(new int[] {nr, nc});
				visited[nr][nc] = true;
				cnt++;
			}
		}
		
		cnt %= 10;
		for(int[] nxt : tochange) {
			cnts[nxt[0]][nxt[1]] = cnt;
		}
	}
}

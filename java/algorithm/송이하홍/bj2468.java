package 송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2468 {
	static int N, answer;
	static int[][] fields;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		fields = new int [N][N];
		int maximum = 0;
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				fields[r][c] = Integer.parseInt(st.nextToken());
				maximum = Math.max(maximum, fields[r][c]);
			}
		}
		
		answer = 0;
		
		for(int h = 0; h < maximum; h++) {
			count(h);
		}
		
		System.out.println(answer);
	}
	
	static void count(int H) {
		boolean[][] visited = new boolean[N][N];
		int cnt = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!visited[r][c] && H < fields[r][c]) {
					cnt++;
					visited[r][c] = true;
					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] {r, c});
					while(!q.isEmpty()) {
						int[] loc = q.poll();
						for(int d = 0; d < 4; d++) {
							int nr = loc[0] + dr[d];
							int nc = loc[1] + dc[d];
							if(0 <= nr && nr < N && 0 <= nc && nc < N) {
								if(!visited[nr][nc] && H < fields[nr][nc]) {
									visited[nr][nc] = true;
									q.add(new int[] {nr, nc});
								}
							}
						}
					}
				}
			}
		}
		answer = Math.max(answer, cnt);
	}
}

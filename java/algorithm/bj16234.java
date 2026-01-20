import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16234 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int[][] populations;
	static int N, L, R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		populations = new int[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				populations[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		while(true) {
			if(!move()) break;
			answer++;
		}
		System.out.println(answer);
	}
	
	static boolean move() {
		boolean[][] moved = new boolean[N][N];
		boolean move = false;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!moved[r][c]) {
					Queue<int[]> q = new LinkedList<int[]>();
					List<int[]> list = new ArrayList<int[]>();
					moved[r][c] = true;
					int total = populations[r][c];
					q.add(new int[] {r, c});
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						list.add(curr);
						for(int d = 0; d < 4; d++) {
							int nr = curr[0] + dr[d];
							int nc = curr[1] + dc[d];
							if(nr == -1 || nr == N || nc == -1 || nc == N) continue;
							int diff = Math.abs(populations[curr[0]][curr[1]] - populations[nr][nc]);
							if(!moved[nr][nc] && L <= diff && diff <= R) {
								moved[nr][nc] = true;
								total += populations[nr][nc];
								q.add(new int[] {nr, nc});
							}
						}
					}
					int l = list.size();
					if(1 < l) move = true;
					int avg = total / l;
					for(int i = 0; i < l; i++) {
						int[] curr = list.get(i);
						populations[curr[0]][curr[1]] = avg;
					}
				}
			}
		}
		return move;
	}
}

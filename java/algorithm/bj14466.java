import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14466 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		boolean[][][][] roads = new boolean[N][N][N][N];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken())-1;
			int c1 = Integer.parseInt(st.nextToken())-1;
			int r2 = Integer.parseInt(st.nextToken())-1;
			int c2 = Integer.parseInt(st.nextToken())-1;
			roads[r1][c1][r2][c2] = true;
			roads[r2][c2][r1][c1] = true;
		}
		
		int[][] cows = new int[K][2];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken())-1;
			cows[i][1] = Integer.parseInt(st.nextToken())-1;
		}
		int round = 0;
		int able = 0;
		while(round < K) {
			boolean[][] visited = new boolean[N][N];
			visited[cows[round][0]][cows[round][1]] = true;
			boolean[] met = new boolean[K];
			met[round] = true;
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(cows[round]);
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				int r = curr[0];
				int c = curr[1];
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < 0 || N <= nr || nc < 0 || N <= nc || roads[r][c][nr][nc]) continue;
					if(visited[nr][nc]) continue;
					visited[nr][nc] = true;
					for(int i = 0; i < K; i++) {
						if(met[i]) continue;
						if(nr == cows[i][0] && nc == cows[i][1]) {
							able++;
							met[i] = true;
						}
					}
					q.add(new int[] {nr, nc});
				}
			}
			round++;
		}
		System.out.println((K * (K-1) - able) / 2);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2206 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] maps = new char[N][M];
		for(int r = 0; r < N; r++) {
			maps[r] = br.readLine().toCharArray();
		}
		
		int[][][] visits = new int[N][M][2];
		visits[0][0][0] = 1;
		Queue<int[]> locs = new LinkedList<int[]>();
		locs.add(new int[]{0, 0, 0});
		boolean arrived = false;
		while(!locs.isEmpty()) {
			int[] curr = locs.poll();
			int r = curr[0];
			int c = curr[1];
			int b = curr[2];
			if(r == N-1 && c == M-1) {
				arrived = true;
				System.out.println(visits[r][c][b]);
				break;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr == -1 || nr == N || nc == -1 || nc == M) continue;
				if(maps[nr][nc] == '0') {
					if(visits[nr][nc][b] == 0) {
						visits[nr][nc][b] = visits[r][c][b] + 1;
						locs.add(new int[] {nr, nc, b});
					}
				}
				else if(b == 0) {
					if(visits[nr][nc][1] == 0) {
						visits[nr][nc][1] = visits[r][c][0] + 1;
						locs.add(new int[] {nr, nc, 1});
					}
				}
			}
		}
		if(!arrived)
			System.out.println(-1);
	}
}

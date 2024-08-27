import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class swea1226 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		int N = 16;
		int er = 0;
		int ec = 0;
		for(int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			char[][] maze = new char[16][16];
			boolean[][] is_visit = new boolean[16][16];
			
			Deque<int[]> bfs = new ArrayDeque<>();
			for(int r = 0; r < N; r++) {
				String row = br.readLine();
				for(int c = 0; c < N; c++) {
					maze[r][c] = row.charAt(c);
					if(maze[r][c] == '2') {
						int[] start = {r, c};
						bfs.add(start);
						is_visit[r][c] = true;
					} else if (maze[r][c] == '3') {
						er = r;
						ec = c;
					}
				}
			}
			int answer = 0;
			while(!bfs.isEmpty()) {
				int[] loc = bfs.pollFirst();
				int r = loc[0];
				int c = loc[1];
				if(r == er && c == ec) {
					answer = 1;
					break;
				}
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(0 <= nr && nr < N && 0 <= nc && nc <N && !is_visit[nr][nc] && maze[nr][nc] != '1') {
						int[] nxt = {nr, nc};
						is_visit[nr][nc] = true;
						bfs.add(nxt);
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4179 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int R, C;
	static char[][] maps;
	static Queue<int[]> locs;
	static Queue<int[]> fires;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maps = new char[R][C];
		locs = new LinkedList<int[]>();
		fires = new LinkedList<int[]>();
		for(int r = 0; r < R; r++) {
			maps[r] = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				if(maps[r][c] == 'J') locs.add(new int[] {r, c});
				else if(maps[r][c] == 'F') fires.add(new int[] {r, c});
			}
		}
		int answer = 1;
		while(!locs.isEmpty()) {
			burn();
			boolean result = run();
			if(result) {
				System.out.println(answer);
				return;
			}
			answer++;
		}
		System.out.println("IMPOSSIBLE");
	}
	
	static void burn() {
		int l = fires.size();
		for(int i = 0; i < l; i++) {
			int[] curr = fires.poll();
			int r = curr[0];
			int c = curr[1];
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr == -1 || nr == R || nc == -1 || nc == C || maps[nr][nc] == 'F' || maps[nr][nc] == '#') continue;
				maps[nr][nc] = 'F';
				fires.add(new int[] {nr, nc});
			}
		}
	}
	
	static boolean run() {
		int l = locs.size();
		for(int i = 0; i < l; i++) {
			int[] curr = locs.poll();
			int r = curr[0];
			int c = curr[1];
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr == -1 || nr == R || nc == -1 || nc == C) return true;
				if(maps[nr][nc] == '.') {
					locs.add(new int[] {nr, nc});
					maps[nr][nc] = '#';
				}
			}
		}
		return false;
	}
}

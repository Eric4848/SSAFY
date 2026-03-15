import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3109 {
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	static int R, C, answer;
	static char[][] maps;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maps = new char[R][C];
		visited = new boolean[R][C];
		for(int r = 0; r < R; r++) {
			maps[r] = br.readLine().toCharArray();
		}
		
		answer = 0;
		for(int r = 0; r < R; r++) {
			if(maps[r][0] == 'x') continue;
			move(r, 0);
		}
		System.out.println(answer);
	}
	static boolean move(int r, int c) {
		if(c == C-1) {
			answer++;
			return true;
		}
		for(int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || R <= nr || nc < 0 || C <= nc) continue;
			if(visited[nr][nc] || maps[nr][nc] == 'x') continue;
			visited[nr][nc] = true;
			if(move(nr, nc)) {
				return true;
			}
//			visited[nr][nc] = false;
		}
		return false;
	}
}

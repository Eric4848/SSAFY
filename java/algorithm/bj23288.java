import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj23288 {
	static int[] horizonals = {4, 1, 3};
	static int[] verticals = {2, 1, 5, 6};
	// 동 남 서 북
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N, M;
	static int[][] maps;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		maps = new int[N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				maps[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int r = 0;
		int c = 0;
		int d = 0;
		int answer = 0;
		for(int i = 0; i < K; i++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || N <= nr || nc < 0 || M <= nc) d = (d + 2) % 4;
			r += dr[d];
			c += dc[d];
			switch (d) {
			case 0:
				right();
				break;
			case 1:
				down();
				break;
			case 2:
				left();
				break;
			case 3:
				up();
				break;
			default:
				break;
			}
			
			answer += calc(r, c);
			
			int A = verticals[3];
			int B = maps[r][c];
			if(A > B)
				d = (d + 1) % 4;
			else if(A < B)
				d = (d + 3) % 4;
		}
		System.out.println(answer);
	}
	static void right() {
		int tmp = verticals[3];
		verticals[3] = horizonals[2];
		horizonals[2] = horizonals[1];
		horizonals[1] = horizonals[0];
		horizonals[0] = tmp;
		verticals[1] = horizonals[1];
	}
	
	static void left() {
		int tmp = verticals[3];
		verticals[3] = horizonals[0];
		horizonals[0] = horizonals[1];
		horizonals[1] = horizonals[2];
		horizonals[2] = tmp;
		verticals[1] = horizonals[1];
	}
	
	static void up() {
		int tmp = verticals[0];
		for(int i = 0; i < 3; i++) {
			verticals[i] = verticals[i+1];
		}
		verticals[3] = tmp;
		horizonals[1] = verticals[1];
	}
	
	static void down() {
		int tmp = verticals[3];
		for(int i = 3; 0 < i; i--) {
			verticals[i] = verticals[i-1];
		}
		verticals[0] = tmp;
		horizonals[1] = verticals[1];
	}
	
	static int calc(int row, int col) {
		int num = maps[row][col];
		int result = 1;
		boolean[][] visited = new boolean[N][M];
		visited[row][col] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {row, col});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || N <= nr || nc < 0 || M <= nc) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				if(maps[nr][nc] == num) {
					result++;
					q.add(new int[] {nr, nc});
				}
			}
		}
		return result * num;
	}
}

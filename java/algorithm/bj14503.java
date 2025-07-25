import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14503 {
	static int N, M, r, c, d;
	static int[][] rooms;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		rooms = new int[N][M];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < M; col++) {
				rooms[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		bp: while(true) {
			if(rooms[r][c] == 0) {
				answer++;
				rooms[r][c] = -1;
			}
			boolean cleaned = true;
			for(int dir = 0; dir < 4; dir++) {
				if(rooms[r+dr[dir]][c+dc[dir]] == 0) {
					cleaned = false;
					break;
				}
			}
			if(cleaned) {
				int nd = (d + 2) % 4;
				r += dr[nd];
				c += dc[nd];
				if(rooms[r][c] == 1) {
					break bp;
				}
			}
			else {
				d = (d + 3) % 4;
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(rooms[nr][nc] == 0) {
					r = nr;
					c = nc;
				}
			}
		}
		System.out.println(answer);
	}
}

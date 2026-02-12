import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj4485 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			int[][] caves = new int[N][N];
			for(int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					caves[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] rupees = new int[N][N];
			for(int r = 0; r < N; r++)
				Arrays.fill(rupees[r], Integer.MAX_VALUE);
			rupees[0][0] = caves[0][0];
			PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {return a[2] - b[2];});
			q.add(new int[] {0, 0, caves[0][0]});
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				int r = curr[0];
				int c = curr[1];
				int rupee = curr[2];
				if(r == N-1 && c == N-1) {
					System.out.println("Problem " + tc + ": " + rupee);
					break;
				}
				if(rupees[r][c] < rupee) continue;
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < 0 || N <= nr || nc < 0 || N <= nc) continue;
					int nxt = rupee + caves[nr][nc];
					if(rupees[nr][nc] < nxt) continue;
					rupees[nr][nc] = nxt;
					q.add(new int[] {nr, nc, nxt});
				}
			}
			tc++;
		}
	}
}

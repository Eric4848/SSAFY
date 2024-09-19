import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1247 {
	static int N, answer;
	static int[] locx;
	static int[] locy;
	static int[][] dists;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N  = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			locx = new int[N+2];
			locy = new int[N+2];
			dists = new int[N+2][N+2];
			visited = new boolean[N];
			
			for(int i = 0; i < N+2; i++) {
				locx[i] = Integer.parseInt(st.nextToken());
				locy[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N+1; i++) {
				for(int j = i+1; j < N+2; j++) {
					dists[i][j] = dists[j][i] = Math.abs(locx[i] - locx[j]) + Math.abs(locy[i] - locy[j]);
				}
			}
			
			answer = Integer.MAX_VALUE;
			calc(0, 0, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	static void calc(int b, int d, int total) {
		if(answer < total) return;
		
		if(d == N) {
			total += dists[b][1];
			answer = Math.min(total, answer);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			calc(i+2, d+1, total+dists[b][i+2]);
			visited[i] = false;
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17182 {
	static int N, answer;
	static int[][] times;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		times = new int[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				times[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					times[i][j] = Math.min(times[i][j], times[i][k] + times[k][j]);
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		boolean[] visited = new boolean[N];
		visited[K] = true;
		dfs(K, 1, visited, 0);
		
		System.out.println(answer);
	}
	
	static void dfs(int curr, int cnt, boolean[] visited, int total) {
		if(answer <= total) return;
		
		if(cnt == N) {
			answer = Math.min(answer, total);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, cnt+1, visited, total + times[curr][i]);
				visited[i] = false;
			}
		}
	}
}

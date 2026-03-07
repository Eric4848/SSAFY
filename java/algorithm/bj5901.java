import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj5901 {
	static int N, M, K, answer;
	static int[] markets, orders;
	static boolean[] ismarket, visit;
	static int[][] dists;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		markets = new int[K];
		ismarket = new boolean[N];
		visit = new boolean[K];
		orders = new int[K];
		answer = Integer.MAX_VALUE;
		for(int i = 0; i < K; i++) {
			 int city = Integer.parseInt(br.readLine()) - 1;
			 ismarket[city] = true;
			 markets[i] = city;
		}
		
		dists = new int[N][N];
		for(int r = 0; r < N; r++) {
			Arrays.fill(dists[r], 10000);
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int dist = Integer.parseInt(st.nextToken());
			dists[a][b] = dist;
			dists[b][a] = dist;
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					if(dists[i][k] + dists[k][j] < dists[i][j]) {
						dists[i][j] = dists[i][k] + dists[k][j];
						dists[j][i] = dists[i][j];
					}
				}
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[1] - b[1];});
		for(int start = 0; start < N; start++) {
			pq.add(new int[] {start, 0});
			
			while(!pq.isEmpty()) {
				int[] curr = pq.poll();
				int loc = curr[0];
				int dist = curr[1];
				if(dists[start][loc] > dist) {
					dists[start][loc] = dist;
					for(int nxt = 0; nxt < N; nxt++) {
						if(dist + dists[loc][nxt] < dists[start][nxt]) {
							pq.add(new int[] {nxt, dist + dists[loc][nxt]});
						}
					}
				}
			}
		}
		
		dfs(0);
		
		System.out.println(answer);
	}
	
	static void dfs(int d) {
		if(d == K) {
			calc();
		}
		
		for(int i = 0; i < K; i++) {
			if(!visit[i]) {
				visit[i] = true;
				orders[d] = i;
				dfs(d + 1);
				visit[i] = false;
			}
		}
	}
	
	static void calc() {
		int total = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			if(ismarket[i]) continue;
			total = Math.min(total, dists[i][orders[0]] + dists[i][orders[K-1]]);
		}
		
		for(int i = 1; i < K; i++) {
			total += dists[orders[i-1]][orders[i]];
		}
		
		answer = Math.min(answer, total);
	}
}

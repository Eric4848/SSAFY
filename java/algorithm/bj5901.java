import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj5901 {
	static int N, M, K, answer;
	static int[] markets, orders;
	static boolean[] ismarket, visit;
	static int[][] dists;
	static ArrayList<int[]>[] graphs;
	
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
		
		dists = new int[K][N];
		graphs = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			graphs[i] = new ArrayList<int[]>();
		}
		
//		for(int r = 0; r < N; r++) {
//			Arrays.fill(dists[r], 10000);
//		}
//		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int dist = Integer.parseInt(st.nextToken());

			graphs[a].add(new int[] {b, dist});
			graphs[b].add(new int[] {a, dist});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[1] - b[1];});
		for(int i = 0; i < K; i++) {
			int start = markets[i];
			Arrays.fill(dists[i], Integer.MAX_VALUE);
			pq.add(new int[] {start, 0});
			dists[i][start] = 0;
			
			while(!pq.isEmpty()) {
				int[] curr = pq.poll();
				int loc = curr[0];
				int dist = curr[1];
				if(dists[i][loc] < dist) continue;
				for(int[] nxts : graphs[loc]) {
					int nxt = nxts[0];
					int nxtdist = dist + nxts[1];
					if(nxtdist < dists[i][nxt]) {
						dists[i][nxt] = nxtdist;
						pq.add(new int[] {nxt, nxtdist});
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
			return;
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
			total = Math.min(total, dists[orders[0]][i] + dists[orders[K-1]][i]);
		}
		
		for(int i = 1; i < K; i++) {
			total += dists[orders[i-1]][markets[orders[i]]];
		}
		
		answer = Math.min(answer, total);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[][] roads = new int[N+1][N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			roads[A][B] = T;
		}
		int[] gos = new int[N+1];
		int[] backs = new int[N+1];
		Arrays.fill(gos, Integer.MAX_VALUE);
		Arrays.fill(backs, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[1] - b[1];});
		pq.add(new int[] {X, 0});
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			for(int nxt = 1; nxt <= N; nxt++) {
				if(roads[curr[0]][nxt] == 0) continue;
				int nxtTime = curr[1] + roads[curr[0]][nxt];
				if(nxtTime < gos[nxt]) {
					pq.add(new int[] {nxt, nxtTime});
					gos[nxt] = nxtTime;
				}
			}
		}
		
		pq.add(new int[] {X, 0});
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			for(int nxt = 1; nxt <= N; nxt++) {
				if(roads[nxt][curr[0]] == 0) continue;
				int nxtTime = curr[1] + roads[nxt][curr[0]];
				if(nxtTime < backs[nxt]) {
					pq.add(new int[] {nxt, nxtTime});
					backs[nxt] = nxtTime;
				}
			}
		}
		gos[X] = 0;
		backs[X] = 0;
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			answer = Math.max(answer, gos[i] + backs[i]);
		}
		System.out.println(answer);
	}
}

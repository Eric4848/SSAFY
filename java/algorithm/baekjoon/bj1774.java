package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1774 {
	static class link implements Comparable<link>{
		int now;
		Double total;
		
		public link(int now, Double total) {
			this.now = now;
			this.total = total;
		}
		
		@Override
		public int compareTo(link o) {
			return Double.compare(this.total, o.total);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] locs = new int[N+1][2];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			locs[i][0] = Integer.parseInt(st.nextToken());
			locs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Double[][] dists = new Double[N+1][N+1];
		
		for(int a = 1; a < N; a++) {
			for(int b = a + 1; b <= N; b++) {
				Double dist = (Double) Math.sqrt(Math.pow(locs[a][0] - locs[b][0], 2) + Math.pow(locs[a][1] - locs[b][1], 2));
				dists[a][b] = dist;
				dists[b][a] = dist;
			}
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dists[a][b] = 0.0;
			dists[b][a] = 0.0;
		}
		
		boolean[] visited = new boolean[N+1];
		visited[0] = true;
		Double answer = 0.0;
		PriorityQueue<link> pq = new PriorityQueue<>();
		pq.add(new link(1, 0.0));
		while(!pq.isEmpty()) {
			link curr = pq.poll();
			if(visited[curr.now]) continue;
			visited[curr.now] = true;
			answer += curr.total;
			for(int nxt = 1; nxt <= N; nxt++) {
				if(visited[nxt]) continue;
				pq.add(new link(nxt, dists[curr.now][nxt]));
			}
		}
		
		System.out.println(String.format("%.2f", answer));
	}
}

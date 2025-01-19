package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1647 {
	static int N;
	static int M;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return a[2] - b[2];});
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new int[] {a, b, c});
		}
		
		int cnt = 0;
		int answer = 0;
		while(cnt < N-2) {
			int[] edge = pq.poll();
			if(find(edge[0]) == find(edge[1])) continue;
			answer += edge[2];
			union(edge[0], edge[1]);
			cnt++;
		}
		System.out.println(answer);
	}
	
	static int find(int n) {
		if(parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa < pb)
			parents[pb] = pa;
		else
			parents[pa] = pb;
	}
}

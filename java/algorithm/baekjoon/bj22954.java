package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj22954 {
	static List<int[]>[] edges;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		edges = new LinkedList[N+1];
		parents = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			edges[i] = new LinkedList<int[]>();
			parents[i] = i;
		}
			
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a].add(new int[] {b, i+1});
			edges[b].add(new int[] {a, i+1});
		}
		
		int[] nodes;
		int[] graphs;
		for(int i = 1; i <= N; i++) {
			nodes = new int[N];
			graphs = new int[N-1];
			boolean[] visited = new boolean[N+1];
			int idx = 0;
			nodes[0] = i;
			visited[i] = true;
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(1);
			while(!q.isEmpty()) {
				int curr = q.poll();
				for(int[] edge : edges[curr]) {
//					System.out.println(edge[0] + ", " + edge[1]);
					if(visited[edge[0]]) continue;
					if(find(curr) != find(edge[0])) {
						graphs[idx++] = edge[1];
						nodes[idx] = edge[0];
						visited[edge[0]] = true;
						q.add(edge[0]);
						if(curr == 1)
							break;
					}
				}
			}
			if(nodes[N-1] != 0) {
				System.out.println(N-1 + " " + 1);
				for(int j = 1; j < N; j++) {
					System.out.print(nodes[j] + " ");
				}
				System.out.println();
				for(int j = 1; j < N-1; j++) {
					System.out.print(graphs[j] + " ");
				}
				System.out.println();
				System.out.println(nodes[0]);
				System.out.println();
				break;
			}
		}
	}
	
	static int find(int n) {
		if(n == parents[n]) return n;
		return parents[n] = find(parents[n]);
	}
	
	static void union(int a, int b) {
		if(find(a) < find(b))
			parents[b] = find(a);
		else
			parents[a] = find(b);
	}
}

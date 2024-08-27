import java.util.*;
import java.io.*;


class swea1248
{
    static int[] parents;
	static int[] depth;
	static List<Integer>[] graph;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			parents = new int[V+1];
			depth = new int[V+1];
			graph = new ArrayList[V+1];
			for(int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
				parents[i] = i;
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graph[s].add(e);
				parents[e] = s;
			}
			
			Queue<Integer> nodes = new LinkedList<>();
			nodes.add(1);
			while(!nodes.isEmpty()) {
				int now = nodes.poll();
				for(int nxt : graph[now]) {
					nodes.add(nxt);
					depth[nxt] = depth[now] + 1;
				}
			}
			
			while(depth[A] != depth[B]) {
				if (depth[A] < depth[B]) 
					B = parents[B];
				else
					A = parents[A];
			}
			
			while(parents[A] != parents[B]) {
				A = parents[A];
				B = parents[B];
			}
			
			nodes = new LinkedList<>();
			nodes.add(parents[A]);
			int answer = 0;
			while(!nodes.isEmpty()) {
				int now = nodes.poll();
				answer += 1;
				for(int nxt : graph[now]) {
					nodes.add(nxt);
				}
			}
			System.out.println("#" + tc + " " + parents[A] + " " + answer);
		}
	}
}
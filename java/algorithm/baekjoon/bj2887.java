package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj2887 {
	static class loc {
		int idx, x, y, z;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		loc[] locs = new loc[N+1];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			loc curr = new loc();
			curr.idx = i;
			curr.x = Integer.parseInt(st.nextToken());
			curr.y = Integer.parseInt(st.nextToken());
			curr.z = Integer.parseInt(st.nextToken());
			locs[i] = curr;
		}
		
		ArrayList<int[]>[] edges = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<int[]>();
		}
		
		loc[] sort = new loc[N];
		for(int i = 0; i < N; i++) {
			sort[i] = locs[i+1];
		}
		
		Arrays.sort(sort, (a, b) -> a.x - b.x);
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(sort[i].x - sort[i + 1].x);
            int a = sort[i].idx;
            int b = sort[i + 1].idx;
            edges[a].add(new int[] {b, cost});
            edges[b].add(new int[] {a, cost});
        }
        
        Arrays.sort(sort, (a, b) -> a.y - b.y);
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(sort[i].y - sort[i + 1].y);
            int a = sort[i].idx;
            int b = sort[i + 1].idx;
            edges[a].add(new int[] {b, cost});
            edges[b].add(new int[] {a, cost});
        }
        
        Arrays.sort(sort, (a, b) -> a.z - b.z);
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(sort[i].z - sort[i + 1].z);
            int a = sort[i].idx;
            int b = sort[i + 1].idx;
            edges[a].add(new int[] {b, cost});
            edges[b].add(new int[] {a, cost});
        }
		
		boolean[] visited = new boolean[N+1];
		int answer = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[1] - b[1];});
		pq.add(new int[] {1, 0});
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			if(visited[curr[0]]) continue;
			visited[curr[0]] = true;
			answer += curr[1];
			for(int[] edge : edges[curr[0]]) {
				if(visited[edge[0]]) continue;
				pq.add(new int[] {edge[0], edge[1]});
			}
		}
		System.out.println(answer);
	}
}

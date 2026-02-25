import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj10021 {
	static int N;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] locs = new int[N][2];
		parents = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			locs[i][0] = Integer.parseInt(st.nextToken());
			locs[i][1] = Integer.parseInt(st.nextToken());
			parents[i] = i;
		}

		PriorityQueue<int[]> dists = new PriorityQueue<int[]>((a, b) -> {return a[0] - b[0];});
		for(int i = 0; i < N - 1; i++) {
			for(int j = i+1; j < N; j++) {
				int dist = (int) (Math.pow(Math.abs(locs[i][0] - locs[j][0]), 2) + Math.pow(Math.abs(locs[i][1] - locs[j][1]), 2));
				if(dist < C) continue;
				dists.add(new int[] {dist, i, j});
			}
		}
		int answer = 0;
		int connected = 1;
		while(!dists.isEmpty()) {
			if(connected == N) break;
			int[] curr = dists.poll();
			if(find(curr[1]) == find(curr[2])) continue;
			union(curr[1], curr[2]);
			answer += curr[0];
			connected++;
		}
		
		if(connected == N)
			System.out.println(answer);
		else
			System.out.println(-1);
	}
	
	static int find(int n) {
		int parent = parents[n];
		if(parent != n) return parents[n] = find(parent);
		return parent;
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

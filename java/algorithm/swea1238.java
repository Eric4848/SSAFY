import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class swea1238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			boolean[] is_visit = new boolean[101];
			Set<Integer>[] graphs = new HashSet[101];
			for(int i = 0; i <= 100; i++) {
				graphs[i] = new HashSet<Integer>();
			}
			
			Deque<int[]> bfs = new ArrayDeque<int[]>();
			int L = Integer.parseInt(st.nextToken());
			int[] conds = {Integer.parseInt(st.nextToken()), 0};
			bfs.add(conds);
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < L / 2; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graphs[s].add(e);
			}
			
			int answer = 0;
			int depth = 0;
			while(!bfs.isEmpty()) {
				int[] nows = bfs.pollFirst();
				int now = nows[0];
				int d = nows[1];
				is_visit[now] = true;
				if(depth < d) {
					depth = d;
					answer = now;
				} else if(depth == d) {
					answer = Math.max(answer, now);
				}
				
				for(int nxt : graphs[now]) {
					if(!is_visit[nxt]) {
						int[] nxts = {nxt, d+1};
						bfs.add(nxts);
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}

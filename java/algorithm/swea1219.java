import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class swea1219 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int T = 1; T <= 10; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] graphs = new int[100][2];
			boolean[] is_visit = new boolean[100];
			is_visit[0] = true;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < L; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				if(graphs[s][0] == 0)
					graphs[s][0] = e;
				else
					graphs[s][1] = e;
			}
			
			Deque<Integer> bfs = new ArrayDeque<>();
			for(int nxt : graphs[0]) {
				bfs.add(nxt);
			}
			
			int answer = 0;
			while(!bfs.isEmpty()) {
				int now = bfs.pollFirst();
				if(now == 99) {
					answer = 1;
					break;
				}
				for(int nxt : graphs[now]) {
					if(!is_visit[nxt]) {
						is_visit[nxt] = true;
						bfs.add(nxt);
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
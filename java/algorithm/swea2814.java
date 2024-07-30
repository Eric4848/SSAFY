import java.util.*;
import java.io.*;

public class swea2814 {
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer stz = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stz.nextToken());
			int M = Integer.parseInt(stz.nextToken());
			ArrayList<Integer>[] list = new ArrayList[N+1];
			for(int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list[x].add(y);
				list[y].add(x);
			}
			answer = 0;
			for(int i = 1; i <= N; i++) {
				boolean[] is_visit = new boolean[N+1];
				is_visit[i] = true;
				dfs(i, is_visit, 1, list);
				is_visit[i] = false;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	static void dfs(int now, boolean[] is_visit, int d, ArrayList<Integer>[] list) {
		if(!list[now].isEmpty()) {
			for(int nxt : list[now]) {
				if(!is_visit[nxt]) {
					is_visit[nxt] = true;
					dfs(nxt, is_visit, d+1, list);
					is_visit[nxt] = false;
				}
			}
		}
		answer = Math.max(answer, d);
	}
}

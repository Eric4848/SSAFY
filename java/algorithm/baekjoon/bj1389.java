package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1389 {
	static boolean[][] relations;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		relations = new boolean[N+1][N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			relations[a][b] = true;
			relations[b][a] = true;
		}
		int answer = 0;
		int cnt = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			int res = bfs(i);
			if(res < cnt) {
				cnt = res;
				answer = i;
			}
		}
		System.out.println(answer);
	}
	
	static int bfs(int n) {
		int[] cnts = new int[N+1];
		boolean[] visited = new boolean[N+1];
		visited[n] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int nxt = 1; nxt <= N; nxt++) {
				if(!visited[nxt] && relations[curr][nxt]) {
					cnts[nxt] = cnts[curr] + 1;
					visited[nxt] = true;
					q.add(nxt);
				}
			}
		}
		int cnt = 0;
		for(int i = 1; i <= N; i++)
			cnt += cnts[i];
		return cnt;
	}
}

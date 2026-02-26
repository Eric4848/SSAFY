import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17780 {
	static int N, K;
	static int[][] maps;
	static Queue<Integer>[][] chess;
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		maps = new int[N][N];
		chess = new LinkedList[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				maps[r][c] = Integer.parseInt(st.nextToken());
				chess[r][c] = new LinkedList<Integer>();
			}
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			q.add(new int[] {r, c, d});
			chess[r][c].add(i);
		}
		
		int answer = 1;
		while(answer <= 1000) {
			for(int i = 0; i < K; i++) {
				int[] curr = q.poll();
				int r = curr[0];
				int c = curr[1];
				int d = curr[2];
				int result = -1;
				if(chess[r][c].isEmpty() || chess[r][c].peek() != i) {
					q.add(curr);
					continue;
				}
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || N <= nr || nc < 0 || N <= nc || maps[nr][nc] == 2) {
					if(d % 2 == 1)
						d++;
					else
						d--;
					nr = r + dr[d];
					nc = c + dc[d];
					if(nr < 0 || N <= nr || nc < 0 || N <= nc || maps[nr][nc] == 2) {
						q.add(new int[] {nr, nc, d});
						continue;
					}
				}
				
				result = move(r, c, nr, nc);
				if(4 <= result) {
					System.out.println(answer);
					return;
				}
				
				q.add(new int[] {nr, nc, d});
			}
			answer++;
		}
		
		System.out.println(-1);
	}
	
	static int move(int fr, int fc, int tr, int tc) {
		if(maps[tr][tc] == 1) {
			Stack<Integer> tmp = new Stack<>();
			while(!chess[fr][fc].isEmpty()) {
				tmp.add(chess[fr][fc].poll());
			}
			while(!tmp.isEmpty()) {
				chess[fr][fc].add(tmp.pop());
			}
		}
		
		while(!chess[fr][fc].isEmpty()) {
			chess[tr][tc].add(chess[fr][fc].poll());
		}
		
		return chess[tr][tc].size();
	}
}

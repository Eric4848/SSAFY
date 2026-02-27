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
	static int[][] pieces;
	static Queue<Integer>[][] chess;
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		maps = new int[N][N];
		pieces = new int[K][3];
		chess = new LinkedList[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				maps[r][c] = Integer.parseInt(st.nextToken());
				chess[r][c] = new LinkedList<Integer>();
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			chess[r][c].add(i);
			pieces[i][0] = r;
			pieces[i][1] = c;
			pieces[i][2] = d;
		}
		
		int answer = 1;
		while(answer <= 1000) {
			for(int i = 0; i < K; i++) {
				int[] curr = pieces[i];
				int r = curr[0];
				int c = curr[1];
				int d = curr[2];
				int result = -1;
				if(chess[r][c].isEmpty() || chess[r][c].peek() != i) {
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
					pieces[i][2] = d;
					if(nr < 0 || N <= nr || nc < 0 || N <= nc || maps[nr][nc] == 2) {
						continue;
					}
				}
				
				result = move(r, c, nr, nc);
				if(4 <= result) {
					System.out.println(answer);
					return;
				}
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
			int piece = chess[fr][fc].poll();
			chess[tr][tc].add(piece);
			pieces[piece][0] = tr;
			pieces[piece][1] = tc;
		}
		
		return chess[tr][tc].size();
	}
}

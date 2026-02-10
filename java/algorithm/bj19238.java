import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj19238 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int N, M, fuel;
	static int[][] maps;
	static int[][] passengers;
	static int[][] destinations;
	static boolean[] done;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		maps = new int[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				maps[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		passengers = new int[N][N];
		destinations = new int[M+1][2];
		done = new boolean[M];
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int rs = Integer.parseInt(st.nextToken())-1;
			int cs = Integer.parseInt(st.nextToken())-1;
			int rd = Integer.parseInt(st.nextToken())-1;
			int cd = Integer.parseInt(st.nextToken())-1;
			passengers[rs][cs] = i;
			destinations[i][0] = rd;
			destinations[i][1] = cd;
		}
		
		int moved = 0;
		while(moved < M) {
			int[] next = search(r, c);
			if(next[0] == -1) break;
			fuel -= next[2];
			if(fuel < 0) break;
			int arrived[] = drive(next[0], next[1]);
			if(arrived[0] == -1) break;
			fuel -= arrived[2];
			if(fuel < 0) break;
			r = arrived[0];
			c = arrived[1];
			fuel += arrived[2] * 2;
			moved++;
		}
		
		if(moved == M)
			System.out.println(fuel);
		else
			System.out.println(-1);
	}
	
	static int [] search(int sr, int sc) {
		int[] result = new int[3];
		result[0] = -1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sr, sc});
		boolean[][] visited = new boolean[N][N];
		visited[sr][sc] = true;
		int dist = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			int rb = N;
			int cb = N;
			for(int i = 0; i < size; i++) {
				int[] curr = q.poll();
				int r = curr[0];
				int c = curr[1];
				if(0 < passengers[r][c]) {
					if(r < rb || (r == rb) && c < cb) {
						rb = r;
						cb = c;
					}
				}
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < 0 || N <= nr || nc < 0 || N <= nc) continue;
					if(visited[nr][nc]) continue;
					if(maps[nr][nc] == 1) continue;
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
			
			if(rb != N)
				return new int[] {rb, cb, dist};
			
			dist++;
		}
		return result;
	}
	
	static int [] drive(int sr, int sc) {
		int[] result = new int[3];
		result[0] = -1;
		int pn = passengers[sr][sc];
		passengers[sr][sc] = 0;
		int rd = destinations[pn][0];
		int cd = destinations[pn][1];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sr, sc, 0});
		boolean[][] visited = new boolean[N][N];
		visited[sr][sc] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			if(r == rd && c == cd) {
				return curr;
			}
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || N <= nr || nc < 0 || N <= nc) continue;
				if(visited[nr][nc]) continue;
				if(maps[nr][nc] == 1) continue;
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc, curr[2] + 1});
			}
		}
		return result;
	}
}

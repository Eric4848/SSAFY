import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1953 {
	static class Pipe {
		int r, c, s;
		Pipe(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	static int[][] maps;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M;
	static Queue<Pipe> q;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			maps = new int[N][M];
			visited = new boolean[N][M];
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < M; c++) {
					maps[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			q = new LinkedList<>();
			q.add(new Pipe(R, C, maps[R][C]));
			visited[R][C] = true;
			answer = 1;
			for(int i = 1; i < L; i++) {
				int size = q.size();
				for(int j = 0; j < size; j++) {
					Pipe now = q.poll();
					int nr;
					int nc;
					switch (now.s) {
						case(1): {
							searchTop(now);
							searchBottom(now);
							searchLeft(now);
							searchRight(now);
							break;
						}
						case(2): {
							searchTop(now);
							searchBottom(now);
							break;
						} 
						case(3): {
							searchLeft(now);
							searchRight(now);
							break;
						}
						case(4): {
							searchTop(now);
							searchRight(now);
							break;
						}
						case(5): {
							searchBottom(now);
							searchRight(now);
							break;
						}
						case(6): {
							searchBottom(now);
							searchLeft(now);
							break;
						}
						case(7): {
							searchTop(now);
							searchLeft(now);
						}
					}
//					System.out.println(i);
//					System.out.println(answer);
//					System.out.println("0000");
				}
			}
			System.out.println(answer);
			System.out.println("--------------");
		}
	}
	
	static void searchTop(Pipe now) {
		int nr = now.r + dr[0];
		int nc = now.c + dc[0];
		if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
			if(maps[nr][nc] == 1 || maps[nr][nc] == 2 || maps[nr][nc] == 5 || maps[nr][nc] == 6) {
				visited[nr][nc] =  true;
				q.add(new Pipe(nr, nc, maps[nr][nc]));
				answer++;
			}
		}
	}
	static void searchBottom(Pipe now) {
		int nr = now.r + dr[1];
		int nc = now.c + dc[1];
		if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
			if(maps[nr][nc] == 1 || maps[nr][nc] == 2 || maps[nr][nc] == 4 || maps[nr][nc] == 7) {
				visited[nr][nc] =  true;
				q.add(new Pipe(nr, nc, maps[nr][nc]));
				answer++;
			}
		}
	}
	static void searchLeft(Pipe now) {
		int nr = now.r + dr[2];
		int nc = now.c + dc[2];
		if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
			if(maps[nr][nc] == 1 || maps[nr][nc] == 3 || maps[nr][nc] == 4 || maps[nr][nc] == 5) {
				visited[nr][nc] =  true;
				q.add(new Pipe(nr, nc, maps[nr][nc]));
				answer++;
			}
		}
	}
	static void searchRight(Pipe now) {
		int nr = now.r + dr[3];
		int nc = now.c + dc[3];
		if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
			if(maps[nr][nc] == 1 || maps[nr][nc] == 3 || maps[nr][nc] == 6 || maps[nr][nc] == 7) {
				visited[nr][nc] =  true;
				q.add(new Pipe(nr, nc, maps[nr][nc]));
				answer++;
			}
		}
	}
}

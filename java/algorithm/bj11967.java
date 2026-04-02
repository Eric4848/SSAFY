import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11967 {
	static int N, M, answer;
	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, 1, -1};
	static int[][] lights;
	static boolean[][] maps;
	static Queue<Integer>[][] switches;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maps = new boolean[N][N];
		maps[0][0] = true;
		switches = new LinkedList[N][N];
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				switches[x][y] = new LinkedList<>();
			}
		}
		lights = new int[M][2];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			switches[x][y].add(i);
			lights[i][0] = a;
			lights[i][1] = b;
		}
		boolean movable = true;
		while(movable) {
			movable = move();
		}
		answer = 0;
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				if(maps[x][y]) answer++;
			}
		}
		System.out.println(answer);
	}
	static boolean move() {
		boolean movable = false;
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0, 0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			
			while(!switches[x][y].isEmpty()) {
				int n = switches[x][y].poll();
				maps[lights[n][0]][lights[n][1]] = true;
				movable = true;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx == -1 || nx == N || ny == -1 || ny == N || !maps[nx][ny] || visited[nx][ny]) continue;
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
		return movable;
	}
}

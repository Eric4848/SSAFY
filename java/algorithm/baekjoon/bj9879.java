import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9879 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int M, N, target;
	static int[] starts;
	static int[][] elevations;
	static boolean[][] waypoints;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		target = 0;
		elevations = new int[M][N];
		waypoints = new boolean[M][N];
		starts = new int[2];
		starts[0] = 0;
		starts[1] = 0;
		int min = 0;
		int max = 0;
		for(int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				int elevation = Integer.parseInt(st.nextToken());
				elevations[r][c] = elevation;
				max = Math.max(max, elevation);
			}
		}
		
		for(int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				int waypoint = Integer.parseInt(st.nextToken());
				if(waypoint == 1) {
					waypoints[r][c] = true;
					target++;
					starts[0] = r;
					starts[1] = c;
				}
			}
		}
		
		while(min < max) {
			int mid = (min + max) / 2;
			if(calc(mid))
				max = mid;
			else
				min = mid + 1;
		}
		
		System.out.println(max);
	}
	
	static boolean calc(int D) {
		boolean[][] visited = new boolean[M][N];
		int sr = starts[0];
		int sc = starts[1];
		visited[sr][sc] = true;
		int visit = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sr, sc});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			if(waypoints[r][c]) visit++;
			int h = elevations[r][c];
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || M <= nr || nc < 0 || N <= nc) continue;
				if(visited[nr][nc] || D < Math.abs(h - elevations[nr][nc])) continue;
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		return visit == target;
	}
}

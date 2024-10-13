import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1798 {
	static class spot{
		char id;
		int time;
		int fun;
	}
	
	static int N, M;
	static int[][] dists;
	static spot[] spots;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dists = new int[N+1][N+1];
			for(int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = i+1; j <= N; j++) {
					dists[i][j] = dists[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			spots = new spot[N+1];
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				spot now = new spot();
				char id = st.nextToken().charAt(0);
				now.id = id;
				if(id == 'P') {
					int time = Integer.parseInt(st.nextToken());
					int fun = Integer.parseInt(st.nextToken());
				}
				spots[i] = now;
			}
			visited = new boolean[N+1];
			
			
			System.out.println("answer");
		}
	}
	
	static void plan(int day, int time) {
		
	}
	
}

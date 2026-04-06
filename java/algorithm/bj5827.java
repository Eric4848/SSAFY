import java.util.Scanner;

public class bj5827 {
	static int N, M, answer;
	static int[] dc = {1, -1};
	static char[][] maps;
	static int[][][] fliped;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = 0, C = 0;
		maps = new char[N][M];
		fliped = new int[N][M][3];
		for(int r = 0; r < N; r++) {
			maps[r] = sc.next().toCharArray();
			for(int c = 0; c < M; c++) {
				fliped[r][c][0] = Integer.MAX_VALUE;
				fliped[r][c][2] = Integer.MAX_VALUE;
				if(maps[r][c] == 'C') {
					R = r;
					C = c;
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		move(R, C, 1, 0);
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	static void move(int r, int c, int g, int f) {
		for(int l = 0; l < N; l++) {
			int nr = r + g * l;
			if(nr == -1 || nr == N) return;
			if(maps[nr][c] == 'D') {
				answer = Math.min(answer, f);
				return;
			}
			if(maps[nr][c] == '#') {
				r = nr - g;
				break;
			}
		}
		
		
		for(int d = 0; d < 2; d++) {
			int nc = c + dc[d];
			if(nc == -1 || nc == M || maps[r][nc] == '#' || fliped[r][nc][g+1] <= f) continue;
			fliped[r][nc][g+1] = f;
			move(r, nc, g, f);
		}
		
		int ng = g* -1;
		if(f < fliped[r][c][ng+1]) {
			fliped[r][c][ng+1] = f+1;
			move(r, c, ng, f+1);
		}
	}
}
//	static int N, M, answer;
//	static int[] dc = {1, -1};
//	static char[][] maps;
//	static boolean[][][] visited;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		M = sc.nextInt();
//		int R = 0, C = 0;
//		maps = new char[N][M];
//		visited = new boolean[N][M][3];
//		for(int r = 0; r < N; r++) {
//			maps[r] = sc.next().toCharArray();
//			for(int c = 0; c < M; c++) {
//				if(maps[r][c] == 'C') {
//					R = r;
//					C = c;
//				}
//			}
//		}
//		
//		answer = Integer.MAX_VALUE;
//		move(R, C, 1, 0);
//		if(answer == Integer.MAX_VALUE)
//			System.out.println(-1);
//		else
//			System.out.println(answer);
//	}
//	static void move(int r, int c, int g, int f) {
//		for(int l = 0; l < N; l++) {
//			int nr = r + g * l;
//			if(nr == -1 || nr == N) return;
//			if(maps[nr][c] == 'D') {
//				answer = Math.min(answer, f);
//				return;
//			}
//			if(maps[nr][c] == '#') {
//				r = nr - g;
//				break;
//			}
//		}
//		
//		
//		for(int d = 0; d < 2; d++) {
//			int nc = c + dc[d];
//			if(nc == -1 || nc == M || maps[r][nc] == '#' || visited[r][nc][g+1]) continue;
//			visited[r][nc][g+1] = true;
//			move(r, nc, g, f);
//			visited[r][nc][g+1] = false;
//		}
//		
//		int ng = g* -1;
//		if(!visited[r][c][ng+1]) {
//			visited[r][c][ng+1] = true;
//			move(r, c, ng, f+1);
//			visited[r][c][ng+1] = false;
//		}
//	}
//}

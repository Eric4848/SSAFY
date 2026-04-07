import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj14529 {
	static int N;
	static char[][] images;
	static boolean[][][][] plc;
	static int dr[] = {1, -1, 0, 0};
	static int dc[] = {0, 0, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		images = new char[N][N];
		plc = new boolean[N][N][N][N];
		for(int r = 0; r < N; r++) {
			images[r] = sc.next().toCharArray();
		}
		
		int answer = 0;
		for(int l1 = N - 1; 0 <= l1; l1--) {
			for(int l2 = N - 1; 0 <= l2; l2--) {
				for(int r1 = 0; r1 + l1 < N; r1++) {
					for(int c1 = 0; c1 + l2 < N; c1++) {
						int r2 = r1 + l1;
						int c2 = c1 + l2;
						
						if(is_done(r1, c1, r2, c2)) continue;
						
						if(is_plc(r1, c1, r2, c2)) {
							answer++;
							check(r1, c1, r2, c2);
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
	
	static boolean is_plc(int r1, int c1, int r2, int c2) {
		boolean[][] visited = new boolean[N][N];
		int[] regions = new int[26];
		for(int r = r1; r <= r2; r++) {
			for(int c = c1; c <= c2; c++) {
				if(visited[r][c]) continue;
				visited[r][c] = true;
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] {r, c});
				char color = images[r][c];
				while(!q.isEmpty()) {
					int[] curr = q.poll();
					for(int d = 0; d < 4; d++) {
						int nr = curr[0] + dr[d];
						int nc = curr[1] + dc[d];
						if(nr == r1 - 1 || nr == r2 + 1 || nc == c1 - 1 || nc == c2 + 1 || visited[nr][nc] || images[nr][nc] != color) continue;
						visited[nr][nc] = true;
						q.add(new int[] {nr, nc});
					}
				}
				regions[color - 'A']++;
			}
		}
		
		int one = 0;
		int more = 0;
		for(int i = 0; i < 26; i++) {
			if(regions[i] == 1) one++;
			else if(1 < regions[i]) more++;
		}
		if(one != 1 || more != 1) return false;	
		return true;
	}
	
	static void check(int r1, int c1, int r2, int c2) {
		for(int i = r1; i <= r2; i++) {
			for(int j = c1; j <= c2; j++) {
				for(int k = i; k <= r2; k++) {
					for(int l = j; l <= c2; l++) {
						plc[i][j][k][l] = true;
					}
				}
			}
		}
	}
	
	static boolean is_done(int r1, int c1, int r2, int c2) {
		if(plc[r1][c1][r2][c2]) return true;
		return false;
	}
}

//	static int N;
//	static char[][] images;
//	static Queue<int[]> cows;
//	static int dr[] = {1, -1, 0, 0};
//	static int dc[] = {0, 0, 1, -1};
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		images = new char[N][N];
//		for(int r = 0; r < N; r++) {
//			images[r] = sc.next().toCharArray();
//		}
//		cows = new LinkedList<>();
//		// 좌상 r1, c1 / 우하 r2, c2
//		for(int r1 = 0; r1 < N; r1++) {
//			for(int c1 = 0; c1 < N; c1++) {
//				for(int r2 = r1; r2 < N; r2++) {
//					for(int c2 = c1; c2 < N; c2++) {
//						calc(r1, c1, r2, c2);
//					}
//				}
//			}
//		}
//		System.out.println(cows.size());
//	}
//	
//	static void calc(int r1, int c1, int r2, int c2) {
//		boolean[][] visited = new boolean[N][N];
//		int[] regions = new int[26];
//		for(int r = r1; r <= r2; r++) {
//			for(int c = c1; c <= c2; c++) {
//				if(visited[r][c]) continue;
//				visited[r][c] = true;
//				Queue<int[]> q = new LinkedList<>();
//				q.add(new int[] {r, c});
//				char color = images[r][c];
//				while(!q.isEmpty()) {
//					int[] curr = q.poll();
//					for(int d = 0; d < 4; d++) {
//						int nr = curr[0] + dr[d];
//						int nc = curr[1] + dc[d];
//						if(nr == r1 - 1 || nr == r2 + 1 || nc == c1 - 1 || nc == c2 + 1 || visited[nr][nc] || images[nr][nc] != color) continue;
//						visited[nr][nc] = true;
//						q.add(new int[] {nr, nc});
//					}
//				}
//				regions[color - 'A']++;
//			}
//		}
//		
//		int one = 0;
//		int more = 0;
//		for(int i = 0; i < 26; i++) {
//			if(regions[i] == 1) one++;
//			else if(1 < regions[i]) more++;
//		}
//		
//		if(one != 1 || more != 1) return;
//		
//		int l = cows.size();
//		boolean smaller = false;
//		for(int i = 0; i < l; i++) {
//			int[] curr = cows.poll();
//			if(curr[0] < r1 || curr[1] < c1 || r2 < curr[2] || c2 < curr[3])
//				cows.add(curr);
//			if(curr[0] <= r1 && curr[1] <= c1 && r2 <= curr[2] && c2 <= curr[3])
//				smaller = true;
//		}
//		
//		if(!smaller)
//			cows.add(new int[] {r1, c1, r2, c2});
//	}
//}

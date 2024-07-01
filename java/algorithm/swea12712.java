import java.util.Scanner;

public class swea12712 {

	public static void main(String[] args) {
		int[] dr1 = {1, -1, 0, 0};
		int[] dc1 = {0, 0, 1, -1};
		int[] dr2 = {1, 1, -1, -1};
		int[] dc2 = {1, -1, 1, -1};
		
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N, M;
			N = sc.nextInt();
			M = sc.nextInt();
			int[][] flys = new int[N][N];
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					flys[r][c] = sc.nextInt();
				}
			}
			int answer = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					int tmp = flys[r][c];
					for(int d = 0; d < 4; d++) {
						for(int dist = 1; dist < M; dist++) {
							int nr = r + dist * dr1[d];
							int nc = c + dist * dc1[d];
							if(0 <= nr && nr < N && 0 <= nc && nc < N) {
								tmp += flys[nr][nc];
							}
						}
					}
					answer = Math.max(answer, tmp);
					tmp = flys[r][c];
					for(int d = 0; d < 4; d++) {
						for(int dist = 1; dist < M; dist++) {
							int nr = r + dist * dr2[d];
							int nc = c + dist * dc2[d];
							if(0 <= nr && nr < N && 0 <= nc && nc < N) {
								tmp += flys[nr][nc];
							}
						}
					}
					answer = Math.max(answer, tmp);
				}
			}
			
			System.out.println("#"+tc+" "+answer);
			
		}
		
	}

}

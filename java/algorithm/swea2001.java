import java.util.Scanner;

public class swea2001 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N, M;
			N = sc.nextInt();
			M = sc.nextInt();
			
			int[][] flys = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					flys[r][c] = sc.nextInt();
				}
			}
			
			int answer = 0;
			for (int r = 0; r <= N-M; r++) {
				for (int c = 0; c <= N-M; c++) {
					int total = 0;
					
					for (int dr = r; dr < r + M; dr++) {
						for (int dc = c; dc < c + M; dc++) {
							total += flys[dr][dc];
						}
					}
					
					answer = Math.max(answer, total);
				}
			}
			
			System.out.println("#" + tc + " " + answer);
			
		}
		
	}
	
}

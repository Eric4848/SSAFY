import java.util.Scanner;

public class swea1961 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T;
		T = sc.nextInt();
		
		for(int tc = 1; tc <= T ; tc++) {
			
			int N;
			N = sc.nextInt();
			int[][] nums = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					nums[r][c] = sc.nextInt();
				}
			}
			
			int[][] answers = new int[N][N*3];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					answers[r][c] = nums[N-c-1][r];
				}
				for(int c = 0; c < N; c++) {
					answers[r][N+c] = nums[N-r-1][N-c-1];
				}
				for(int c = 0; c < N; c++) {
					answers[r][2*N+c] = nums[c][N-r-1];
				}
			}
			
			System.out.println("#"+tc);
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					System.out.print(answers[r][c]);
				}
				System.out.print(" ");
				for(int c = 0; c < N; c++) {
					System.out.print(answers[r][N+c]);
				}
				System.out.print(" ");
				for(int c = 0; c < N; c++) {
					System.out.print(answers[r][2*N+c]);
				}
				System.out.println();
			}
			
		}
		
	}

}

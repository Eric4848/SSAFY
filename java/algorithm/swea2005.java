import java.util.Scanner;

public class swea2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] pascals = new int[N][N];
			pascals[0][0] = 1;
			if (N != 1) {
				for (int i = 1; i < N; i ++) {
					pascals[i][0] = 1;
					pascals[i][i] = 1;
					for (int j = 1; j < i; j++) {
						pascals[i][j] = pascals[i-1][j-1] + pascals[i-1][j];
					}
				}
			}
			System.out.println("#"+test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(pascals[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}

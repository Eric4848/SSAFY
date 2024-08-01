import java.util.Scanner;

public class swea1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			int num = 2;
			int r = 0;
			int c = 0;
			int nr = 0;
			int nc = 0;
			int head = 0;
			snail[0][0] = 1;
			while(num <= N * N) {
				nr = r + dr[head];
				nc = c + dc[head];
				if(0 <= nr && nr < N && 0 <= nc && nc < N) {
					if(snail[nr][nc] == 0) {
						snail[nr][nc] = num++;
						r = nr;
						c = nc;
						continue;
					}
				}
				head = (head + 1) % 4;
			}
            System.out.println("#" + tc);
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					System.out.print(snail[row][col] + " ");
				}
				System.out.println();
			}
		}
	}
}
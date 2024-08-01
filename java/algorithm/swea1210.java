import java.util.*;
import java.io.*;

class swea1210 {
    static int r;
    static int c;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 100;
		int[] dr = {0, 0, -1};
		int[] dc = {-1, 1, 0};
		for(int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int[][] ladders = new int[N][N];
			for(int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					ladders[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			r = N-1;
			for(int col = 0; col < N; col++) {
				if(ladders[N-1][col] == 2)
					c = col;
			}
			int head = 2;
			while(true) {
				if(r == 0)
					break;
				r += dr[head];
				c += dc[head];
				if(head == 2) {
					for(int d = 0; d < 2; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(0 <= nr && nr < N && 0 <= nc && nc < N) {
							if(ladders[nr][nc] == 1) {
								head = d;
							}
						}
					}
				} else {
					if(ladders[r-1][c] == 1)
						head = 2;
				}
			}
			System.out.println("#" + tc + " " + c);
		}
	}
}
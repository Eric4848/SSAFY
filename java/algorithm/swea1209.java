import java.util.*;
import java.io.*;

class swea1209 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 100;
		for(int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int answer = 0;
			int[][] nums = new int[N][N];
			for(int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int tmp = 0;
				for(int c = 0; c < N; c++) {
					nums[r][c] = Integer.parseInt(st.nextToken());
					tmp += nums[r][c];
				}
				answer = Math.max(answer, tmp);
			}
			for(int c = 0; c < N; c++) {
				int tmp = 0;
				for(int r = 0; r < N; r++) {
					tmp += nums[r][c];
				}
				answer = Math.max(answer, tmp);
			}
			int tmp = 0;
			int r = 0;
			int c = 0;
			for(int d = 0; d < N; d++) {
				tmp += nums[r + d][c + d];
			}
			answer = Math.max(answer, tmp);
			tmp = 0;
			r = 0;
			c = N-1;
			for(int d = 0; d < N; d++) {
				tmp += nums[r + d][c - d];
			}
			answer = Math.max(answer, tmp);
			System.out.println("#" + tc + " " + answer);
		}
	}
}
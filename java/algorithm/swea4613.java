import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4613 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] flag = new char[N][M];
			int[][] cnts = new int[N][3];
			for(int r = 0; r < N; r++) {
				String row = br.readLine();
				for(int c = 0; c < M; c++) {
					flag[r][c] = row.charAt(c);
					switch (flag[r][c]) {
						case 'W': {
							cnts[r][0]++;
							break;
						}
						case 'B': {
							cnts[r][1]++;
							break;
						}
						case 'R': {
							cnts[r][2]++;
							break;
						}
					}
				}
			}
			
			int answer = Integer.MAX_VALUE;
			for(int bs = 1; bs < N-1; bs++) {
				for(int be = bs+1; be < N; be++) {
					int tmp = 0;
					for(int w = 0; w < bs; w++) {
						tmp += M - cnts[w][0];
					}
					for(int b = bs; b < be; b++) {
						tmp += M - cnts[b][1];
					}
					for(int r = be; r < N; r++) {
						tmp += M - cnts[r][2];
					}
					answer = Math.min(answer, tmp);
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}


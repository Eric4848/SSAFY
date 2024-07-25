import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[][] board = new String[8][8];
			for(int r = 0; r < 8; r++) {
				board[r] = br.readLine().split("");
			}
			int answer = 0;
			for(int r = 0; r < 8; r++) {
				for(int c = 0; c <= 8 - N; c++) {
					int cnt = 1;
					for(int d = 0; d < N / 2; d++) {
						if(!board[r][c+d].equals(board[r][c+N-1-d])) {
							cnt--;
							break;
						}
					}
					answer += cnt;
				}
			}
			for(int r = 0; r <= 8 - N; r++) {
				for(int c = 0; c < 8; c++) {
					int cnt = 1;
					for(int d = 0; d < N / 2; d++) {
						if(!board[r+d][c].equals(board[r+N-1-d][c])) {
							cnt--;
							break;
						}
					}
					answer += cnt;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18428 {
	static int N, T;
	static boolean answer = false;
	static String[][] maps;
	static int[][] teachers = new int[50][2];
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		maps = new String[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				maps[r][c] = st.nextToken();
			}
		}
		T = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0;c < N; c++) {
				if(maps[r][c].equals("T")) {
					teachers[T][0] = r;
					teachers[T][1] = c;
					T++;
				}
			}
		}
		
		locate(0, 0);
		if(answer)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	static void locate(int d, int l) {
		if(d == 3) {
			calc();
			return;
		}
		
		for(int loc = l; loc < N * N; loc++) {
			int r = loc / N;
			int c = loc % N;
			if(maps[r][c].equals("X")) {
				maps[r][c] = "O";
				locate(d + 1, loc + 1);
				maps[r][c] = "X";
			}
		}
	}
	
	static void calc() {
		for(int t = 0; t < T; t++) {
			int r = teachers[t][0];
			int c = teachers[t][1];
			for(int d = 0; d < 4; d++) {
				for(int l = 1; l < N; l++) {
					int nr = r + dr[d] * l;
					int nc = c + dc[d] * l;
					if(nr == -1 || nr == N || nc == -1 || nc == N) break;
					if(maps[nr][nc].equals("O")) break;
					if(maps[nr][nc].equals("S")) return;
				}
			}
		}
		
		answer = true;
	};
}

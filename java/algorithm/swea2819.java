import java.io.*;
import java.util.*;

public class swea2819 {
	static String[][] boards = new String[4][4];
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static Set<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			set = new HashSet<>();
			for(int r = 0; r < 4; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < 4; c++) {
					boards[r][c] = st.nextToken();
				}
			}
			for(int r = 0; r < 4; r++) {
				for(int c = 0; c < 4; c++) {
					dfs(r, c, "");
				}
			}
			System.out.println("#" + tc + " " + set.size());
		}
	}
	static void dfs(int r, int c, String nums) {
		if (nums.length() == 7) {
			set.add(nums);
			return;
		}
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(0 <= nr && nr < 4 && 0 <= nc && nc <4) {
				dfs(nr, nc, nums + boards[r][c]);
			}
		}
	}
}
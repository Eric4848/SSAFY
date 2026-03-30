import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj8972 {
	static int R, C;
	static int[] dr = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int[] dc = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
	static int[] me;
	static char[][] maps;
	static int[][] mads;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maps = new char[R][C];
		for(int r = 0; r < R; r++) {
			maps[r] = br.readLine().toCharArray();
		}
		String directions = br.readLine();
		Queue<int[]> mad = new LinkedList<int[]>();
		me = new int[2];
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(maps[r][c] == 'I') {
					me[0] = r;
					me[1] = c;
					maps[r][c] = '.';
				}
				else if(maps[r][c] == 'R') {
					mad.add(new int[] {r, c});
				}
			}
		}
		
		for(int i = 1; i <= directions.length(); i++) {
			int direction = directions.charAt(i-1) - '0';
			me[0] += dr[direction];
			me[1] += dc[direction];
			
			mads = new int[R][C];
			for(int r = 0; r < R; r++) {
				Arrays.fill(maps[r], '.');
			}
			int L = mad.size();
			for(int l = 0; l < L; l++) {
				int[] curr = mad.poll();
				int r = curr[0];
				int c = curr[1];
				move(r, c);
			}
			
			if(mads[me[0]][me[1]] != 0) {
				System.out.println("kraj " + i);
				return;
			}
			
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(mads[r][c] == 0) continue;
					if(1 < mads[r][c]) maps[r][c] = '.';
					else mad.add(new int[] {r, c});
				}
			}
		}
		
		maps[me[0]][me[1]] = 'I';
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				System.out.print(maps[r][c]);
			}
			System.out.println();
		}
	}
	
	static void move(int r, int c) {
		int mr = -1;
		int mc = -1;
		int dist = Integer.MAX_VALUE;
		for(int d = 1; d <= 9; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr == -1 || nr == R || nc == -1 || nc == C) continue;
			int diff = Math.abs(nr - me[0]) + Math.abs(nc - me[1]);
			if(diff < dist) {
				dist = diff;
				mr = nr;
				mc = nc;
			}
		}
		maps[mr][mc] = 'R';
		mads[mr][mc]++;
	}
}

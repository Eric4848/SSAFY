import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17142 {
	static int N, M, target, answer;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int[][] labs;
	static List<int[]> viruses;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		target = 0;
		labs = new int[N][N];
		viruses = new ArrayList<>();
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				labs[r][c] = Integer.parseInt(st.nextToken());
				if(labs[r][c] != 1)
					target++;
				if(labs[r][c] == 2)
					viruses.add(new int[] {r, c});
			}
		}
		List<Integer> locs = new LinkedList<Integer>();
		comb(locs, 0);
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	
	static void comb(List<Integer> locs, int loc) {
		if(locs.size() == M) {
			test(locs);
			return;
		}
		for(int i = loc; i < viruses.size(); i++) {
			locs.add(i);
			comb(locs, i+1);
			locs.remove(locs.size()-1);
		}
	}
	
	static void test(List<Integer> locs) {
		boolean[][] poisoned = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		for(int loc : locs) {
			int[] virus = viruses.get(loc);
			poisoned[virus[0]][virus[1]] = true;
			q.add(virus);
		}
		int left = target - viruses.size();
		int time = 0;
		while(!q.isEmpty()) {
			if(time == answer) return;
			if(left == 0) break;
			int l = q.size();
			for(int i = 0; i < l; i++) {
				int[] curr = q.poll();
				for(int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];
					if(nr < 0 || N <= nr || nc < 0 || N <= nc) continue;
					if(labs[nr][nc] != 1 && !poisoned[nr][nc]) {
						poisoned[nr][nc] = true;
						q.add(new int[] {nr, nc});
						left--;
						if(labs[nr][nc] == 2)
							left++;
					}
				}
			}
			time++;
		}
		if(left == 0)
			answer = Math.min(answer, time);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9874 {
	static int N, answer;
	static int[][] wormholes;
	static boolean[] linked;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		answer = 0;
		wormholes = new int[N][3];
		linked = new boolean[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			wormholes[i][0] = x;
			wormholes[i][1] = y;
		}
		link(0, 0);
		System.out.println(answer);
	}
	
	static void link(int cnt, int idx) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				if(move(i)) {
					answer++;
					return;
				}
			}
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(linked[i]) continue;
			linked[i] = true;
			for(int j = i + 1; j < N; j++){
				if(linked[j]) continue;
				linked[j] = true;
				wormholes[i][2] = j;
				wormholes[j][2] = i;
				link(cnt + 2, i + 1);
				linked[j] = false;
			}
			linked[i] = false;
		}
	}
	
	static boolean move(int start) {
		int idx = start;
		
		for(int cnt = 0; cnt < N; cnt++) {
			int nxt = find(idx);
			if(nxt == -1) return false;
			idx = wormholes[nxt][2];
		}
		
		return true;
	}
	
	static int find(int idx) {
		int x = wormholes[idx][0];
		int y = wormholes[idx][1];
		int nxtidx = -1;
		int nxtx = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			if(y == wormholes[i][1] && x < wormholes[i][0]) {
				if(wormholes[i][0] < nxtx) {					
					nxtx = wormholes[i][0];
					nxtidx = i;
				}
			}
		}
		return nxtidx;
	}
}

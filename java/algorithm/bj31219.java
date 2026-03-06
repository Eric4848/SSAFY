import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj31219 {
	static int N;
	static double[][] dists;
	static double[][] dp;
	static double max = 10 * 4 * 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] locs = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			locs[i][0] = Integer.parseInt(st.nextToken());
			locs[i][1] = Integer.parseInt(st.nextToken());
		}
		dists = new double[N][N];
		dp = new double[N][1 << N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				double dist = Math.sqrt(Math.pow((locs[i][0] - locs[j][0]), 2) + Math.pow((locs[i][1] - locs[j][1]), 2));
				dists[i][j] = dist;
				dists[j][i] = dist;
			}
			Arrays.fill(dp[i], -1);
		}

		System.out.println(tsp(0, 1));
	}
	
	static double tsp(int curr, int move) {
		if(move == (1 << N) - 1) {
			if(dists[curr][0] != 0) {
				return dists[curr][0];
			}
			return max;
		}
		
		if(dp[curr][move] != -1) return dp[curr][move];
		
		dp[curr][move] = max;
		for(int nxt = 0; nxt < N; nxt++) {
			if(dists[curr][nxt] == 0 || (move & (1 << nxt)) != 0) continue;
			dp[curr][move] = Math.min(dp[curr][move], tsp(nxt, move | (1 << nxt)) + dists[curr][nxt]);
		}
		
		return dp[curr][move];
	}
}

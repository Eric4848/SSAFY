import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] scores = new int[n+1][k+1];
			int[] submits = new int[n+1];
			int[] times = new int[n+1];
			int[] totals = new int[n+1];
			for(int x = 0; x < m; x++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				scores[i][j] = Math.max(scores[i][j], s);
				submits[i]++;
				times[i] = x;
			}
			
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= k; j++) {
					totals[i] += scores[i][j];
				}
			}
			
			int rank = 1;
			for(int i = 1; i <= n; i++) {
				if(i == t) continue;
				if(totals[t] < totals[i]) {
					rank++;
					continue;
				}
				if(totals[t] == totals[i] && submits[i] < submits[t]) {
					rank++;
					continue;
				}
				if(totals[t] == totals[i] && submits[i] == submits[t] && times[i] < times[t]) {
					rank++;
					continue;
				}
			}
			System.out.println(rank);
		}
	}
}

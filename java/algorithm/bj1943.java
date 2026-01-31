import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1943 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 0; tc < 3; tc++) {
			int N = Integer.parseInt(br.readLine());
			int total = 0;
			int[][] coins = new int[N][2];
			int cnts = 0;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int coin = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				total += coin * cnt;
				cnts += cnt;
				coins[i][0] = coin;
				coins[i][1] = cnt;
			}
			if(total % 2 == 1) {
				System.out.println(0);
				continue;
			}
			total /= 2;
			boolean[][] dp = new boolean[N + 1][total + 1];
			dp[0][0] = true;
			int idx = 0;
			for(int i = 0; i < N; i++) {
				int coin = coins[i][0];
				int cnt = coins[i][1];
				for(int sum = 0; sum < total; sum++) {
					if(dp[i][sum]) {
						for(int c = 0; c <= cnt; c++) {
							if(sum + coin * c <= total) {
								dp[i+1][sum + coin * c] = true;
							}
						}
					}
				}
			}
			if(dp[N][total])
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}

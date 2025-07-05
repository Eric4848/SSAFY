import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] prices = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			int maximum = prices[N-1];
			Long answer = 0L;
			for(int i = N-2; 0 <= i; i--) {
				if(prices[i] < maximum) {
					answer += maximum - prices[i];
				}
				else if(maximum < prices[i]) {
					maximum = prices[i];
				}
			}
			System.out.println(answer);
		}
	}
}

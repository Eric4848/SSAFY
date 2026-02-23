import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1027 {
	static int N;
	static int[] buildings;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		buildings = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
			int result = calc(i);
			answer = Math.max(answer, result);
		}
		
		System.out.println(answer);
	}
	
	static int calc(int idx) {
		int cnt = 0;
		if(0 < idx) {
			double grad = buildings[idx - 1] - buildings[idx];
			cnt++;
			for(int i = idx - 2; 0 <= i; i--) {
				double nxt = (double)(buildings[i] - buildings[idx]) / (idx - i);
				if(grad < nxt) {
					grad = nxt;
					cnt++;
				}
			}
		}
		
		if(idx < N-1) {
			double grad = buildings[idx + 1] - buildings[idx];
			cnt++;
			for(int i = idx + 2; i < N; i++) {
				double nxt = (double)(buildings[i] - buildings[idx]) / (i - idx);
				if(grad < nxt) {
					grad = nxt;
					cnt++;
				}
			}
		}
		return cnt;
	}
}

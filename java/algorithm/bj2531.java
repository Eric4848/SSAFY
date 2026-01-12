import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2531 {
	static int[] sushis;
	static int d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		sushis = new int[d+1];
		sushis[c]++;
		
		int[] plates = new int[N+k];
		for(int i = 0; i < N; i++) {
			plates[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < k; i++) {
			plates[N+i] = plates[i];
			sushis[plates[i]]++;
		}
		int answer = count();
		for(int i = 0; i < N - 1; i++) {
			sushis[plates[i]]--;
			sushis[plates[i+k]]++;
			answer = Math.max(answer, count());
		}
		System.out.println(answer);
	}
	
	static int count() {
		int cnt = 0;
		for(int i = 1; i <= d; i++) {
			if(sushis[i] != 0)
				cnt++;
		}
		return cnt;
	}
}

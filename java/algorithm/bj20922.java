import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		int front = 0;
		int back = 0;
		int[] cnts = new int[100001];
		while(back < N) {
				int num = nums[back];
				cnts[num]++;
				while(K < cnts[num]) {
					cnts[nums[front]]--;
					front++;
				}
			answer = Math.max(answer, back - front + 1);
			back++;
		}
		System.out.println(answer);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int total = nums[0];
		int head = 0;
		int tail = 0;
		while(total < S) {
			tail++;
			if(tail < N)
				total += nums[tail];
			else {
				System.out.println(0);
				return;
			}
		}
		
		int answer = ++tail;
		while(head < tail) {
			if(S < total) {
				total -= nums[head++];
			}
			else {
				if(tail == N) break;
				total += nums[tail++];
			}
			if(S <= total)
				answer = Math.min(answer, tail - head);
		}
		
		System.out.println(answer);
	}
}

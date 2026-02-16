import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13144 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		int[] cnts = new int[100001];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		long answer = 0;
		for(;right < N; right++) {
			cnts[nums[right]]++;
			while(1 < cnts[nums[right]]) {
				cnts[nums[left]]--;
				left++;
			}
			answer += right - left + 1;
		}
		System.out.println(answer);
	}
}

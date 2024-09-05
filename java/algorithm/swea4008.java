import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4008 {
	static int N;
	static int[] ops;
	static int[] nums;
	static int maximum;
	static int minimum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			ops = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				ops[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			maximum = Integer.MIN_VALUE;
			minimum = Integer.MAX_VALUE;
			calc(1, nums[0]);
			System.out.println("#" + tc + " " + (maximum - minimum));
		}
	}
	static void calc(int d, int res) {
		if(d == N) {
			maximum = Math.max(maximum, res);
			minimum = Math.min(minimum, res);
			return;
		}
		if(ops[0] > 0) {
			ops[0]--;
			calc(d+1, res + nums[d]);
			ops[0]++;
		}
		if(ops[1] > 0) {
			ops[1]--;
			calc(d+1, res - nums[d]);
			ops[1]++;
		}
		if(ops[2] > 0) {
			ops[2]--;
			calc(d+1, res * nums[d]);
			ops[2]++;
		}
		if(ops[3] > 0) {
			ops[3]--;
			calc(d+1, res / nums[d]);
			ops[3]++;
		}
	}
}

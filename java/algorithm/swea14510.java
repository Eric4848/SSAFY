import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea14510 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[N];
			st = new StringTokenizer(br.readLine());
			int maximum = 0;
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				maximum = Math.max(maximum, nums[i]);
			}
			int one = 0;
			int two = 0;
			for(int i = 0; i < N; i++) {
				int diff = maximum - nums[i];
				two += diff / 2;
				one += diff % 2;
			}
//			System.out.println(one + ", " + two);
			while(one + 1 < two) {
				one += 2;
				two -= 1;
			}
//			if(one -  two >= 2) {
//				one -= 2;
//				two += 1;
//			}
			int answer = two * 2;
			if(two < one) answer = one * 2 - 1;
//			System.out.println(one + ", " + two);
			System.out.println("#" +  tc + " " + answer);
		}
	}
}

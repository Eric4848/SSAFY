import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long[] liqs = new Long[N];
		for(int i = 0; i < N; i++) {
			liqs[i] = Long.parseLong(st.nextToken());
		}
		int left = 0;
		int right = N-1;
		int[] answers = new int[2];
		Long answer = Long.MAX_VALUE;
		while(left < right) {
			Long diff = liqs[left] + liqs[right];
			if(Math.abs(diff) <= answer) {
				answers[0] = left;
				answers[1] = right;
				answer = Math.abs(diff);
			}
			
			if(diff < 0)
				left++;
			else
				right--;
		}
		System.out.println(liqs[answers[0]] + " " + liqs[answers[1]]);
	}
}

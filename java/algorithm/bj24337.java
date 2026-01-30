import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj24337 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int max = Math.max(a, b);
		int[] answers = new int[N];
		Arrays.fill(answers, 1);
		int idx = N-1;
		for(int i = 1; i < b ; i++) {
			answers[idx--] = i;
		}
		answers[idx--] = max;
		if(idx + 2< a) {
			System.out.println(-1);
			return;
		}
		
		if(a == 1) {
			answers[idx+1] = 1;
			answers[0] = max;
		}
		
		while(1 < a) {
			answers[idx--] = --a;
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(answers[i] + " ");
		}
	}
}

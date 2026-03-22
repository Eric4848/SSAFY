import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj4256 {
	static int n;
	static int[] pres, ins;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st1;
		StringTokenizer st2;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			pres = new int[n];
			ins = new int[n];
			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				pres[i] = Integer.parseInt(st1.nextToken());
				ins[i] = Integer.parseInt(st2.nextToken());
			}
			post(0, 0, n);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void post(int root, int start, int end) {
		for(int i = start; i < end; i++) {
			if(pres[root] == ins[i]) {
				post(root + 1, start, i);
				post(root + 1 + i - start, i + 1, end);
				sb.append(pres[root]).append(" ");
				return;
			}
		}
	}
}

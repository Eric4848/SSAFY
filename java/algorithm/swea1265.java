import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1265 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int target = N / P;
			int rest = N % P;
			Long answer = 1L;
			for(int i = 0; i < P; i++) {
				if(0 < rest--)
					answer *= (target + 1);
				else
					answer *= target;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}

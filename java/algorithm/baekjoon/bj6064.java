package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int lcm = M * N / gcd(M, N);
			int K = x;
			boolean is_correct = false;
			while(K <= lcm) {
				if((K - x) % M == 0 && (K - y) % N == 0) {
					is_correct = true;
					break;
				}
				K += M;
			}
			if(is_correct)
				System.out.println(K);
			else
				System.out.println(-1);
		}
	}
	
	static int gcd(int p, int q) {
		if(q == 0) return p;
		return gcd(q, p % q);
	}
}

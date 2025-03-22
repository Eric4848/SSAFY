package 종만북;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PASS486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= C; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int lo = Integer.parseInt(st.nextToken());
			int hi = Integer.parseInt(st.nextToken());
			int[] primes = new int[hi+1];
			for(int i = 1; i <= hi; i++) {
				for(int j = i; j <= hi; j += i) {
					primes[j]++;
				}
			}
			int answer = 0;
			for(int i = lo; i <= hi; i++) {
				if(primes[i] == n) answer++;
			}
			System.out.println(answer);
		}
	}
}

package baekjoon;

import java.io.*;
import java.util.*;

public class bj18185 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] stocks = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			stocks[i] = Integer.parseInt(st.nextToken());
		}
		
		long answer = 0;
		
		int l = 3;
		while(0 < l) {
			for(int i = 0; i <= N-l; i++) {
				int maximum = Integer.MAX_VALUE;
				for(int d = 0; d < l; d++)
					maximum = Math.min(maximum, stocks[i+d]);
				for(int d = 0; d < l; d++)
					stocks[i+d] -= maximum;
				answer += (3 * l - l + 1) * maximum;
			}
			l--;
		}
		System.out.println(answer);
	}
}

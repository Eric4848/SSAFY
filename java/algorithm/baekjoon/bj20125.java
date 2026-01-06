package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20125 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] cookies = new char[N][N];
		StringTokenizer st;
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			cookies[r] = st.nextToken().toCharArray();
		}
		int R = 0, C = 0, LA = 0, RA = 0, B = 0, LL = 0, RL = 0;
		bp: for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(cookies[r][c] == '*') {
					R = r;
					C = c;
					break bp;
				}
			}
		}
		for(int c = C-1; 0 <= c; c--) {
			if(cookies[R+1][c] == '_')
				break;
			LA++;
		}
		for(int c = C+1; c < N; c++) {
			if(cookies[R+1][c] == '_')
				break;
			RA++;
		}
		for(int r = R+2; r < N; r++) {
			if(cookies[r][C] == '_')
				break;
			B++;
		}
		for(int r = R+2+B; r < N; r++) {
			if(cookies[r][C-1] == '_')
				break;
			LL++;
		}
		for(int r = R+2+B; r < N; r++) {
			if(cookies[r][C+1] == '_')
				break;
			RL++;
		}
//		for(int r = 0; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				System.out.print(cookies[r][c]);
//			}
//			System.out.println();
//		}
		R += 2;
		C += 1;
		System.out.println(R + " " + C);
		System.out.println(LA + " " + RA + " " + B + " " + LL + " " + RL);
	}
}

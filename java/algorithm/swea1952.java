import java.util.*;
import java.io.*;

class swea1952
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int[] prices = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			int answer = prices[3];
			int[] plans = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] answers = new int[2][13];
			
			for(int i = 1; i <= 12; i++) {
				answers[0][i] = Math.min(prices[0] * plans[i-1], prices[1]);
			}
			
			for(int i = 0; i < 12; i++) {
				answers[0][i+1] += answers[0][i];
			}
			
			for(int i = 0; i < 12; i++) {
				answers[1][i] = answers[0][i];
			}
			
			for(int i = 3; i <= 12; i++) {
				answers[1][i] = Math.min(answers[1][i-1] + answers[0][i] - answers[0][i-1], answers[1][i-3] + prices[2]);
			}
			
			answer = Math.min(answer, answers[1][12]);
			System.out.println("#" + tc + " " + answer);
		}
	}
}
import java.util.*;
import java.io.*;

class swea5215
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[] scores = new int[N+1];
			int[] calories = new int[N+1];
			for(int i = 1; i <= N; i++) {
				scores[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			
			int[][] dp = new int[N+1][L+1];
			for(int i = 1; i <= N; i++) {
				int score = scores[i];
				int calory = calories[i];
				for(int j = 0; j <= L; j++) {
					if(j < calory)
						dp[i][j] = dp[i-1][j];
					else
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-calory] + score);
				}
			}
			System.out.println(dp[N][L]);
		}
	}
}































// 중복
//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	int T = sc.nextInt();
//	for(int tc = 1; tc <= T; tc++) {
//		int N = sc.nextInt();
//		int L = sc.nextInt();
//		int[] scores = new int[N+1];
//		int[] calories = new int[N+1];
//		for(int i = 1; i <= N; i++) {
//			scores[i] = sc.nextInt();
//			calories[i] = sc.nextInt();
//		}
//		
//		int[] dp = new int[L+1];
//		for(int i = 1; i <= N; i++) {
//			int score = scores[i];
//			int calory = calories[i];
//			for(int j = 0; j <= L; j++) {
//				if(j < calory)
//					continue;
//				else
//					dp[j] = Math.max(dp[j], dp[j-calory] + score);
//			}
//			System.out.println(Arrays.toString(dp));
//		}
//		System.out.println(dp[L]);
//	}
//}

































































//class swea5215
//{
//	static int N;
//	static int L;
//	static int[] scores;
//	static int[] cals;
//	static int answer;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		int T = Integer.parseInt(br.readLine());
//		for(int tc = 1; tc <= T; tc++) {
//			st = new StringTokenizer(br.readLine());
//			N = Integer.parseInt(st.nextToken());
//			L = Integer.parseInt(st.nextToken());
//			scores = new int[N];
//			cals = new int[N];
//			for(int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				scores[i] = Integer.parseInt(st.nextToken());
//				cals[i] = Integer.parseInt(st.nextToken());
//			}
//			answer = 0;
//			calc(0, 0, 0);
//			System.out.println("#" + tc + " " + answer);
//		}
//	}
//	static void calc(int d, int ctotal, int stotal) {
//		if(L < ctotal) return;
//		else if(d == N) {
//			answer = Math.max(answer, stotal);
//			return;
//		}
//		calc(d+1, ctotal, stotal);
//		calc(d+1, ctotal + cals[d], stotal+scores[d]);
//	}
//}
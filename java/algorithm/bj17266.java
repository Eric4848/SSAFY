import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17266 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] locs = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++)
			locs[i] = Integer.parseInt(st.nextToken());
		int answer = Math.max(locs[0], N - locs[M-1]);
		for(int i = 1; i < M - 1; i++) {
			answer = Math.max(answer, (locs[i] - locs[i - 1] + 1) / 2);
			answer = Math.max(answer, (locs[i + 1] - locs[i] + 1) / 2);
		}
		System.out.println(answer);
	}
}



//public class bj17266 {
//	static int N, M;
//	static int[] locs;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		M = Integer.parseInt(br.readLine());
//		locs = new int[M];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < M; i++)
//			locs[i] = Integer.parseInt(st.nextToken());
//		
//		int L = 0;
//		int R = N + 1;
//		while(L < R) {
//			int mid = (L + R) / 2;
//			if(check(mid))
//				R = mid;
//			else
//				L = mid + 1;
//		}
//		System.out.println(L);
//	}
//	
//	static boolean check(int H) {
//		boolean[] roads = new boolean[N+1];
//		for(int i = 0; i < M; i++) {
//			int loc = locs[i];
//			for(int d = 0; d <= H; d++) {
//				if(loc + d <= N)
//					roads[loc + d] = true;
//				if(0 <= loc - d)
//					roads[loc - d] = true;
//			}
//		}
//		
//		for(int i = 0; i <= N; i++)
//			if(!roads[i]) return false;
//		
//		return true;
//	}
//}

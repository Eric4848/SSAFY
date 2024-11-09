import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class swea10726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb = new StringBuilder();
			sb.append("#").append(tc);
			N = (1<<N)-1;
			if((M & N) == N)
				sb.append(" ON");
			else
				sb.append(" OFF");
			System.out.println(sb);
		}
	}
}

//public class swea10726 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb;
//		int T = Integer.parseInt(br.readLine());
//		for(int tc = 1; tc <= T; tc++) {
//			st = new StringTokenizer(br.readLine());
//			int N = Integer.parseInt(st.nextToken());
//			int M = Integer.parseInt(st.nextToken());
//			sb = new StringBuilder();
//			sb.append("#").append(tc);
//			N = (1<<N);
//			M %= (N);
//			if(M == N-1)
//				sb.append(" ON");
//			else
//				sb.append(" OFF");
//			System.out.println(sb);
//		}
//	}
//}

//public class swea10726 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		int T = Integer.parseInt(br.readLine());
//		for(int tc = 1; tc <= T; tc++) {
//			st = new StringTokenizer(br.readLine());
//			int N = Integer.parseInt(st.nextToken());
//			int M = Integer.parseInt(st.nextToken());
//			N = (1<<N);
//			M %= (N);
//			if(M == N-1)
//				System.out.println("#" + tc + " ON");
//			else
//				System.out.println("#" + tc + " OFF");
//		}
//	}
//}

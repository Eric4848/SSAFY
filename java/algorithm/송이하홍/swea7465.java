package 송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class swea7465 {
	static int[]  parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			for(int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				Union(a, b);
			}
			
			Set<Integer> groups = new HashSet<Integer>();
			for(int i = 1; i <= N; i++) {
				groups.add(Find(i));
			}
			System.out.println("#" + tc + " " + groups.size());
		}
	}
	
	static int Find(int n) {
		if(n != parents[n])
			parents[n] = Find(parents[n]);
		return parents[n];
	}
	
	static void Union(int a, int b) {
		parents[Find(a)] = Find(b);
	}
}


//public class swea7465 {
//	static int[]  parents;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		for(int tc = 1; tc <= T; tc++) {
//			int N = sc.nextInt();
//			int M = sc.nextInt();
//			parents = new int[N+1];
//			for(int i = 1; i <= N; i++) {
//				parents[i] = i;
//			}
//			for(int i = 0; i < M; i++) {
//				int a = Find(sc.nextInt());
//				int b = Find(sc.nextInt());
//				if(a != b)
//					Union(a, b);
//			}
//			Set<Integer> groups = new HashSet<Integer>();
//			for(int i = 1; i <= N; i++) {
//				groups.add(Find(i));
//			}
//			System.out.println("#" + tc + " " + groups.size());
//		}
//	}
//	
//	static int Find(int n) {
//		if(n != parents[n])
//			parents[n] = Find(parents[n]);
//		return parents[n];
//	}
//	
//	static void Union(int a, int b) {
//		parents[a] = parents[b];
//	}
//}



//public class swea7465 {
//	static int[]  parents;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		for(int tc = 1; tc <= T; tc++) {
//			int N = sc.nextInt();
//			int M = sc.nextInt();
//			parents = new int[N+1];
//			for(int i = 1; i <= N; i++) {
//				parents[i] = i;
//			}
//			for(int i = 0; i < M; i++) {
//				int a = sc.nextInt();
//				int b = sc.nextInt();
//				Union(a, b);
//			}
//			Set<Integer> groups = new HashSet<Integer>();
//			for(int i = 1; i <= N; i++) {
//				groups.add(Find(i));
//			}
//			System.out.println("#" + tc + " " + groups.size());
//		}
//	}
//	
//	static int Find(int n) {
//		if(n != parents[n])
//			parents[n] = Find(parents[n]);
//		return parents[n];
//	}
//	
//	static void Union(int a, int b) {
//		parents[Find(a)] = parents[Find(b)];
//	}
//}

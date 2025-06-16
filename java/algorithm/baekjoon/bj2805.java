package baekjoon;

import java.util.Scanner;

public class bj2805 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] trees = new int[N];
		int min = 0;
		int max = 0;
		for(int i = 0; i < N; i++) {
			trees[i] = sc.nextInt();
			max = Math.max(max, trees[i]);
		}
		while(min <= max) {
			int mid = (min + max) / 2;
			long tmp = 0;
			for(int i = 0; i < N; i++) {
				if(mid < trees[i])
					tmp += trees[i] - mid;
			}
			if(M <= tmp)
				min = mid + 1;
			else 
				max = mid - 1;
		}
		System.out.println(max);
	}
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class bj2805 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		st = new StringTokenizer(br.readLine());
//		int[] trees = new int[M];
//		int min = 0;
//		int max = 0;
//		for(int i = 0; i < N; i++) {
//			trees[i] = Integer.parseInt(st.nextToken());
//			max = Math.max(max, trees[i]);
//		}
//		
//		while(min <= max) {
//			int mid = (min + max) / 2;
//			int tmp = 0;
//			for(int i = 0; i < N; i++) {
//				if(mid < trees[i])
//					tmp += trees[i] - mid;
//			}
//			if(M <= tmp)
//				min = mid + 1;
//			else 
//				max = mid - 1;
//		}
//		
//		System.out.println(max);
//	}
//}

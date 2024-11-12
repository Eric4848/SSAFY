package baekjoon;

import java.io.*;
import java.util.*;

public class bj20055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] belts = new int[N*2];
		boolean[] robots = new boolean[N];
		int cnt = 0;
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N*2; i++) {
			belts[i] = Integer.parseInt(st.nextToken());
		}
		
		while(cnt < K) {
			answer++;
			int tmp = belts[N*2-1];
			for(int i = N*2-1; 0 < i; i--) {
				belts[i] = belts[i-1];
			}
			belts[0] = tmp;
			
			for(int i = N-1; 0 < i; i--) {
				robots[i] = robots[i-1];
			}
			robots[0] = false;
			robots[N-1] = false;
			
			for(int i = N-2; 0 < i; i--) {
				if(robots[i] && !robots[i+1] && 0 < belts[i+1]) {
					robots[i] = false;
					robots[i+1] = true;
					belts[i+1]--;
					if(belts[i+1] == 0) cnt++;
				}
			}
			
			if(0 < belts[0]) {
				robots[0] = true;
				belts[0]--;
				if(belts[0] == 0) cnt++;
			}
		}
		System.out.println(answer);
	}
}


//package baekjoon;
//
//import java.io.*;
//import java.util.*;
//
//public class bj20055 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		int[] belts = new int[N * 2];
//		boolean[] robots = new boolean[N];
//		int head = 0;
//		int answer = 0;
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < 2*N; i++) {
//			belts[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		while(true) {
//			head = (head - 1 + 2 * N) % (2 * N);
//			robots[N-2] = false;
//			for(int i = N-2; 1 <= i; i--) {
//				int belti = (head+i+1) % (2 * N);
//				if(robots[i-1]) {
//					if(0 < belts[belti] && !robots[i]) {
//						belts[belti]--;
//						robots[i-1] = false;
//						robots[i] = true;
//					}
//				}
//			}
//			
//			if(0 < belts[head]) {
//				robots[0] = true;
//				belts[head]--;
//			}
//			
//			answer++;
//			
//			int cnt = 0;
//			for(int i = 0; i < 2 * N; i++) {
//				if(belts[i] == 0) cnt++;
//			}
//			for(int i = 0; i < 2 * N; i++) {
//				System.out.print(belts[(head+i) % (2*N)] + " ");
//			}
//			System.out.println();
//			if(cnt == K) break;
//		}
//		System.out.println(answer);
//	}
//}

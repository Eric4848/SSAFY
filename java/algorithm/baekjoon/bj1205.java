package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		if(N == 0) {
			System.out.println(1);
			return;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(-1);
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
			if(pq.size() > P)
				pq.poll();
		}
		int L = pq.size();
		int[] scores = new int[L];
		for(int i = 0; i < L; i++) {
			int score = pq.poll();
			scores[L-i-1] = score;
		}
		
		if(S <= scores[L-1])
			System.out.println(-1);
		else
			for(int i = 0; i < L; i++) {
				if(scores[i] <= S) {
					System.out.println(i+1);
					break;
				}
			}
	}
}

//public class bj1205 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int S = Integer.parseInt(st.nextToken());
//		int P = Integer.parseInt(st.nextToken());
//		if(N == 0) {
//			System.out.println(1);
//			return;
//		}
//		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {return b - a;});
//		st = new StringTokenizer(br.readLine());
//		if(N < P)
//			pq.add(S);
//		for(int i = 0; i < N; i++) {
//			pq.add(Integer.parseInt(st.nextToken()));
//			if(pq.size() > P) {
//				pq.poll();
//			}
//		}
//		int L = pq.size();
//		boolean flag = false;
//		int[] scores = new int[L];
//		for(int i = 0; i < L; i++) {
//			scores[i] = pq.poll();
//		}
//		
//		if(scores[L-1] >= S && L == P) {
//			System.out.println(-1);
//			return;
//		}
//		
//		for(int i = 0; i < L; i++) {
//			if(scores[i] <= S) {
//				System.out.println(i+1);
//				break;
//			}
//		}
//	}
//}
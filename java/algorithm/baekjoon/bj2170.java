package baekjoon;

import java.io.*;
import java.util.*;

public class bj2170 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {return o1[0] - o2[0];});
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			System.out.println(now[0]);
		}
	}
}

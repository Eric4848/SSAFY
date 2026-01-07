package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj2304 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return b[1] - a[1];});
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			pq.add(new int[] {L, H});
		}
		int[] largest = pq.poll();
		int r = largest[0];
		int l = largest[0];
		int space = largest[1];
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			if(curr[0] < l) {
				space += (l - curr[0]) * curr[1];
				l = curr[0];
			}
			else if(r < curr[0]) {
				space += (curr[0] - r) * curr[1];
				r = curr[0];
			}
		}
		System.out.println(space);
	}
}

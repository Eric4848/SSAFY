package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1202 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[0] - b[0];});
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		PriorityQueue<Integer> weight = new PriorityQueue<Integer>();
		for(int i = 0; i < K; i++) {
			weight.add(Integer.parseInt(br.readLine()));
		}
		
		Long answer = 0L;
		
		PriorityQueue<Integer> values = new PriorityQueue<Integer>((a, b) -> {return b - a;});
		
		for(int i = 0; i < K; i++) {
			while(!pq.isEmpty() && pq.peek()[0] <= weight.peek()) {
				values.add(pq.poll()[1]);
			}
			weight.poll();
			
			if(!values.isEmpty()) answer += values.poll();
		}
		System.out.println(answer);
	}
}

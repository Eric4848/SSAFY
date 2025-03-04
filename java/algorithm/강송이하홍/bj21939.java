package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj21939 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<int[]> minpq = new PriorityQueue<int[]>((a, b) -> {
			if(a[1] == b[1])
				return a[0] - b[0];
			return a[1] - b[1];
			});
		PriorityQueue<int[]> maxpq = new PriorityQueue<int[]>((a, b) -> {
			if(b[1] == a[1])
				return b[0] - a[0];
			return b[1] - a[1];
		});
		Map<Integer, Integer> problems = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			maxpq.add(new int[] {P, L});
			minpq.add(new int[] {P, L});
			problems.put(P, L);
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch (order) {
			case "add":
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				maxpq.add(new int[] {P, L});
				minpq.add(new int[] {P, L});
				problems.put(P, L);
				break;
			
			case "recommend":
				int x = Integer.parseInt(st.nextToken());
				if(x == -1) {
					while(!problems.containsKey(minpq.peek()[0]) || problems.get(minpq.peek()[0]) != minpq.peek()[1])
						minpq.poll();
					System.out.println(minpq.peek()[0]);
				}
				else {
					while(!problems.containsKey(maxpq.peek()[0])  || problems.get(maxpq.peek()[0]) != maxpq.peek()[1])
						maxpq.poll();
					System.out.println(maxpq.peek()[0]);
				}
				break;
			
			case "solved":
				int p = Integer.parseInt(st.nextToken());
				problems.remove(p);
				break;
			}
		}
	}
}

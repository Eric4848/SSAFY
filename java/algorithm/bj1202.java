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
		
		PriorityQueue<int[]> jewels = new PriorityQueue<int[]>((a, b) -> {
			return a[0] - b[0];
		});
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels.add(new int[] {M, V});
		}
		
		PriorityQueue<Integer> bags = new PriorityQueue<Integer>();
		for(int i = 0; i < K; i++) {
			int bag = Integer.parseInt(br.readLine());
			bags.add(bag);
		}
		
		Long answer = 0L;
		
		PriorityQueue<Integer> steelables = new PriorityQueue<Integer>((a, b) -> {return b - a;});
		for(int i = 0; i < K; i++) {
			int carry = bags.poll();
			while(!jewels.isEmpty() && jewels.peek()[0] <= carry) {
				steelables.add(jewels.poll()[1]);
			}
			if(!steelables.isEmpty())
				answer += steelables.poll();
		}
		System.out.println(answer);
	}
}

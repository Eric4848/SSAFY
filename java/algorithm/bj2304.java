import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj2304 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pillars = new PriorityQueue<int[]>((a, b) -> {return b[1] - a[1];});
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			pillars.add(new int[] {L, H});
		}
		
		int[] center = pillars.poll();
		int right = center[0];
		int left = center[0];
		int answer = center[1];
		while(!pillars.isEmpty()) {
			int[] curr = pillars.poll();
			if(curr[0] < left) {
				answer += curr[1] * (left - curr[0]);
				left = curr[0];
			}
			else if(right < curr[0]) {
				answer += curr[1] * (curr[0] - right);
				right = curr[0];
			}
		}
		System.out.println(answer);
	}
}

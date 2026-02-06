import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj24042 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<long[]>[] crosses = new List[N];
		for(int i = 0; i < N; i++)
			crosses[i] = new LinkedList<>();
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			crosses[A].add(new long[] {B, i});
			crosses[B].add(new long[] {A, i});
		}
		long[] times = new long[N];
		Arrays.fill(times, Long.MAX_VALUE);
		times[0] = 0L;
		PriorityQueue<long[]> q = new PriorityQueue<long[]>((a, b) -> {
			return (int) (a[1] - b[1]);
			});
		q.add(new long[] {0, 0});
		while(!q.isEmpty()) {
			long[] curr = q.poll();
			long loc = curr[0];
			long time = curr[1];
            if(loc == N-1)
                break;
			for(long[] next : crosses[(int) loc]) {
				long nxt = next[0];
				long eta = next[1];
				if(eta == 0) continue;
				long diff = eta - (time % M);
				long nxtTime = time + diff;
				if(diff < 0)
					nxtTime += M;
				if(nxtTime < times[(int) nxt]) {
					times[(int) nxt] = nxtTime;
					q.add(new long[] {nxt, nxtTime});
				}
			}
		}
		System.out.println(times[N-1]);
	}
}

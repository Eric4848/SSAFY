package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1516 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] req = new int[N+1];
		int[] times = new int[N+1];
		int[] dp = new int[N+1];
		
		List<Integer>[] nxts = new LinkedList[N+1];
		for(int i = 1; i<= N; i++) {
			nxts[i] = new LinkedList<Integer>();
		}
		
		bp : for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int pre = Integer.parseInt(st.nextToken());
				if(pre == -1)
					continue bp;
				req[i]++;
				nxts[pre].add(i);
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(req[i] == 0) {
				q.add(i);
				dp[i] = times[i];
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int nxt : nxts[now]) {
				req[nxt]--;
				dp[nxt] = Math.max(dp[nxt], dp[now] + times[nxt]);
				if(req[nxt] == 0)
					q.add(nxt);
			}
		}
		
		for(int i = 1; i <= N; i++)
			System.out.println(dp[i]);
	}
}
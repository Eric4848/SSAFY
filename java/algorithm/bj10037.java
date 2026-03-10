import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj10037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] pastures = new int[N];
		ArrayList<Integer>[] paths = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			paths[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			paths[a].add(b);
			paths[b].add(a);
		}
		Arrays.fill(pastures, -1);
		Queue<Integer> q = new LinkedList<>();
		int answer = 0;
		for(int start = 0; start < N; start++) {
			if(pastures[start] != -1) continue; 
			int c0 = 0;
			int c1 = 0;
			q.add(start);
			pastures[start] = 0;
			while(!q.isEmpty()) {
				int l = q.size();
				
				for(int i = 0; i < l; i++) {
					int curr = q.poll();
					
					if(pastures[curr] == 0)
						c0++;
					else
						c1++;
					
					int color = (pastures[curr] + 1) % 2;
					for(int nxt : paths[curr]) {
						if(pastures[nxt] != -1 && pastures[nxt] != color) {
							System.out.println(-1);
							return;
						}
						if(pastures[nxt] != -1) continue;
						pastures[nxt] = color;
						q.add(nxt);
					}
				}
			}
			answer += Math.max(c0, c1);
		}
		System.out.println(answer);
	}
}

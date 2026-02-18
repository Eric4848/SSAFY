import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1976 {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parents = new int[N];
		int[] plans = new int[M];
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				int able = Integer.parseInt(st.nextToken());
				if(able == 1)
					union(r, c);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			plans[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		String answer = "YES";
		for(int i = 1; i < M; i++) {
			if(find(plans[i]) != find(plans[i-1])) {
				answer = "NO";
				break;
			}
		}
		
		System.out.println(answer);
	}
	
	static int find(int n) {
		int parent = parents[n];
		if(parent != n)
			parent = find(parent);
		return parents[n] = parent;
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa < pb)
			parents[pb] = pa;
		else
			parents[pa] = pb;
	}
}

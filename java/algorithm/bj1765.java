import java.io.*;
import java.util.*;

public class bj1765 {
	static int[] groups;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		groups = new int[N+1];
		int[] enemies = new int[N+1];
		for(int i = 1; i <= N; i++) {
			groups[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String relation = st.nextToken();
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			if(relation.equals("F"))
				union(p, q);
			else {
				if(enemies[p] != 0) union(enemies[p], q);
				else enemies[p] = q;
				
				if(enemies[q] != 0) union(enemies[q], p);
				else enemies[q] = p;
			}
		}
		
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			if(i == groups[i]) answer++;
		}
		System.out.println(answer);
	}
	
	static int find(int n) {	
		if(n == groups[n]) return n;
		return groups[n] = find(groups[n]);
	}
	
	static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A < B)
			groups[b] = A;
		else
			groups[a] = B;
	}
}

//public class bj1765 {
//	static int N, M;
//	static int[] groups;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		N = Integer.parseInt(br.readLine());
//		M = Integer.parseInt(br.readLine());
//		groups = new int[N];
//		List<Integer>[] friends = new LinkedList[N];
//		List<Integer>[] enemies = new LinkedList[N];
//		for(int i = 0; i < N; i++) {
//			groups[i] = i;
//			friends[i] = new LinkedList<>();
//			enemies[i] = new LinkedList<>();
//		}
//		
//		for(int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			String relation = st.nextToken();
//			int p = Integer.parseInt(st.nextToken())-1;
//			int q = Integer.parseInt(st.nextToken())-1;
//			if (relation.equals("F")) {
//				friends[p].add(q);
//				friends[q].add(p);
//			}
//			else {
//				enemies[p].add(q);
//				enemies[q].add(p);				
//			}
//		}
//		
//		for(int i = 0; i < N; i++) {
//			if(i != groups[i]) continue;
//			Queue<Integer> q = new LinkedList<>();
//			for(int f : friends[i])
//				q.add(f);
//			while(!q.isEmpty()) {
//				int curr = q.poll();
//				if(find(i) == find(curr)) continue;
//				union(i, curr);
//				for(int nf : friends[curr])
//					q.add(nf);
//			}
//			
//			for(int e : enemies[i]) {
//				q.add(e);
//			}
//			
//			while(!q.isEmpty()) {
//				int curr = q.poll();
//				for(int ne : enemies[curr])
//					union(i, ne);
//			}
//		}
//		
//		Set<Integer> set = new HashSet<>();
//		for(int i = 0; i < N; i++) {
//			set.add(groups[i]);
//		}
//		System.out.println(set.size());
//	}
//	
//	static int find(int n) {
//		int group = groups[n];
//		if(group != n) 
//			group = find(group);
//		return group;
//	}
//	
//	static void union(int a, int b) {
//		int A = find(a);
//		int B = find(b);
//		if(A < B)
//			groups[b] = A;
//		else
//			groups[a] = B;
//	}
//}

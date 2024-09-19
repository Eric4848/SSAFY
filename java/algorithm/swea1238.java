import java.io.*;
import java.util.*;

public class swea1238 {
    static Set<Integer>[] graphs;
    static int answer, maxD;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // Initialize variables for each test case
            visited = new boolean[101];
            graphs = new HashSet[101];
            for(int i = 1; i <= 100; i++) {
                graphs[i] = new HashSet<>();
            }
            
            int L = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < L / 2; i++) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graphs[s].add(e);
            }
            
            // Reset for each test case
            answer = 0;
            maxD = 0;
            
            // Start DFS
            dfs(start, 0);
            
            // Output the result
            System.out.println("#" + tc + " " + answer);
        }
    }

    static void dfs(int now, int depth) {
        // Update the farthest node if needed
        if(maxD < depth) {
            answer = now;
            maxD = depth;
        } else if(maxD == depth) {
            answer = Math.max(now, answer);
        }
        
        // Visit the next nodes
        for(int nxt : graphs[now]) {
            if(!visited[nxt]) {
                visited[nxt] = true;
                dfs(nxt, depth + 1);
            }
        }
    }
}


//public class swea1238 {
//	static Set<Integer>[] graphs;
//	static int answer, maxD;
//	static boolean[] visited;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		for(int tc = 1; tc <= 10; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			visited = new boolean[101];
//			graphs = new HashSet[101];
//			for(int i = 1; i <= 100; i++) {
//				graphs[i] = new HashSet<Integer>();
//			}
//			
//			int L = Integer.parseInt(st.nextToken());
//			int start = Integer.parseInt(st.nextToken());
//			st = new StringTokenizer(br.readLine());
//			for(int i = 0; i < L / 2; i++) {
//				int s = Integer.parseInt(st.nextToken());
//				int e = Integer.parseInt(st.nextToken());
//				graphs[s].add(e);
//			}
//			
//			answer = 0;
//			maxD = 0;
//			visited[start] = true;
//			dfs(start, 0);
//			System.out.println("#" + tc + " " + answer);
//		}
//	}
//	static void dfs(int now, int depth) {
//		if(maxD < depth) {
//			answer = now;
//			maxD = depth;
//			System.out.println(answer + ", " + maxD);
//		}
//		
//		else if(maxD == depth) {
//			answer = Math.max(now, answer);
//			System.out.println(now + ", " + answer + ", " + maxD);
//		}
//		
//		System.out.println(graphs[now]);
//		for(int nxt : graphs[now]) {
//			if(!visited[nxt]) {
//				visited[nxt] = true;
//				dfs(nxt, depth+1);
//			}
//		}
//	}
//}


//public class swea1238 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		for(int tc = 1; tc <= 10; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			boolean[] is_visit = new boolean[101];
//			Set<Integer>[] graphs = new HashSet[101];
//			for(int i = 0; i <= 100; i++) {
//				graphs[i] = new HashSet<Integer>();
//			}
//			
//			Deque<int[]> bfs = new ArrayDeque<int[]>();
//			int L = Integer.parseInt(st.nextToken());
//			int[] conds = {Integer.parseInt(st.nextToken()), 0};
//			bfs.add(conds);
//			st = new StringTokenizer(br.readLine());
//			for(int i = 0; i < L / 2; i++) {
//				int s = Integer.parseInt(st.nextToken());
//				int e = Integer.parseInt(st.nextToken());
//				graphs[s].add(e);
//			}
//			
//			int answer = 0;
//			int depth = 0;
//			while(!bfs.isEmpty()) {
//				int[] nows = bfs.pollFirst();
//				int now = nows[0];
//				int d = nows[1];
//				is_visit[now] = true;
//				if(depth < d) {
//					depth = d;
//					answer = now;
//				} else if(depth == d) {
//					answer = Math.max(answer, now);
//				}
//				
//				for(int nxt : graphs[now]) {
//					if(!is_visit[nxt]) {
//						int[] nxts = {nxt, d+1};
//						bfs.add(nxts);
//					}
//				}
//			}
//			System.out.println("#" + tc + " " + answer);
//		}
//	}
//}

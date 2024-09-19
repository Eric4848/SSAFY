
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class graphs implements Comparable<graphs>{
	long dist;
	int nxt;
	
	graphs(long dist, int nxt) {
		this.dist = dist;
		this.nxt = nxt;
	}
	
	@Override
	public int compareTo(graphs o) {
		return Long.compare(this.dist, o.dist);
	}
}
public class swea1251 {
    static long[][] dists;
    static boolean[] is_visit;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<graphs> heap;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            dists = new long[N][N];
            is_visit = new boolean[N];
            long[] xLocs = new long[N];
            long[] yLocs = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int idx = 0; idx < N; idx++) {
                xLocs[idx] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int idx = 0; idx < N; idx++) {
                yLocs[idx] = Long.parseLong(st.nextToken());
            }
            double tax = Double.parseDouble(br.readLine());
            for(int s = 0; s < N-1; s++) {
                for(int e = s; e < N; e++) {
                    long dist = Math.round(Math.pow(xLocs[s] - xLocs[e], 2) + Math.pow(yLocs[s] - yLocs[e], 2));
                    dists[s][e] = dist;
                    dists[e][s] = dist;
                }
            }
            answer = 0;
            heap = new PriorityQueue<>();
            heap.add(new graphs(0, 0));
            int cnt = 0;
            while(!heap.isEmpty()) {
            	graphs now = heap.poll();
            	if(!is_visit[now.nxt]) {
            		is_visit[now.nxt] = true;
            		answer += now.dist;
            		if(++cnt == N) break;
            		for(int i = 0; i < N; i++) {
            			if(!is_visit[i])
            				heap.add(new graphs(dists[now.nxt][i], i));
            		}
            	}
            }
            answer = Math.round(answer * tax);
            System.out.println("#" + tc + " " + answer);
        }
    }
}
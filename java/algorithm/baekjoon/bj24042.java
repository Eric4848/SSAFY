package baekjoon;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class bj24042 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		boolean[] ables = new boolean[N+1];
//		ables[1] = true;
//		List<int[]> cycles = new ArrayList<int[]>();
//		for(int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			cycles.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
//		}
//		int time = 0;
//		while(true) {
//			if(ables[N]) {
//				System.out.println(time);
//				break;
//			}
//			int[] cycle = cycles.get(time % M);
//			if(ables[cycle[0]] && !ables[cycle[1]])
//				ables[cycle[1]] = true;
//			if(ables[cycle[1]] && !ables[cycle[0]])
//				ables[cycle[0]] = true;
//			time++;
//		}
//	}
//}


import java.io.*;
import java.util.*;

public class bj24042 {
    static class Node implements Comparable<Node> {
        int position;
        long time;

        Node(int position, long time) {
            this.position = position;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(new int[]{B, i + 1});
            graph.get(B).add(new int[]{A, i + 1});
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int pos = current.position;
            long time = current.time;

            if (time > dist[pos]) continue;

            for (int[] neighbor : graph.get(pos)) {
                int nextPos = neighbor[0];
                int signalTime = neighbor[1];

                long waitTime = (signalTime - (time % M) + M) % M;
                long nextTime = time + waitTime + 1;

                if (nextTime < dist[nextPos]) {
                    dist[nextPos] = nextTime;
                    pq.add(new Node(nextPos, nextTime));
                }
            }
        }

        System.out.println(dist[N]-1);
    }
}


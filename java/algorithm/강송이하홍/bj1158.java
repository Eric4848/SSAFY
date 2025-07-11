package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		while(!q.isEmpty()) {
			for(int i = 1; i < K; i++) {
				q.add(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		int L = sb.length();
		sb.delete(L-2, L);
		sb.append('>');
		System.out.println(sb);
	}
}

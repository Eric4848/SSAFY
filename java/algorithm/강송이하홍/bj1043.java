package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1043 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] is_knowns = new boolean[N+1];
		Queue<Integer> knowns = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int i = 0; i < T; i++) {
			int person = Integer.parseInt(st.nextToken());
			is_knowns[person] = true;
			knowns.add(person);
		}
		
		List<Integer>[] participates = new ArrayList[M];		// 각 파티별 참여자
		List<Integer>[] partis = new ArrayList[N+1];	// 참여자별 참가하는 파티
		for(int i = 1; i <= N; i++) {
			partis[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			participates[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				int participant = Integer.parseInt(st.nextToken());
				participates[i].add(participant);
				partis[participant].add(i);
			}
		}
		
		boolean[] is_liable = new boolean[M];
		Arrays.fill(is_liable, true);
		
		while(!knowns.isEmpty()) {
			int person = knowns.poll();
			for(int party : partis[person]) {
				if(is_liable[party]) {
					is_liable[party] = false;
					for(int participate : participates[party]) {
						if(!is_knowns[participate]) {
							is_knowns[participate] = true;
							knowns.add(participate);
						}
					}
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i < M; i++) {
			if(is_liable[i]) answer++;
		}
		
		System.out.println(answer);
	}
}

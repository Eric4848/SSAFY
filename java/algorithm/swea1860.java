import java.util.*;
import java.io.*;

public class swea1860 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int[] nums = new int[N];
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st2.nextToken());
			}
			Arrays.sort(nums);
			int cnt = 0;
			boolean is_able = true;
			for(int num : nums) {
				int boong = (num / M) * K - cnt;
				if(boong < 1) {
					is_able = false;
					break;
				}
				cnt++;
			}
			if(is_able) {
				System.out.println("#" + tc + " Possible");
			} else {
				System.out.println("#" + tc + " Impossible");				
			}
		}
	}
}
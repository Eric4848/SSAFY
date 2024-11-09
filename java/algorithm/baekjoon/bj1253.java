package baekjoon;

import java.util.*;

public class bj1253 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] nums = new long[N];
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextLong();
		}
		Arrays.sort(nums);
		int answer = 0;
		if(2 < N) {
			for(int i = 0; i < N; i++) {
				long target = nums[i];
				int h = 0;
				int t = N-1;
				while(h < t) {
					if(h == i) {
						h++;
						continue;
					}
					if(t == i) {
						t--;
						continue;
					}
					
					long sum = nums[h] + nums[t];
					if(sum == target) {
						answer++;
						break;
					} else if(sum < target) {
						h++;
					} else {
						t--;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] nums = new int[N];
//		for(int i = 0; i < N; i++) {
//			 nums[i] = sc.nextInt();
//		}
//		Arrays.sort(nums);
//		int answer = 0;
//		cp:for(int c = 2; c < N; c++) {
//			for(int b = 1; b < c; b++) {
//				for(int a = 0; a < b; a++) {
//					if(nums[a]+nums[b] == nums[c]) {
//						answer++;
//						continue cp;
//					}
//				}
//			}
//		}
//		System.out.println(answer);
//	}
//}

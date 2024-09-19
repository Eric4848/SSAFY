package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//public class bj2309 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int[] nums = new int[9];
//		int total = 0;
//		for(int i= 0; i < 9; i++) {
//			nums[i] = sc.nextInt();
//			total += nums[i];
//		}
//		total -= 100;
//		Arrays.sort(nums);
//		bp: for(int i = 0; i < 8; i++) {
//			int tmp = nums[i];
//			for(int j = i + 1; j < 9; j++) {
//				if(tmp + nums[j] == total) {
//					for(int k = 0; k < 9; k++) {
//						if(k == i || k == j)
//							continue;
//						System.out.println(nums[k]);
//					}
//					break bp;
//				}
//			}
//		}
//	}
//}


public class bj2309 {
	static int[] nums;
	static int total;
	static int[] idxs = new int[3];
	static int pointer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nums = new int[9];
		total = 0;
		for(int i= 0; i < 9; i++) {
			nums[i] = sc.nextInt();
			total += nums[i];
		}
		total -= 100;
		Arrays.sort(nums);
		dfs(0, 0);
	}
	
	static void dfs(int idx, int sum) {
		if(pointer == 2) {
			if(sum == total) {
				int ii = 0;
				for(int i = 0; i < 9; i++) {
					if(i == idxs[ii]) {
						ii++;
						continue;
					}
					System.out.println(nums[i]);
				}
				System.exit(0);
			}
			return;
		}
		if(idx == 9) return;
		idxs[pointer++] = idx;
		dfs(idx + 1, sum + nums[idx]);
		pointer--;
		dfs(idx + 1, sum);
	}
}

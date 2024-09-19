package algo1;

import java.util.Arrays;

public class quicksort {
	static int[] nums = {85, 23, 14, 75, 32, 12, 95, 43};
	static int N = nums.length;
	public static void main(String[] args) {
		System.out.println(Arrays.toString(nums));
		quickSort(0, N-1);
		System.out.println(Arrays.toString(nums));
	}
	static void quickSort(int left, int right) {
		if(left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	
	static int partition(int left, int right) {
		int L = left+1;
		int R = right;
		int pivot = nums[left];
		while(L <= R) {
			if(L <= R && nums[L] <= pivot) L++;
			if(nums[R] > pivot) R--;
			if(L < R) {
				int tmp = nums[L];
				nums[L] = nums[R];
				nums[R] = tmp;
			}
		}
		int tmp = nums[left];
		nums[left] = nums[R];
		nums[R] = tmp;
		return R;
	}
}

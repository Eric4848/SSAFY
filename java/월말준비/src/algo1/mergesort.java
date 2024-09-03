package algo1;

import java.util.Arrays;

public class mergesort {
	static int[] nums = {85, 23, 14, 75, 32, 12, 95, 43};
	static int N = nums.length;
	static int[] tmp = new int[N];
	public static void main(String[] args) {
		System.out.println(Arrays.toString(nums));
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(nums));
	}
	
	static void mergeSort(int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		while(L != mid+1 && R != right+1) {
			if(nums[L] < nums[R])
				tmp[idx++] = nums[L++];
			else
				tmp[idx++] = nums[R++];
		}
		for(; L <= mid; L++)
			tmp[idx++] = nums[L++];
		for(; R <= right; R++)
			tmp[idx++] = nums[R++];
		
		for(int i = left; i <= right; i++)
			nums[i] = tmp[i];
	}
}

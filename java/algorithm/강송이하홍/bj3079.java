package 강송이하홍;

import java.util.Scanner;

public class bj3079 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Long M = sc.nextLong();
		int[] desks = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			desks[i] = sc.nextInt();
			max = Math.max(max, desks[i]);
		}
		Long left = 1L;
		Long right = max * M;
		while(left <= right) {
			Long mid = (left + right) / 2;
			Long cnt = 0L;
			for(int desk : desks) {
				cnt += mid / desk;
				if(M < cnt) break;
			}
			
			if(cnt < M) {
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		
		System.out.println(left);
	}
}

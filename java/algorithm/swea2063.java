import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class swea2063 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N;
		N=sc.nextInt();
//		ArrayList list = new ArrayList();
//		
//		for(int i = 0; i < N; i++) {
//			list.add(sc.nextInt());
//		}
//		Collections.sort(list);
//		int mid = N / 2;
//		System.out.println(list.get(mid));
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		int mid = N / 2;
		System.out.println(nums[mid]);
		
	}

}

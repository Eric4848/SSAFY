import java.util.Scanner;

public class swea1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int[] nums = new int[8];
			for(int i = 0; i < 8; i++) {
				nums[i] = sc.nextInt();
			}
			int idx = 0;
			int cnt = 1;
			while(0 < nums[idx] - cnt) {
				nums[idx] -= cnt++;
				if(cnt == 6)
					cnt = 1;
				idx = (idx + 1) % 8;
			}
			nums[idx] = 0;
			idx = (idx + 1) % 8;
			System.out.print("#" + tc + " ");
			for(int i = idx; i < 8; i++) {
				System.out.print(nums[i] + " ");
			}
			for(int i = 0; i < idx; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
		}
	}
}

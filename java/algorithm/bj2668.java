import java.util.Scanner;

public class bj2668 {
	static int N;
	static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N+1];
		for(int i = 1; i <= N; i++) {
			nums[i] = sc.nextInt();
		}
		boolean[] choosed = new boolean[N+1];
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			if(!choosed[i]) {
				if(search(i)) {
					int choose = i;
					while(!choosed[choose]) {
						choosed[choose] = true;
						choose = nums[choose];
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
		for(int i = 1; i <= N; i++) {
			if(choosed[i])
				System.out.println(i);
		}
	}
	
	static boolean search(int n) {
		boolean[] checked = new boolean[N+1];
		checked[n] = true;
		int nxt = nums[n];
		while(!checked[nxt]) {
			checked[nxt] = true;
			nxt = nums[nxt];
		}
		
		if(n == nxt)
			return true;
		
		return false;
	}
}

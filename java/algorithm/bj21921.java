import java.util.Scanner;

public class bj21921 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int maximum = 0;
		int cnt = 1;
		int[] visitors = new int[N];
		
		for(int i = 0; i < N; i++) {
			visitors[i] = sc.nextInt();
		}
		
		for(int i = 0; i < X; i++) {
			maximum += visitors[i];
		}
		
		int total = maximum;
		for(int i = X; i < N; i++) {
			int nxt = total + visitors[i] - visitors[i-X];
			if(maximum < nxt) {
				maximum = nxt;
				cnt = 1;
			}
			else if(maximum == nxt) {
				cnt++;
			}
			total = nxt;
		}
		
		if(maximum == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(maximum);
			System.out.println(cnt);
		}
	}
}

import java.util.Scanner;

public class bj19941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] eatens = new boolean[N];
		String S = sc.next();
		int answer = 0;
		for(int i = 0; i < N; i++) {
			if(S.charAt(i) == 'P') {
				for(int d = -K; d <= K; d++) {
					int ni = i + d;
					if(ni < 0 || N <= ni) continue;
					if(S.charAt(ni) == 'H' && !eatens[ni]) {
						eatens[ni] = true;
						answer++;
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}
}

import java.util.Scanner;

public class swea1946 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[] alphs = new String[N];
			int[] cnts = new int[N];
			for(int i = 0; i < N; i++) {
				alphs[i] = sc.next();
				cnts[i] = sc.nextInt();
			}
			System.out.println("#" + tc);
			int idx = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < cnts[i]; j++) {
					System.out.print(alphs[i]);
					idx += 1;
					if(idx == 10) {
						idx = 0;
						System.out.println();
					}
				}
			}
			System.out.println();
		}

	}
}
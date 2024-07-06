import java.util.Scanner;

public class swea1989 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T;
		T = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 1; tc <= T; tc++) {
			int answer = 1;
			String s = sc.next();
			int L = s.length();
			for (int idx = 0; idx < L / 2; idx++) {
				if(!s.substring(idx, idx+1).equals(s.substring(L-1-idx, L-idx))) {
					answer = 0;
					continue;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}

	}

}

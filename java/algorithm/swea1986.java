import java.util.Scanner;

public class swea1986 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
						
			int answer = 0;
			
			for(int num = 1; num <= N; num++) {
				
				if(num % 2 == 1) {
					answer += num;
				} else {
					answer -= num;
				}
				
			}
			
			System.out.println("#" + tc + " " + answer);
			
		}
	
	}
	
}

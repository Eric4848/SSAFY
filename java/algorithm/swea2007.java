import java.util.Scanner;

public class swea2007 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			
			String alphs = sc.next();
			
			for(int i = 1; i <= 10; i++) {
				if(alphs.substring(0, i).equals(alphs.substring(i, 2*i))) {
					System.out.println("#"+tc+" "+i);
					break;
				}
			}
		}

	}

}

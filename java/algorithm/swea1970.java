import java.util.Scanner;

public class swea1970 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) { 
			int changes = sc.nextInt();
			int[] answers = new int[8];
			int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			
			for(int i = 0; i < 8; i++) {
				int able = changes / moneys[i];
				answers[i] = able;
				changes -= able * moneys[i];
			}
			System.out.println("#" + tc);
			for(int i = 0; i < 8; i++) {
				System.out.print(answers[i]+" ");
			}
			System.out.println();
		}
	}
}
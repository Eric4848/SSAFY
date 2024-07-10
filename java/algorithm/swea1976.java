import java.util.Scanner;

public class swea1976 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int time1, time2, min1, min2;
			time1 = sc.nextInt();
			min1 = sc.nextInt();
			time2 = sc.nextInt();
			min2 = sc.nextInt();
			
			int time = 0;
			int min = min1 + min2;
			if(60 <= min) {
				time += 1;
				min -= 60;
			}
			
			time = time + time1 + time2;
			if(12 <= time) {
				time -= 12;
			}
			System.out.println("#" + tc + " " + time + " " + min);
		}
		
	}

}

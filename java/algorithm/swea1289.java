import java.util.Scanner;

public class swea1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			String nums = sc.next();
			String chk = "0";
			int answer = 0;
			for(int i = 0; i < nums.length(); i++) {
				if(!(nums.substring(i, i+1).equals(chk))){
					answer += 1;
					chk = nums.substring(i, i+1);
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
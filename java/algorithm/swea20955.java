import java.util.Scanner;

public class swea20955 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String origin = sc.next();
			String target = sc.next();
			boolean able = false;
			while(origin.length() <= target.length()) {
				if (target.equals(origin)) {
					able = true;
					break;
				}
				
				if (target.substring(target.length()-1, target.length()).equals("X")) {
					target = target.substring(0, target.length()-1);
				} else {
						target = target.substring(0, target.length() - 1);
						StringBuilder sb = new StringBuilder(target);
						target = sb.reverse().toString();
					}
				}
			System.out.print("#" + tc + " ");
			if(able)
				System.out.println("Yes");
			else {
				System.out.println("No");
			}
		}
	}
}
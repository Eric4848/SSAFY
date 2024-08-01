import java.util.Scanner;

public class swea1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10 ; tc++) {
			int T = sc.nextInt();
			String pattern = sc.next();
			String line = sc.next();
			int pl = pattern.length();
			int ll = line.length();
			int answer = 0;
			for(int i = 0; i <= ll - pl; i++) {
				if(line.substring(i, i + pl).equals(pattern)) {
					answer++;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
import java.util.Scanner;

public class bj1515 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String erased = sc.next();
		int L = erased.length();
		int answer = 0;
		int idx = 0;
		bp: while(++answer < 1000000000) {
			String compare = Integer.toString(answer);
			for(int i = 0; i < compare.length(); i++) {
				if(compare.charAt(i) == erased.charAt(idx)) idx++;
				if(idx == L) break bp;
			}
		}
		System.out.println(answer);
	}
}

import java.util.Scanner;

public class bj2607 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] alphs = new int[26];
		String target = sc.next();
		int tl = target.length();
		for(int i = 0; i < tl; i++) {
			alphs[target.charAt(i) - 'A']++;
		}
		int answer = 0;
		for(int w = 1; w < N; w++) {
			String word = sc.next();
			int[] comps = new int[26];
			int wl = word.length();
			for(int i = 0; i < wl; i++) {
				comps[word.charAt(i) - 'A']++;
			}
			int diff = 0;
			for(int i = 0; i < 26; i++) {
				diff += Math.abs(alphs[i] - comps[i]);
			}
			if(tl == wl && diff <= 2)
				answer++;
			else if(diff < 2)
				answer++;
		}
		System.out.println(answer);
	}
}

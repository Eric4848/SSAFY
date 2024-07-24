import java.util.Scanner;

public class swea1240 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int answer = 0;
			String[] codes = new String[N];
			for(int i = 0; i < N; i++) {
				codes[i] = sc.next();
			}
			bp : for(int r = 0; r < N; r++) {
				if(codes[r].contains("1")) {
					for(int c = M; 0 < c; c--) {
						if(codes[r].substring(c-1, c).equals("1")) {
							int odd = 0;
							int even = 0;
							for(int d = 0; d < 56; d += 7) {
								if(d % 2 == 0)
									even += decode(codes[r], c-d);
								else
									odd += decode(codes[r], c-d);
							}
							if((odd * 3 + even) % 10 == 0)
								answer = odd + even;
							break bp;
						}
					}
				}	
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static int decode(String code, int c) {
		if(code.substring(c-7, c).equals("0001101"))
			return 0;
		else if(code.substring(c-7, c).equals("0011001"))
			return 1;
		else if(code.substring(c-7, c).equals("0010011"))
			return 2;
		else if(code.substring(c-7, c).equals("0111101"))
			return 3;
		else if(code.substring(c-7, c).equals("0100011"))
			return 4;
		else if(code.substring(c-7, c).equals("0110001"))
			return 5;
		else if(code.substring(c-7, c).equals("0101111"))
			return 6;
		else if(code.substring(c-7, c).equals("0111011"))
			return 7;
		else if(code.substring(c-7, c).equals("0110111"))
			return 8;
		else if(code.substring(c-7, c).equals("0001011"))
			return 9;
		return -1;
	}
}
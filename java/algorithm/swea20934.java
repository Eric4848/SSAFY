import java.util.Scanner;

public class swea20934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String tmp = sc.next();
			int K = sc.nextInt();
			String[] states = tmp.split("");
			int loc = -1;
			for(int i = 0; i < 3; i++)
				if(states[i].equals("o"))
					loc = i;
			while(0 < K) {
				if(loc == 0)
					loc = 1;
				else if(loc == 1)
					loc = 0;
				else
					loc = 1;
				K--;
			}
			System.out.println("#" + tc + " " + loc);
		}
	}
}
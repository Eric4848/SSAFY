import java.util.Scanner;

public class bj20310 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int L = S.length();
		boolean[] deleted = new boolean[L];
		int lz = 0;
		int lo = 0;
		for(int i = 0; i < L; i++) {
			if(S.charAt(i) == '0')
				lz++;
			else
				lo++;
		}
		lz /= 2;
		lo /= 2;
		int d = 0;
		int i = 0;
		while(d < lo) {
			if(S.charAt(i) == '1') {
				deleted[i] = true;
				d++;
			}
			i++;
		}
		
		d = 0;
		i = L-1;
		while(d < lz) {
			if(S.charAt(i) == '0') {
				deleted[i] = true;
				d++;
			}
			i--;
		}
		
		for(i = 0; i < L; i++) {
			if(!deleted[i]) {
				System.out.print(S.charAt(i));
			}
		}
	}
}

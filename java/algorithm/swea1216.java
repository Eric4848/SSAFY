import java.util.*;
import java.io.*;

class swea1216 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			String[][] table = new String[100][100];
			for(int r = 0; r <100; r++) {
				table[r] = br.readLine().split("");
			}
			int answer = 1;
			for(int r = 0; r < 100; r++) {
				int c = 0;
				while(c <= 100-answer) {
					for(int d = 100 - c; answer < d ; d--) {
						boolean is_circle = true;
						for(int half = 0; half < d / 2; half++) {
							if(!table[r][c+half].equals(table[r][c+d-1-half])) {
								is_circle = false;
								break;
							}
						}
						if(is_circle) {
							answer = Math.max(answer, d);
						}
					}
					c++;
				}
			}
			
			for(int c = 0; c < 100; c++) {
				int r = 0;
				while(r <= 100-answer) {
					for(int d = 100 - r; answer < d ; d--) {
						boolean is_circle = true;
						for(int half = 0; half < d / 2; half++) {
							if(!table[r+half][c].equals(table[r+d-1-half][c])) {
								is_circle = false;
								break;
							}
						}
						if(is_circle) {
							answer = Math.max(answer, d);
						}
					}
					r++;
				}
			}
			
			System.out.println("#" + T + " " + answer);
		}
	}
}
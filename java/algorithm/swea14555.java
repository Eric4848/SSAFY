import java.util.*;
import java.io.*;

class swea14555
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String fields = br.readLine();
			int L = fields.length();
			int answer = 0;
			for(int i = 0; i < L; i++) {
				if (fields.charAt(i) == '(')
					answer++;
				else if(fields.charAt(i) == ')') {
					answer++;
					if(fields.charAt(i-1) == '(')
						answer--;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}

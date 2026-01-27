import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2179 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		int answer = 0;
		String S = "";
		String T = "";
		for(int i = 0; i < N-1; i++) {
			for(int j = i+1; j < N; j++) {
				int len = compare(words[i], words[j]);
				if(answer < len) {
					answer = len;
					S = words[i];
					T = words[j];
				}
			}
		}
		System.out.println(S);
		System.out.println(T);
	}
	static int compare(String S, String T) {
		int L = Math.min(S.length(), T.length());
		int len = 0;
		for(int i = 0; i < L; i++) {
			if(S.charAt(i) != T.charAt(i))
				break;
			len++;
		}
		return len;   
	}
}

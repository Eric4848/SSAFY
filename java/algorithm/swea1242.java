import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class swea1242 {
	static int i, r;
	static int answer;
	static String[] codes;
	static Set<String> searcheds;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N, M;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			codes = new String[N];
			for(int i = 0; i < N; i++) {
				codes[i] = br.readLine();
			}
			searcheds = new HashSet<String>();
			answer = 0;
			for(r = 0; r < N; r++) {
				i = 0;
				for(; i < M; i++) {
					if(codes[r].charAt(i) != '0') {
						check();
					}
				}
			}
			System.out.println("#" + tc + " ");
		}
	}
	static void check() {
		String chk = "";
		while(codes[r].charAt(i) != '0') {
			chk += codes[r].charAt(i);
			i++;
		}
		
		String code = "";
		for(int i = 0; i < chk.length(); i++) {
			char now = chk.charAt(i);
			int num;
			if(now - '0' < 0 || 10 <= now - '0')
				num = now - 'A' + 10;
			else
				num = now - '0';
			
			String tmp = "";
			while(num != 0) {
				if(num % 2 == 1)
					tmp = "1" + tmp;
				else
					tmp = "0" + tmp;
				
				num /= 2;
			}
			while(tmp.length() < 4){
				tmp = "0" + tmp;
			}
			code += tmp;
		}
		if(searcheds.contains(code))
			return;
		calc(code);
		System.out.println(code);
		System.out.println(code.length());
	}
	
	static void calc(String code) {
		int K = code.length() / 56;
		int idx = code.length()-1;
		while(code.charAt(idx) == '0')
			idx--;
		for(int i = 0; i < 8; i++) {
			String tmp = "";
			for(int j = 0; j < 7 * K; j++) {
				break;
			}
		}
	}
	
//	static void check() {
//		String chk = "";
//		while(codes[r].charAt(i) != '0') {
//			char now = codes[r].charAt(i);
//			int num;
//			if(now - '0' < 0 || 10 <= now - '0')
//				num = now - 'A' + 10;
//			else
//				num = now - '0';
//			
//			String tmp = "";
//			while(num != 0) {
//				if(num % 2 == 1)
//					tmp = "1" + tmp;
//				else
//					tmp = "0" + tmp;
//				
//				num /= 2;
//			}
//			while(tmp.length() < 4){
//				tmp = "0" + tmp;
//			}
//			chk += tmp;
//			i++;
//		}
//		System.out.println(chk);
//		System.out.println(chk.length());
//	}
}

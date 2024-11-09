import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1288_bit {
	static boolean[] is_counted;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			is_counted = new boolean[10];
			int ratio = 1;
			while(true) {
				int now = ratio * N;
				while(0 < now) {
					int rest = now % 10;
					if(!is_counted[rest])
						is_counted[rest] = true;
					now /=10;
				}
				if(is_full()) {
					break;
				}
				ratio++;
			}
			System.out.println("#" + tc + " " + ratio * N);
		}
	}
	static boolean is_full() {
		for(int i = 0; i < 10; i++) {
			if(!is_counted[i]) {
				return false;
			}
		}
		return true;
	}
}

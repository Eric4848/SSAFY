import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj14658 {
	static int L, answer;
	static List<int[]> stars;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		stars = new ArrayList<int[]>();
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			stars.add(new int[] {x, y});
		}
		answer = K;
		for(int[] star1 : stars) {
			for(int[] star2 : stars) {
				calc(star1[0], star2[0]);
			}
		}
		
		System.out.println(answer);
	}
	
	static void calc(int r, int c) {
		int cnt = 0;
		for(int[] star : stars) {
			if(star[0] < r || r + L < star[0] || star[1] < c || c + L < star[1]) cnt++;
		}
		answer = Math.min(cnt, answer);
	}
}

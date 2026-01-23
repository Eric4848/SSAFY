import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] houses = new int[N];
		for(int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);
		
		int left = 0;
		int right = houses[N-1];
		int answer = 0;
		while(left <= right) {
			int diff = (right + left) / 2;
			int cnt = 1;
			int wifi = houses[0];
			for(int i = 1; i < N; i++) {
				int house = houses[i];
				if(diff <= house - wifi) {
					cnt++;
					wifi = house;
				}
			}
			
			if (cnt < C) {
				right = diff - 1;
			}
			else {
				left = diff + 1;
				answer = diff;
			}
		}
		System.out.println(answer);
	}
}	

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19637 {
	static String[] titles;
	static int[] limits;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		titles = new String[N+1];
		limits = new int[N+1];
		limits[0] = -1;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			titles[i] = st.nextToken();
			limits[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < M; i++) {
			int power = Integer.parseInt(br.readLine());
			sb.append(Mesure(power)).append("\n");
		}
		System.out.println(sb);
	}
	
	static String Mesure(int power) {
		int left = 0;
		int right = N;
		while(left < right) {
			int mid = (left + right) / 2;
			int check = limits[mid];
			if(power <= check) {
				right = mid;
			}
			else
				left = mid + 1;
		}
		return titles[left];
	}
}

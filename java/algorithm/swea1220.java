import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] fields = new int[100][100];
			for(int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < 100; c++) {
					fields[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int c = 0; c < 100; c++) {
				int pole = 2;
				for(int r = 0; r < 100; r++) {
					if(fields[r][c] != 0 && fields[r][c] != pole) {
						pole = fields[r][c];
						if(pole == 2) {
							cnt++;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
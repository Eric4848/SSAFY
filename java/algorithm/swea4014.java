import java.util.*;
import java.io.*;

class swea4014
{
    static int N;
    static int X;
    static int[][] fields;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            fields = new int[N][N];
            for(int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++) {
                    fields[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    System.out.print(fields[r][c]);
                }
                System.out.println();
            }
        }
    }
}
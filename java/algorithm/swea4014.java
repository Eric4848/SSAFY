<<<<<<< HEAD
import java.util.*;
import java.io.*;

class swea4014
{
    static int N;
    static int X;
    static int[][] fields;
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4014 {
	static int N;
	static int X;
	static int[][] fields;
>>>>>>> d99f29e93761b72d83cd6cf0d9c30a525ab50fc2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
<<<<<<< HEAD
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
=======
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
			
			int answer = 0;
			
			for(int r = 0; r < N; r++) {
				if(check(fields[r])) answer++;
			}
			for(int c = 0; c < N; c++) {
				int[] line = new int[N];
				for(int r = 0; r < N; r++) {
					line[r] = fields[r][c];
				}
				if(check(line)) answer++;
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	static boolean check(int[] line) {
		boolean[] used = new boolean[N];
		for(int i = 0; i < N-1; i++) {
			if(line[i] != line[i+1]) {
				if(Math.abs(line[i] - line[i+1]) != 1) return false;
				else {
					if(line[i] - line[i+1] == 1) {
						if(N <= i + X) return false;
						for(int j = 1; j <= X; j++) {
							if(line[i+j] != line[i+1] || used[i+j]) return false;
							used[i+j] = true;
						}
					}
					else {
						if(i - X < -1) return false;
						for(int j = 0; j < X; j++) {
							if(line[i-j] != line[i] || used[i-j]) return false;
							used[i-j] = true;
						}
					}
				}
			}
		}
		return true;
	}
}
>>>>>>> d99f29e93761b72d83cd6cf0d9c30a525ab50fc2

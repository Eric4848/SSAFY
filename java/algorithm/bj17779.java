import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17779 {
	static int N;
	static int[][] maps;
	static boolean[][] border;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		maps = new int[N][N];
		int answer = Integer.MAX_VALUE;
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				maps[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		for(int x = 0; x < N-2; x++) {
			for(int y = 0; y < N-2; y++) {
				for(int d1 = 1; d1 < N; d1++) {
					for(int d2 = 1; d2 < N; d2++) {
						if(N <= x + d1 + d2 || y - d1 < 0 || N <= y + d2) continue;
						int[] sum = new int[5];
						border = new boolean[N][N];
						
						for(int i = 0; i <= d1; i++) {
							border[x + i][y - i] = true;
							border[x + d2 + i][y + d2 - i] = true;
						}
						for(int i = 0; i <= d2; i++) {
							border[x + i][y + i] = true;
							border[x + d1 + i][y - d1 + i] = true;
						}
						
//						for (int r = x+1; r < x + d1 + d2; r++) {
//						    // 각 행에서 경계(true)인 두 지점을 찾아서
//						    int left = -1, right = -1;
//						    for (int c = 0; c < N; c++) {
//						        if (border[r][c]) {
//						            if (left == -1) left = c;
//						            else { right = c; break; }
//						        }
//						    }
//						    // left…right 전부 내부(true)로 채움
//						    for (int c = left+1; c < right; c++) {
//						        border[r][c] = true;
//						    }
//						}

						for(int r = x + 1; r < x + d1 + d2; r++) {
							boolean flag = false;
							for(int c = 0; c < N; c++) {
								if(!flag && border[r][c]) { flag = true; } 
								else if(flag && border[r][c]) { // 오른쪽 경계
								  border[r][c] = true;
								  break;
								}
								if(flag) border[r][c] = true;
							}
						}
						
						for(int r = 0; r < N; r++) {
							for(int c = 0; c < N; c++) {
								if(border[r][c])
									sum[4] += maps[r][c];
								else if(r < x + d1 && c <= y)
									sum[0] += maps[r][c];
								else if(r <= x + d2 && y < c)
									sum[1] += maps[r][c];
								else if(x + d1 <= r && c < y - d1 + d2)
									sum[2] += maps[r][c];
								else
									sum[3] += maps[r][c];
							}
						}
						int max = sum[0];
						int min = sum[0];
						for(int i = 1; i < 5; i++) {
							max = Math.max(max, sum[i]);
							min = Math.min(min, sum[i]);
						}
						answer = Math.min(answer, max - min);
					}
				}
			}
		}
		System.out.println(answer);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj17779 {
    static int N;
    static int[][] arr;
    static int totalPeople = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                totalPeople += arr[i][j];
            }
        }

        // solution
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0 || y + d2 >= N) continue;

                        solution(x, y, d1, d2);
                    }
                }
            }
        }

        System.out.println(min);
    }

    static void solution(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[N][N];

        // 경계선 세팅
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int[] peopleSum = new int[5];

        // 1 구역 인구수
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                peopleSum[0] += arr[i][j];
            }
        }

        // 2 구역 인구수
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (border[i][j]) break;
                peopleSum[1] += arr[i][j];
            }
        }

        // 3 구역 인구수
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                peopleSum[2] += arr[i][j];
            }
        }

        // 4 구역 인구수
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                peopleSum[3] += arr[i][j];
            }
        }

        // 5 구역 인구수
        peopleSum[4] = totalPeople;

        for (int i = 0; i < 4; i++) {
            peopleSum[4] -= peopleSum[i];
        }

        // 정렬
        Arrays.sort(peopleSum);

        // 최대 - 최소
        min = Math.min(min, peopleSum[4] - peopleSum[0]);
    }
	
	
	
//	static int N;
//	static int[][] maps;
//	static boolean[][] border;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		maps = new int[N][N];
//		int answer = Integer.MAX_VALUE;
//		for(int r = 0; r < N; r++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for(int c = 0; c < N; c++) {
//				maps[r][c] = Integer.parseInt(st.nextToken());
//			}
//		}
//		for(int x = 0; x < N-2; x++) {
//			for(int y = 0; y < N-2; y++) {
//				for(int d1 = 1; d1 < N; d1++) {
//					for(int d2 = 1; d2 < N; d2++) {
//						if(N <= x + d1 + d2 || y - d1 < 0 || N <= y + d2) continue;
//						int[] sum = new int[5];
//						border = new boolean[N][N];
//						
//						for(int i = 0; i <= d1; i++) {
//							border[x + i][y - i] = true;
//							border[x + d2 + i][y + d2 - i] = true;
//						}
//						for(int i = 0; i <= d2; i++) {
//							border[x + i][y + i] = true;
//							border[x + d1 + i][y - d1 + i] = true;
//						}
//
//						for(int r = x + 1; r < x + d1 + d2; r++) {
//							boolean flag = false;
//							for(int c = 0; c < N; c++) {
//								if(!flag && border[r][c]) flag = true;
//								else if(flag && border[r][c]) {
//								  border[r][c] = true;
//								  break;
//								}
//								if(flag) border[r][c] = true;
//							}
//						}
//						
//						for(int r = 0; r < N; r++) {
//							for(int c = 0; c < N; c++) {
//								if(border[r][c])
//									sum[4] += maps[r][c];
//								else if(r < x + d1 && c <= y)
//									sum[0] += maps[r][c];
//								else if(r <= x + d2 && y < c)
//									sum[1] += maps[r][c];
//								else if(x + d1 <= r && c < y - d1 + d2)
//									sum[2] += maps[r][c];
//								else
//									sum[3] += maps[r][c];
//							}
//						}
//						int max = sum[0];
//						int min = sum[0];
//						for(int i = 1; i < 5; i++) {
//							max = Math.max(max, sum[i]);
//							min = Math.min(min, sum[i]);
//						}
//						answer = Math.min(answer, max - min);
//					}
//				}
//			}
//		}
//		System.out.println(answer);
//	}
}
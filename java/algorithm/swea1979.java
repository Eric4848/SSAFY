import java.util.Scanner;

public class swea1979 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N, K;
            N = sc.nextInt();
            K = sc.nextInt();
            int[][] puzzle = new int[N][N];
            for(int r = 0; r < N; r++){
             	for(int c = 0; c < N; c++) {
                	puzzle[r][c] = sc.nextInt();
                }
            }
            int answer = 0;
            
            for(int r = 0; r < N; r++){
             	for(int c = 0; c < N; c++) {
                	if(puzzle[r][c] == 1) {
                		if (0 < c) {
                			if(puzzle[r][c-1] == 1) {
                				continue;
                			}
                		}
                        int chk = 1;
                    	for(int d = 1; d < K; d++) {
                            if (c + d == N) {
                                chk = 0;
                                break;
                            }else if (puzzle[r][c+d] == 0) {
                                chk = 0;
                                break;
                            }
                        }
                        if (c + K < N) {
                            if(puzzle[r][c+K] == 1){
                            	chk = 0;
                            }
                        }
                        answer += chk;
                    }
                }
            }
            
            for(int c = 0; c < N; c++) {
            	for(int r = 0; r < N; r++) {
            		if(puzzle[r][c] == 1) {
            			if (0 < r) {
            				if(puzzle[r-1][c] == 1) {
            					continue;
            				}
            			}
	                    int chk = 1;
	                	for(int d = 1; d < K; d++) {
	                        if (r + d == N) {
	                            chk = 0;
	                            break;
	                        }else if (puzzle[r+d][c] == 0) {
	                            chk = 0;
	                            break;
	                        }
	                    }
	                    if (r + K < N) {
	                        if(puzzle[r+K][c] == 1){
	                        	chk = 0;
	                        }
	                    }
	                    answer += chk;
            		}
            	}
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
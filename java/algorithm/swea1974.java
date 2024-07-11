import java.util.Scanner;

public class swea1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++) {
			int[][] tables = new int[9][9];
            for(int r = 0; r < 9; r++){
                for(int c = 0; c < 9; c++){
                    tables[r][c] = sc.nextInt();
                }
            }
            int answer = 1;
            for(int r = 0; r < 9; r++){
                boolean[] is_used = new boolean[9];
            	for(int c = 0; c < 9; c++) {
            		if(is_used[tables[r][c]-1]) {
            			answer = 0;
            			break;
            		}
                    is_used[tables[r][c]-1] = true;
                }
            }
            
            for(int c = 0; c < 9; c++){
                boolean[] is_used = new boolean[9];
            	for(int r = 0; r < 9; r++) {
            		if(is_used[tables[r][c]-1]) {
            			answer = 0;
            			break;
            		}
                    is_used[tables[r][c]-1] = true;
                }
            }
            
            for(int hr = 0; hr < 9; hr += 3) {
            	for(int hc = 0; hc < 9; hc += 3) {
            		boolean[] is_used = new boolean[9];
            		for(int dr = 0; dr < 3; dr++) {
            			for(int dc = 0; dc < 3; dc++) {
            				if(is_used[tables[hr + dr][hc + dc] - 1]) {
            					answer = 0;
            					break;
            				}
            				is_used[tables[hr + dr][hc + dc] - 1] = true;
            			}
            		}
            	}
            }
            
            System.out.println("#" + tc + " " + answer);
		}
	}
}
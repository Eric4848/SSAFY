import java.util.Scanner;

public class swea2805 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
         	int N = sc.nextInt();
            int[][] farms = new int[N][N];
            for(int r = 0; r < N; r++){
            	String values = sc.next();
            	String[] vals = values.split("");
                for(int c = 0; c < N; c++){
                	farms[r][c] = Integer.parseInt(vals[c]);
                }
            }
            int mid = N / 2;
            int answer = 0;
            for(int c = 0; c < N; c++){
                answer += farms[mid][c];
            }
            for(int d = 1; d <= mid; d++) {
                for(int c = d; c < N-d; c++) {
                	answer += farms[mid + d][c];
                	answer += farms[mid - d][c];
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}

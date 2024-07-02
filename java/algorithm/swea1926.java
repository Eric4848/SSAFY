import java.util.Scanner;

public class swea1926 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N;
		N=sc.nextInt();
        int[] actions = new int[N];
        for(int i = 0; i< N; i++) {
            int cnt = 0;
            int num = i+1;
            while(0 < num) {
                if (num % 10 == 3 | num % 10 == 6 | num % 10 == 9){
                    cnt += 1;
                }
                num /= 10;
            }
            if (cnt == 0) {
            	System.out.print(i+1);
            } else {
            	for(int j = 0; j < cnt; j++) {
            		System.out.print("-");
            	}
            }
            System.out.print(" ");
		}
	}
}
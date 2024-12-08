import java.util.Scanner;

public class swea11446 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt();
            Long M = sc.nextLong();
            Long[] candies = new Long[N];
            Long l = 0L;
            Long r = 0L;
            for(int i = 0; i < N; i++) {
            	candies[i] = sc.nextLong();
                r = Math.max(r, candies[i]);
            }
            Long cnt;
            Long mid;
            while(l <= r) {
            	mid = (l + r) / 2;
            	if(mid == 0) {
            		r = 0L;
            		break;
            	}
                cnt = 0L;
                for(int i = 0; i < N; i++) {
                 	cnt += candies[i] / mid;   
                }
                
                if(M <= cnt) 
                    l = mid+1;
                else
                    r = mid-1;
            }

            System.out.println("#" + test_case + " " + r);
		}
	}
}

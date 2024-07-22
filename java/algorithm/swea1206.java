import java.util.Scanner;

public class swea1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int[] heights = new int[N];
			for(int i = 0; i < N; i++) {
				heights[i] = sc.nextInt();
			}
			int answer = 0;
			for(int i = 2; i < N-2; i++) {
				int maxHeight = 0;
				for(int j = 1; j < 3; j++) {
					if(maxHeight < heights[i-j])
						maxHeight = heights[i-j];
					if(maxHeight < heights[i+j])
						maxHeight = heights[i+j];
				}
				if(0 < heights[i] - maxHeight)
					answer += heights[i] - maxHeight;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}

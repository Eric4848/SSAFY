import java.util.*;
import java.io.*;

class swea10761
{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String now = "F";
			int locO = 1;
			int locB = 1;
			int movableTime = 0;
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			for(int i = 0; i < N; i++) {
				String color = st.nextToken();
				int target = Integer.parseInt(st.nextToken());
				if(!now.equals(color)) {
					int time;
					if(color.equals("B")) {
						time = Math.max(0, Math.abs(target - locB) - movableTime) + 1;
						locB = target;
					}
					else {
						time = Math.max(0, Math.abs(target - locO) - movableTime) + 1;
						locO = target;
					}
					answer += time;
					movableTime = time;
					now = color;
				} else {
					int time=  0;
					if(color.equals("B")) {
						time = Math.max(0, Math.abs(target - locB)) + 1;
						locB = target;
					}
					else {
						time = Math.max(0, Math.abs(target - locO)) + 1;
						locO = target;
					}
					answer += time;
					movableTime += time;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class bj14719 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int H = Integer.parseInt(st.nextToken());
//        int W = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        int[] heights = new int[W];
//
//        for (int i = 0; i < W; i++) {
//            heights[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int[] leftMax = new int[W];
//        int[] rightMax = new int[W];
//
//        leftMax[0] = heights[0];
//        for (int w = 1; w < W; w++) {
//            leftMax[w] = Math.max(leftMax[w - 1], heights[w]);
//        }
//
//        rightMax[W - 1] = heights[W - 1];
//        for (int w = W - 2; 0 <= w; w--) {
//            rightMax[w] = Math.max(rightMax[w + 1], heights[w]);
//        }
//
//        int answer = 0;
//
//        for (int w = 0; w < W; w++) {
//            int waterHeight = Math.min(leftMax[w], rightMax[w]) - heights[w];
//            if (waterHeight > 0) {
//                answer += waterHeight;
//            }
//        }
//
//        System.out.println(answer);
//    }
//}


package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] heights = new int[W];
		for(int i = 0; i < W; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for(int h = 0; h < H; h++) {
			int cnt = 0;
			boolean addable = false;
			for(int w = 0; w < W; w++) {
				if(h < heights[w]) {
					if(!addable) {
						addable = true;
						cnt = 0;
						continue;
					}
					answer += cnt;
					cnt = 0;
				} else 
					cnt++;
			}
		}
		System.out.println(answer);
	}
}

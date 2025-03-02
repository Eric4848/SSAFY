package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj19236 {
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] shark = {0, 0};
	static int[][] fishes = new int[4][4];
	static int[][] directions = new int[4][4];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int r = 0; r < 4; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 4; c++) {
				fishes[r][c] = Integer.parseInt(st.nextToken());
				directions[r][c] = Integer.parseInt(st.nextToken())-1;
			}
		}
		for(int r = 0; r < 4; r++) {
			System.out.println(Arrays.toString(fishes[r]));
		}
	}
	
	int[][] move(int[][] fields, int r, int c) {
		
		return null;
	}
}

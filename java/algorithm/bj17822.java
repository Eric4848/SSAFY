import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj17822 {
	static int N, M, T;
	static int[][] boards;
	static int[] heads;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		boards = new int[N+1][M];
		heads = new int[N+1];
		int answer = 0;
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				boards[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		for(int turn = 0; turn < T; turn++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			turn(x, d, k);
			calc();
		}
		for(int r = 1; r <= N; r++) {
			for(int c = 0; c < M; c++) {
				if(boards[r][c] == -1) continue;
				answer += boards[r][c];
			}
		}
		System.out.println(answer);
	}
	static void turn(int x, int d, int k) {
		int dir = d == 0 ? -1 : 1;
		for(int r = x; r <= N; r+= x) {
			heads[r] = (heads[r] + M + dir * k) % M;
		}
	}
	
	static void calc() {
		int[][] tmp = new int[N+1][M];
		for(int r = 1; r <= N; r++) {
			Arrays.fill(tmp[r], -2);
		}
		int total = 0;
		int cnt = 0;
		boolean same = false;
		for(int r = 1; r <= N; r++) {
			for(int c = 0; c < M; c++) {
				if(boards[r][(c+heads[r]) % M] == -1) continue;
				total += boards[r][(c+heads[r]) % M];
				cnt++;
				if(boards[r][(c+heads[r]) % M] == boards[r][(c+heads[r]+1) % M]) {
					same = true;
					tmp[r][(c+heads[r]) % M] = -1;
					tmp[r][(c+heads[r]+1) % M] = -1;
				}
				if(boards[r][(c+heads[r]) % M] == boards[r][(c+heads[r]+M-1) % M]) {
					same = true;
					tmp[r][(c+heads[r]) % M] = -1;
					tmp[r][(c+heads[r]+M-1) % M] = -1;
				}
				if(1 < r && boards[r][(c+heads[r]) % M] == boards[r-1][(c+heads[r-1]) % M]) {
					same = true;
					tmp[r][(c+heads[r]) % M] = -1;
					tmp[r-1][(c+heads[r-1]) % M] = -1;
				}
				if(r < N && boards[r][(c+heads[r]) % M] == boards[r+1][(c+heads[r+1]) % M]) {
					same = true;
					tmp[r][(c+heads[r]) % M] = -1;
					tmp[r+1][(c+heads[r+1]) % M] = -1;
				}
			}
		}
		if(!same) {
			for(int r = 1; r <= N; r++) {
				for(int c = 0; c < M; c++) {
					if(boards[r][c] == -1) continue;
					if(boards[r][c] * cnt < total) {
						tmp[r][c] = boards[r][c]+1;
					}
					else if(total < boards[r][c] * cnt){
						tmp[r][c] = boards[r][c]-1;
					}
				}
			}
		}
		for(int r = 1; r <= N; r++) {
			for(int c = 0; c < M; c++) {
				if(tmp[r][c] != -2) {
					boards[r][c] = tmp[r][c];
				}
			}
		}
	}
}



//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class bj17822 {
//	static int N, M, T;
//	static int[][] boards;
//	static int[] heads;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		T = Integer.parseInt(st.nextToken());
//		boards = new int[N+1][M];
//		heads = new int[N+1];
//		int answer = 0;
//		for(int r = 1; r <= N; r++) {
//			st = new StringTokenizer(br.readLine());
//			for(int c = 0; c < M; c++) {
//				boards[r][c] = Integer.parseInt(st.nextToken());
//			}
//		}
//		for(int turn = 0; turn < T; turn++) {
//			st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int d = Integer.parseInt(st.nextToken());
//			int k = Integer.parseInt(st.nextToken());
//			turn(x, d, k);
////			for(int r = 1; r <= N; r++) {
////				for(int c = 0; c < M; c++) {
////					System.out.print(boards[r][(c + heads[r]) % M] + " ");
////				}
////				System.out.println();
////			}
//			calc();
//			for(int r = 1; r <= N; r++) {
//				for(int c = 0; c < M; c++) {
//					System.out.print(boards[r][(c + heads[r]) % M] + " ");
//				}
//				System.out.println();
//			}
//		}
//		for(int r = 1; r <= N; r++) {
//			for(int c = 0; c < M; c++) {
//				if(boards[r][c] == -1) continue;
//				answer += boards[r][c];
//			}
//		}
//		System.out.println(answer);
//	}
//	static void turn(int x, int d, int k) {
//		int dir = d == 0 ? -1 : 1;
//		for(int r = x; r <= N; r+= x) {
//			heads[r] = (heads[r] + M + dir * k) % M;
//		}
//	}
//	
//	static void calc() {
//		int[][] tmp = new int[N+1][M];
//		for(int r = 1; r <= N; r++) {
//			Arrays.fill(tmp[r], -2);
//		}
//		for(int r = 1; r <= N; r++) {
//			boolean same = false;
//			int total = 0;
//			int cnt = 0;
//			for(int c = 0; c < M; c++) {
//				if(boards[r][(c+heads[r]) % M] == -1) continue;
//				total += boards[r][(c+heads[r]) % M];
//				cnt++;
//				if(boards[r][(c+heads[r]) % M] == boards[r][(c+heads[r]+1) % M]) {
//					same = true;
//					tmp[r][(c+heads[r]) % M] = -1;
//					tmp[r][(c+heads[r]+1) % M] = -1;
//				}
//				if(boards[r][(c+heads[r]) % M] == boards[r][(c+heads[r]+M-1) % M]) {
//					same = true;
//					tmp[r][(c+heads[r]) % M] = -1;
//					tmp[r][(c+heads[r]+M-1) % M] = -1;
//				}
//				if(1 < r && boards[r][(c+heads[r]) % M] == boards[r-1][(c+heads[r-1]) % M]) {
//					same = true;
//					tmp[r][(c+heads[r]) % M] = -1;
//					tmp[r-1][(c+heads[r-1]) % M] = -1;
//				}
//				if(r < N && boards[r][(c+heads[r]) % M] == boards[r+1][(c+heads[r+1]) % M]) {
//					same = true;
//					tmp[r][(c+heads[r]) % M] = -1;
//					tmp[r+1][(c+heads[r+1]) % M] = -1;
//				}
//			}
//			if(total == 0) continue;
//			if(!same) {
////				System.out.println("----" + r + "----");
//				for(int c = 0; c < M; c++) {
//					if(boards[r][c] == -1) continue;
//					if(boards[r][c] * cnt < total) {
//						tmp[r][c] = boards[r][c]+1;
//					}
//					else if(total < boards[r][c] * cnt){
//						tmp[r][c] = boards[r][c]-1;
//					}
//				}
//			}
//		}
//		for(int r = 1; r <= N; r++) {
//			for(int c = 0; c < M; c++) {
//				if(tmp[r][c] != -2) {
////					System.out.println(r + ", " + c);
//					boards[r][c] = tmp[r][c];
//				}
//			}
//		}
//	}
//}

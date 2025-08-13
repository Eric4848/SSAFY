import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj20061 {
	static boolean[][] gboard = new boolean[6][4];
	static boolean[][] bboard = new boolean[6][4];
	static int score = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			block(gboard, y, t);
			check(gboard);
			int tmp = 1;
			if(1 < t) {
				if(t == 2)
					tmp = 3;
				else
					tmp = 2;
			}
			block(bboard, x, tmp);
			check(bboard);
		}
		int block = 0;
		for(int r = 2; r < 6; r++) {
			for(int c = 0; c < 4; c++) {
				if(gboard[r][c]) block++;
				if(bboard[r][c]) block++;
			}
		}
		System.out.println(score);
		System.out.println(block);
	}
	
	static void block(boolean[][] board, int loc, int position) {
		int row = 5;
		switch(position) {
		case 1:
			for(int r = 2; r < 6; r++) {
				if(board[r][loc]) {
					row = r-1;
					break;
				}
			}
			board[row][loc] = true;
			break;
		case 2:
			for(int r = 2; r < 6; r++) {
				if(board[r][loc] || board[r][loc+1]) {
					row = r-1;
					break;
				}
			}
			board[row][loc] = true;
			board[row][loc+1] = true;
			break;
		case 3:
			for(int r = 2; r < 6; r++) {
				if(board[r][loc]) {
					row = r-1;
					break;
				}
			}
			board[row][loc] = true;
			board[row-1][loc] = true;
			break;
		}
	}
	
	static void check(boolean[][] board) {
		for(int r = 5; 2 <= r; r--) {
			boolean bomb = true;
			for(int c = 0; c < 4; c++)
				if(!board[r][c]) {
					bomb = false;
					break;
				}
			if(bomb) {
				score++;
				Arrays.fill(board[r], false);
			}
		}
		for(int r = 2; r < 6; r++) {
			boolean movable = true;
			for(int c = 0; c < 4; c++) {
				if(board[r][c]) {
					movable = false;
					break;
				}
			}
			if(movable) {
				for(int row = r; 0 < row; row--) {
					board[row] = Arrays.copyOf(board[row-1], 4);
				}
				Arrays.fill(board[0], false);
			}
		}
		int move = 0;
		for(int r = 0; r < 2; r++) {
			for(int c = 0; c < 4; c++) {
				if(board[r][c]) {
					move++;
					break;
				}
			}
		}
		
		if(0 < move) {
			for(int r = 5; 2 <= r; r--) {
				board[r] = Arrays.copyOf(board[r-move], 4);
			}
		}
		for(int r = 0; r < 2; r++) {
			Arrays.fill(board[r], false);
		}
	}
}



//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class bj20061 {
//	static boolean[][] gboard = new boolean[6][4];
//	static boolean[][] bboard = new boolean[6][4];
//	static int score = 0;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		int block = 0;
//		int N = Integer.parseInt(br.readLine());
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			int t = Integer.parseInt(st.nextToken());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			block(gboard, y, t);
//			check(gboard);
//			int tmp = 1;
//			if(1 < t) {
//				if(t == 2)
//					tmp = 3;
//				else
//					tmp = 2;
//			}
//			block(bboard, x, tmp);
//			check(bboard);
//		}
//		for(int r = 2; r < 6; r++) {
//			for(int c =0; c < 4; c++) {
//				if(gboard[r][c]) block++;
//				if(bboard[r][c]) block++;
//			}
//		}
//		System.out.println(score);
//		System.out.println(block);
//	}
//	
//	static void block(boolean[][] board, int loc, int position) {
//		int row = 5;
//		switch(position) {
//		case 1:
//			for(int r = 2; r < 6; r++) {
//				if(board[r][loc]) {
//					row = r-1;
//					break;
//				}
//			}
//			board[row][loc] = true;
//			break;
//		case 2:
//			for(int r = 2; r < 6; r++) {
//				if(board[r][loc] || board[r][loc+1]) {
//					row = r-1;
//					break;
//				}
//			}
//			board[row][loc] = true;
//			board[row][loc+1] = true;
//			break;
//		case 3:
//			for(int r = 2; r < 6; r++) {
//				if(board[r][loc]) {
//					row = r-1;
//					if(board.equals(gboard))
////						System.out.println(loc + ", " + position);
//					break;
//				}
//			}
//			board[row][loc] = true;
//			board[row-1][loc] = true;
//			break;
//		}
//	}
//	
//	static void check(boolean[][] board) {
//		for(int r = 5; 2 <= r; r--) {
//			boolean bomb = true;
//			for(int c = 0; c < 4; c++)
//				if(!board[r][c]) {
//					bomb = false;
//					break;
//				}
//			if(bomb) {
//				score++;
//				Arrays.fill(board[r], false);
//			}
//		}
//		for(int r = 2; r < 6; r++) {
//			boolean movable = true;
//			for(int c = 0; c < 4; c++) {
//				if(!board[r][c]) {
//					movable = false;
//					break;
//				}
//			}
//			if(movable) {
//				for(int row = r; 0 < row; r--) {
//					board[r] = Arrays.copyOf(board[r-1], 4);
//				}
//				Arrays.fill(board[0], false);
//			}
//		}
//		int move = 0;
//		for(int r = 0; r < 2; r++) {
//			for(int c = 0; c < 4; c++) {
//				if(board[r][c]) {
//					move++;
//					break;
//				}
//			}
//		}
//		
//		if(0 < move) {
//			for(int r = 5; 2 <= r; r--) {
//				board[r] = Arrays.copyOf(board[r-move], 4);
//			}
//		}
//		for(int r = 0; r < move; r++) {
//			Arrays.fill(board[r], false);
//		}
//	}
//}
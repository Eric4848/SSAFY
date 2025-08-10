import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17825 {
	static class Piece{
		int line;
		int loc;
		Piece(int line, int loc){
			this.line = line;
			this.loc = loc;
		}
	}
	
	static class Case{
		Piece[] pieces;
		int score;
		int moved;
		Case(Piece[] pieces, int score, int moved){
			this.pieces = pieces;
			this.score = score;
			this.moved = moved;
		}
	}
	
	static int[][] scores = new int[4][];
	static Queue<Case> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		scores[1] = new int[] {10, 13, 16, 19, 25, 30, 35, 40};
		scores[2] = new int[] {20, 22, 24, 25, 30, 35, 40};
		scores[3] = new int[] {30, 28, 27, 26, 25, 30, 35, 40};
		q = new LinkedList<>();
		Piece[] pieces = new Piece[4];
		q.add(new Case(pieces, 0, 0));
		for(int i = 0; i < 10; i++) {
			System.out.println("----------------");
			System.out.println(i);
			System.out.println("----------------");
			move(Integer.parseInt(st.nextToken()));
		}
		int answer = 0;
		while(!q.isEmpty()) {
			Case curr = q.poll();
//			System.out.println(curr.score + ", " + curr.moved);
			answer = Math.max(answer, curr.score);
		}
		System.out.println(answer);
	}
	
	static void move(int move) {
		int L = q.size();
		for(int i = 0; i < L; i++) {
			Case curr = q.poll();
			int score = curr.score;
			int moved = curr.moved;
			if(moved < 4) {
				boolean able = true;
				for(int j = 0; j < moved; j++) {
					if(move == 5 && curr.pieces[j].line == 1 && curr.pieces[j].loc == 0)
						able = false;
					if(curr.pieces[j].line == 0 && curr.pieces[j].loc == move)
						able = false;
				}
				if(able) {
					Piece[] tmp = Arrays.copyOf(curr.pieces, 4);
					tmp[moved] = new Piece(0, move);
					if(move == 5)
						tmp[moved] = new Piece(1, 0);
					q.add(new Case(tmp, score + 2 * move, moved + 1));
				}
			}
			for(int j = 0; j < moved; j++) {
				Piece piece = curr.pieces[j];
				int nline = piece.line;
				int nl = piece.loc + move;
				System.out.println("Start : "+ nline + ", " + piece.loc);
				if(piece.line == 0 && 20 < nl)
					continue;
				else if(piece.line == 2 && 6 < nl)
					continue;
				else if(7 < nl)
					continue;
				
				boolean able = true;
				if(nline == 0 && nl % 5 == 0)
					if(nl / 5 != 4) {
						nline = nl / 5;
						nl = 0;
					}
				for(int k = 0; k < moved; k++) {
					Piece check = curr.pieces[k];
					if(nline == check.line && nl == check.loc)
						able = false;
				}
				if(able) {
					Piece[] tmp = Arrays.copyOf(curr.pieces, 4);
					tmp[j] = new Piece(nline, nl);
					int added;
					if(nline == 0)
						added = 2 * nl;
					else
						added = scores[nline][nl];
					System.out.println("ADD : " + added);
					q.add(new Case(tmp, score + added, moved));
				}
			}
		}
	}
}

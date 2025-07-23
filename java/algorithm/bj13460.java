import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13460 {
	static class Beed {
		int[] red = new int[2];
		int[] blue = new int[2];
		int move;
	}
	static char[][] boards;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boards = new char[N][];
		for(int r = 0; r < N; r++) {
			boards[r] = br.readLine().toCharArray();
		}
		
		Beed beed = new Beed();
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(boards[r][c] == 'R') {
					beed.red = new int[] {r, c};
					boards[r][c] = '.';
				}
				if(boards[r][c] == 'B') {
					beed.blue = new int[] {r, c};
					boards[r][c] = '.';
				}
			}
		}
		
		Queue<Beed> q = new LinkedList<>();
		q.add(beed);
		
		while(!q.isEmpty()) {
			Beed curr = q.poll();
			if(curr.move == 10) {
				System.out.println(-1);
				break;
			}
			boards[curr.red[0]][curr.red[1]] = 'R';
			boards[curr.blue[0]][curr.blue[1]] = 'B';
			int[] red = new int[] {curr.red[0], curr.red[1]};
			int[] blue = new int[] {curr.blue[0], curr.blue[1]};
			boolean red_out = false;
			boolean blue_out = false;
			
//			System.out.println("----------------------");
//			for(int r = 0; r < N; r++) {
//				for(int c = 0; c < M; c++) {
//					System.out.print(boards[r][c]);
//				}
//				System.out.println();
//			}
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(boards[r][c] == 'R') {
						boards[r][c] = '.';
						int[] rd = move(r, c, -1, 0);
						if(boards[rd[0]][rd[1]] == 'O') {
							red_out = true;
							continue;
						}
						boards[rd[0]][rd[1]] = 'R';
						red = rd;
//						System.out.println("r1");
					}
					if(boards[r][c] == 'B') {
						boards[r][c] = '.';
						int[] bd = move(r, c, -1, 0);
						if(boards[bd[0]][bd[1]] == 'O') {
							blue_out = true;
							continue;
						}
						boards[bd[0]][bd[1]] = 'B';
						blue = bd;
//						System.out.println("b1");
					}
				}
			}
			if(!blue_out) {
				if(red_out) {
					System.out.println(curr.move+1);
					break;
				}
				Beed next = new Beed();
				next.red = red;
				next.blue = blue;
				next.move = curr.move + 1;
				q.add(next);
			}
			
			boards[red[0]][red[1]] = '.';
			boards[blue[0]][blue[1]] = '.';
			boards[curr.red[0]][curr.red[1]] = 'R';
			boards[curr.blue[0]][curr.blue[1]] = 'B';
			red_out = false;
			blue_out = false;
			for(int r = N-1; 0 <= r; r--) {
				for(int c = 0; c < M; c++) {
					if(boards[r][c] == 'R') {
						boards[r][c] = '.';
						int[] rd = move(r, c, 1, 0);
						if(boards[rd[0]][rd[1]] == 'O') {
							red_out = true;
							continue;
						}
						boards[rd[0]][rd[1]] = 'R';
						red = rd;
					}
					if(boards[r][c] == 'B') {
						boards[r][c] = '.';
						int[] bd = move(r, c, 1, 0);
						if(boards[bd[0]][bd[1]] == 'O') {
							blue_out = true;
							continue;
						}
						boards[bd[0]][bd[1]] = 'B';
						blue = bd;
					}
				}
			}

			if(!blue_out) {
				if(red_out) {
					System.out.println(curr.move+1);
					break;
				}
				Beed next = new Beed();
				next.red = red;
				next.blue = blue;
				next.move = curr.move + 1;
				q.add(next);
			}
			
			
			boards[red[0]][red[1]] = '.';
			boards[blue[0]][blue[1]] = '.';
			boards[curr.red[0]][curr.red[1]] = 'R';
			boards[curr.blue[0]][curr.blue[1]] = 'B';
			red_out = false;
			blue_out = false;
			for(int c = 0; c < M; c++) {
				for(int r = 0; r < N; r++) {
					if(boards[r][c] == 'R') {
						boards[r][c] = '.';
						int[] rd = move(r, c, 0, -1);
						if(boards[rd[0]][rd[1]] == 'O') {
							red_out = true;
							continue;
						}
						boards[rd[0]][rd[1]] = 'R';
						red = rd;
					}
					if(boards[r][c] == 'B') {
						boards[r][c] = '.';
						int[] bd = move(r, c, 0, -1);
						if(boards[bd[0]][bd[1]] == 'O') {
							blue_out = true;
							continue;
						}
						boards[bd[0]][bd[1]] = 'B';
						blue = bd;
					}
				}
			}
			if(!blue_out) {
				if(red_out) {
					System.out.println(curr.move+1);
					break;
				}
				Beed next = new Beed();
				next.red = red;
				next.blue = blue;
				next.move = curr.move + 1;
				q.add(next);
			}
			
			
			boards[red[0]][red[1]] = '.';
			boards[blue[0]][blue[1]] = '.';
			boards[curr.red[0]][curr.red[1]] = 'R';
			boards[curr.blue[0]][curr.blue[1]] = 'B';
			red_out = false;
			blue_out = false;
			for(int c = M-1; 0 <= c; c--) {
				for(int r = 0; r < N; r++) {
					if(boards[r][c] == 'R') {
						boards[r][c] = '.';
						int[] rd = move(r, c, 0, 1);
//						System.out.println("here " + curr.move + " " + rd[1]);
						if(boards[rd[0]][rd[1]] == 'O') {
							red_out = true;
							continue;
						}
						boards[rd[0]][rd[1]] = 'R';
						red = rd;
					}
					if(boards[r][c] == 'B') {
						boards[r][c] = '.';
						int[] bd = move(r, c, 0, 1);
						if(boards[bd[0]][bd[1]] == 'O') {
							blue_out = true;
							continue;
						}
						boards[bd[0]][bd[1]] = 'B';
						blue = bd;
					}
				}
			}
			
			boards[red[0]][red[1]] = '.';
			boards[blue[0]][blue[1]] = '.';
			if(!blue_out) {
				if(red_out) {
					System.out.println(curr.move+1);
					break;
				}
				Beed next = new Beed();
				next.red = red;
				next.blue = blue;
				next.move = curr.move + 1;
				q.add(next);
			}
		}
	}
	
	static int[] move(int r, int c, int dr, int dc) {
		int nr = r;
		int nc = c;
		while(boards[nr+dr][nc+dc] != '#' && boards[nr+dr][nc+dc] != 'R' && boards[nr+dr][nc+dc] != 'B') {
			nr += dr;
			nc += dc;
			if(boards[nr][nc] == 'O')
				break;
		}
		return new int[] {nr, nc};
	}
}

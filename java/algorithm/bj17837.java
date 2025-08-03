import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17837 {
	static int N, K;
	static int[][] boards;
	static Queue<Integer>[][] stacks;
	static int[][] pieces;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		boards = new int[N][N];
		stacks = new Queue[N][N];
		pieces = new int[K][3];
		int turn = 1;
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				boards[r][c] = Integer.parseInt(st.nextToken());
				stacks[r][c] = new LinkedList<>();
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			pieces[i][0] = r;
			pieces[i][1] = c;
			pieces[i][2] = d;
			stacks[r][c].add(i);
		}
		
		bp: while(turn <= 1000) {
			for(int i = 0; i < K; i++) {
				int r = pieces[i][0];
				int c = pieces[i][1];
				int d = pieces[i][2];
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0) {
					pieces[i][2] = 3;
					nr = r + dr[3];
				}
				if(N <= nr) {
					pieces[i][2] = 2;
					nr = r + dr[2];
				}
				if(nc < 0) {
					pieces[i][2] = 0;
					nc = c + dc[0];
				}
				if(N <= nc) {
					pieces[i][2] = 1;
					nc = c + dc[1];
				}
				
				
				if(boards[nr][nc] == 0) {
					boolean target = false;
					int l = stacks[r][c].size();
					Queue<Integer> curr = stacks[r][c];
					Queue<Integer> tmp = new LinkedList<>();
					for(int j = 0; j < l; j++) {
						int num = curr.poll();
						if(num == i) 
							target = true;
						if(target)
							tmp.add(num);
						else
							curr.add(num);
					}
					while(!tmp.isEmpty()) {
						int moved = tmp.poll();
						pieces[moved][0] = nr;
						pieces[moved][1] = nc;
						stacks[nr][nc].add(moved);
					}
					if(3 < stacks[nr][nc].size())
						break bp;
				}
				
				if(boards[nr][nc] == 1) {
					boolean target = false;
					int l = stacks[r][c].size();
					Queue<Integer> curr = stacks[r][c];
					Stack<Integer> tmp = new Stack<>();
					for(int j = 0; j < l; j++) {
						int num = curr.poll();
						if(num == i) 
							target = true;
						if(target)
							tmp.add(num);
						else
							curr.add(num);
					}
					while(!tmp.isEmpty()) {
						int moved = tmp.pop();
						pieces[moved][0] = nr;
						pieces[moved][1] = nc;
						stacks[nr][nc].add(moved);
					}
					if(3 < stacks[nr][nc].size())
						break bp;
				}
				
				if(boards[nr][nc] == 2) {
					switch (d) {
						case 0:
							d = 1;
							break;
						case 1:
							d = 0;
							break;
						case 2:
							d = 3;
							break;
						case 3:
							d = 2;
							break;
					}
					pieces[i][2] = d;
					nr = r + dr[d];
					nc = c + dc[d];
					if(nr < 0 || N <= nr || nc < 0 || N <= nc) {
						nr = r;
						nc = c;
					}
					if(boards[nr][nc] == 2) {
						continue;
					}
					if(boards[nr][nc] == 0) {
						boolean target = false;
						int l = stacks[r][c].size();
						Queue<Integer> curr = stacks[r][c];
						Queue<Integer> tmp = new LinkedList<>();
						for(int j = 0; j < l; j++) {
							int num = curr.poll();
							if(num == i) 
								target = true;
							if(target)
								tmp.add(num);
							else
								curr.add(num);
						}
						while(!tmp.isEmpty()) {
							int moved = tmp.poll();
							pieces[moved][0] = nr;
							pieces[moved][1] = nc;
							stacks[nr][nc].add(moved);
						}
						if(3 < stacks[nr][nc].size())
							break bp;
					}
					
					if(boards[nr][nc] == 1) {
						boolean target = false;
						int l = stacks[r][c].size();
						Queue<Integer> curr = stacks[r][c];
						Stack<Integer> tmp = new Stack<>();
						for(int j = 0; j < l; j++) {
							int num = curr.poll();
							if(num == i) 
								target = true;
							if(target)
								tmp.add(num);
							else
								curr.add(num);
						}
						while(!tmp.isEmpty()) {
							int moved = tmp.pop();
							pieces[moved][0] = nr;
							pieces[moved][1] = nc;
							stacks[nr][nc].add(moved);
						}
						if(3 < stacks[nr][nc].size())
							break bp;
					}
					if(3 < stacks[nr][nc].size())
						break bp;
				}
			}
			
			turn++;
		}
		
		if(turn == 1001)
			System.out.println(-1);
		else
			System.out.println(turn);
	}
}

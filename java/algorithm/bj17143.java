import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17143 {
	static class Shark {
		int r, c, s, d, z;
		
		Shark(int r, int c, int s, int d, int z){
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static int R, C, M;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	static Shark[][] maps;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Queue<Shark> q = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			q.add(new Shark(r, c, s, d, z));
		}
		int fisher = 0;
		int answer = 0;
		while(fisher < C) {
			maps = new Shark[R][C];
			int l = q.size();
			for(int i = 0; i < l; i++) {
				Shark curr = q.poll();
				maps[curr.r][curr.c] = curr;
			}
			
			for(int r = 0; r < R; r++) {
				if(maps[r][fisher] != null) {
					answer += maps[r][fisher].z;
					maps[r][fisher] = null;
					break;
				}
			}
			
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(maps[r][c] != null) {
						q.add(maps[r][c]);
						maps[r][c] = null;
					}
				}
			}
			
			while(!q.isEmpty()) {
				move(q.poll());
			}
			
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(maps[r][c] != null) {
						q.add(maps[r][c]);
					}
				}
			}
			
			fisher++;
		}
		System.out.println(answer);
	}
	static void move(Shark shark) {
		int r = shark.r;
		int c = shark.c;
		int s = shark.s;
		int d = shark.d;
		int div = d <= 2 ? (R-1) * 2 : (C-1) * 2;
		int speed = s % div;
		for(int i = 0; i < speed; i++) {
			if(r + dr[d] < 0)
				d = 2;
			if(R <= r + dr[d])
				d = 1;
			if(c + dc[d] < 0)
				d = 3;
			if(C <= c + dc[d])
				d = 4;
			r += dr[d];
			c += dc[d];
		}
		if(maps[r][c] != null && maps[r][c].z > shark.z) {
			return;
		}
		maps[r][c] = new Shark(r, c, s, d, shark.z);
	}
}

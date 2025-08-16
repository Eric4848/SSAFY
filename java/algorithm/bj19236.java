import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj19236 {
	static class Fish {
		int size;
		int direction;
		int score;
		
		Fish(int size, int direction) {
			this.size = size;
			this.direction = direction;
		}
	}
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Fish[][] fields = new Fish[4][4];
		for(int r = 0; r < 4; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 4; c++) {
				int size = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken()) - 1;
				fields[r][c] = new Fish(size, direction);
			}
		}
		Fish start = fields[0][0];
		start.score = start.size;
		start.size = 0;
		
		Queue<Fish[][]> q = new LinkedList<>();
		q.add(fields);
		
		while(!q.isEmpty()) {
			Fish[][] curr = q.poll();
			Fish[][] moved = moveFish(curr);
			
			for(int r = 0; r < 4; r++) {
				for(int c = 0; c < 4; c++) {
					if(moved[r][c] != null && moved[r][c].size == 0) {
						answer = Math.max(answer, moved[r][c].score);
						int d = moved[r][c].direction;
						for(int dist = 1; dist < 4; dist++) {
							int nr = r + dr[d] * dist;
							int nc = c + dc[d] * dist;
							if(nr == -1 || nr == 4 || nc == -1 || nc == 4) break;
							if(moved[nr][nc] != null) {
								Fish[][] tmp = deepCopy(moved);
								Fish victim = tmp[nr][nc];
								tmp[r][c].score += victim.size;
								tmp[r][c].direction = victim.direction;
								
								tmp[nr][nc] = tmp[r][c];
								tmp[r][c] = null;
								q.add(tmp);
							}
						}
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}
	
	static Fish[][] moveFish(Fish[][] curr) {
		Fish[][] tmp = deepCopy(curr);
		search: for(int i = 1; i <= 16; i++) {
			for(int r = 0; r < 4; r++) {
				for(int c = 0; c < 4; c++) {
					if(tmp[r][c] != null && tmp[r][c].size == i) {
						int d = tmp[r][c].direction;
						int j = 0;
						while(j < 8) {
							j++;
							int nr = r + dr[d];
							int nc = c + dc[d];
							if(nr == -1 || nr == 4 || nc == -1 || nc == 4 || (tmp[nr][nc] != null && tmp[nr][nc].size == 0)) {
								d = (d + 1) % 8;
								continue;
							}
							Fish to = tmp[nr][nc];
							tmp[nr][nc] = tmp[r][c];
							tmp[nr][nc].direction = d;
							tmp[r][c] = to;
							break;
						}
						continue search;
					}
				}
			}
		}
		return tmp;
	}
	
	static Fish[][] deepCopy(Fish[][] src) {
	    Fish[][] dst = new Fish[4][4];
	    for (int r = 0; r < 4; r++) {
	        for (int c = 0; c < 4; c++) {
	            Fish f = src[r][c];
	            if (f != null) {
	                Fish nf = new Fish(f.size, f.direction); // 새 객체
	                nf.score = f.score;                      // 점수도 복사
	                dst[r][c] = nf;
	            }
	        }
	    }
	    return dst;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20057 {
	// 좌 하 우 상
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	static int[][] sands;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sands = new int[N][N];
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N ;c++) {
				sands[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int r = N / 2;
		int c = N / 2;
		int d = 0;
		int answer = 0;
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;
		int i = 1;
		while(r != 0 || c != 0) {
			answer += move(r, c, d);
			r += dr[d];
			c += dc[d];
			visited[r][c] = true;
			int nr = r + dr[(d + 1) % 4];
			int nc = c + dc[(d + 1) % 4];
			if(!visited[nr][nc])
				d = (d + 1) % 4;
			i++;
		}
		
		System.out.println(answer);
	}
	
	static int move(int r, int c, int d) {
		int out = 0;
		int sand = sands[r + dr[d]][c + dc[d]];
		sands[r + dr[d]][c + dc[d]] = 0;
		int a = sand;
		int nr, nc, gone;
		// x칸
		// 1%
		gone = (int) (sand * 0.01);
		a -= 2 * gone;
		nr = r + dr[(d + 1) % 4];
		nc = c + dc[(d + 1) % 4];
		if(nr < 0 || N <= nr || nc < 0 || N <= nc)
			out += gone;
		else
			sands[nr][nc] += gone;
		nr = r + dr[(d + 3) % 4];
		nc = c + dc[(d + 3) % 4];
		if(nr < 0 || N <= nr || nc < 0 || N <= nc)
			out += gone;
		else
			sands[nr][nc] += gone;
		// y칸
		r += dr[d];
		c += dc[d];
		// 7%
		gone = (int) (sand * 0.07);
		a -= 2 * gone;
		nr = r + dr[(d + 1) % 4];
		nc = c + dc[(d + 1) % 4];
		if(nr < 0 || N <= nr || nc < 0 || N <= nc)
			 out += gone;
		else
			sands[nr][nc] += gone;
		nr = r + dr[(d + 3) % 4];
		nc = c + dc[(d + 3) % 4];
		if(nr < 0 || N <= nr || nc < 0 || N <= nc)
			 out += gone;
		else
			sands[nr][nc] += gone;
		// 2%
		gone = (int) (sand * 0.02);
		a -= 2 * gone;
		nr = r + 2 * dr[(d + 1) % 4];
		nc = c + 2 * dc[(d + 1) % 4];
		if(nr < 0 || N <= nr || nc < 0 || N <= nc)
			out += gone;
		else
			sands[nr][nc] += gone;
		nr = r + 2 * dr[(d + 3) % 4];
		nc = c + 2 * dc[(d + 3) % 4];
		if(nr < 0 || N <= nr || nc < 0 || N <= nc)
			out += gone;
		else
			sands[nr][nc] += gone;
		// a칸
		r += dr[d];
		c += dc[d];
		// 10%
		gone = (int) (sand * 0.1);
		a -= 2 * gone;
		nr = r + dr[(d + 1) % 4];
		nc = c + dc[(d + 1) % 4];
		if(nr < 0 || N <= nr || nc < 0 || N <= nc)
			out += gone;
		else
			sands[nr][nc] += gone;
		nr = r + dr[(d + 3) % 4];
		nc = c + dc[(d + 3) % 4];
		if(nr < 0 || N <= nr || nc < 0 || N <= nc)
			out += gone;
		else
			sands[nr][nc] += gone;
		// 5%
		nr = r + dr[d];
		nc = c + dc[d];
		gone = (int) (sand * 0.05);
		a -= gone;
		if(nr < 0 || N <= nr || nc < 0 || N <= nc)
			out += gone;
		else
			sands[nr][nc] += gone;
		// a계산
		if(r < 0 || N <= r || c < 0 || N <= c)
			out += a;
		else
			sands[r][c] += a;
		
		return out;
	}
}

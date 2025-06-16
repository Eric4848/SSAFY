package 종만북;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class B0ARDC0VER2 {
	static int H, W, R, C;
    static char[][] board;
    static List<List<int[]>> blockRotations = new ArrayList<>();
    static int maxBlocks = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			board = new char[H][];
			for(int r = 0; r < H; r++) {
				board[r] = br.readLine().toCharArray();
			}
			char[][] block = new char[R][];
			for(int r = 0; r < R; r++) {
				block[r] = br.readLine().toCharArray();
			}
			
			blockRotations.clear();
            generateRotations(block);
            maxBlocks = 0;

            dfs(0, 0);
            System.out.println(maxBlocks);
            
		}
	}
	
	static char[][] rotate(char[][] block) {
        int row = block.length;
        int col = block[0].length;
        char[][] newBlock = new char[col][row];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                newBlock[j][row - 1 - i] = block[i][j];
        return newBlock;
    }
	
	static void generateRotations(char[][] block) {
        Set<String> seen = new HashSet<>();
        for (int rot = 0; rot < 4; rot++) {
            List<int[]> shape = new ArrayList<>();
            int minR = R, minC = C;

            for (int i = 0; i < block.length; i++) {
                for (int j = 0; j < block[0].length; j++) {
                    if (block[i][j] == '#') {
                        shape.add(new int[]{i, j});
                        minR = Math.min(minR, i);
                        minC = Math.min(minC, j);
                    }
                }
            }

            List<int[]> normShape = new ArrayList<>();
            for (int[] coord : shape) {
                normShape.add(new int[]{coord[0] - minR, coord[1] - minC});
            }

            normShape.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

            StringBuilder key = new StringBuilder();
            for (int[] p : normShape) {
                key.append(p[0]).append(",").append(p[1]).append(";");
            }
            if (!seen.contains(key.toString())) {
                seen.add(key.toString());
                blockRotations.add(normShape);
            }

            block = rotate(block);
        }
    }
	
	static void dfs(int r, int count) {
        int[] pos = findNext();
        if (pos == null) {
            maxBlocks = Math.max(maxBlocks, count);
            return;
        }

        int x = pos[0];
        int y = pos[1];

//        for (List<int[]> shape : blockRotations) {
//            if (canPlace(shape, x, y)) {
//                place(shape, x, y, '#');
//                dfs(r + 1, count + 1);
//                place(shape, x, y, '.');
//            }
//        }
        for (List<int[]> shape : blockRotations) {
	        for (int[] p : shape) {
	            int baseR = x - p[0];
	            int baseC = y - p[1];
	            if (canPlace(shape, baseR, baseC)) {
	                place(shape, baseR, baseC, '#');
	                dfs(r + 1, count + 1);
	                place(shape, baseR, baseC, '.');
	            }
    	    }
    	}

        board[x][y] = '#';
        dfs(r + 1, count);
        board[x][y] = '.';
    }
	
	static int[] findNext() {
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                if (board[i][j] == '.')
                    return new int[]{i, j};
        return null;
    }
	
	static boolean canPlace(List<int[]> shape, int x, int y) {
        for (int[] p : shape) {
            int nx = x + p[0];
            int ny = y + p[1];
            if (nx < 0 || ny < 0 || nx >= H || ny >= W || board[nx][ny] != '.')
                return false;
        }
        return true;
    }

    static void place(List<int[]> shape, int x, int y, char mark) {
        for (int[] p : shape) {
            int nx = x + p[0];
            int ny = y + p[1];
            board[nx][ny] = mark;
        }
    }
}

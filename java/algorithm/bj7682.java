import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj7682 {
	static char[][] boards = new char[3][3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int X;
		int O;
		int dot;
		while(true) {
			line = br.readLine();
			if(line.equals("end"))
				break;
			X = 0;
			O = 0;
			dot = 0;
			for(int r = 0; r < 3; r++) {
				for(int c = 0; c < 3; c++) {
					char state = line.charAt(3 * r + c);
					boards[r][c] = state;
					if(state == 'X') X++;
					else if(state == 'O') O++;
					else dot++;
				}
			}
			
			int diff = X - O;
			if(diff < 0 || 1 < diff) {
				System.out.println("invalid");
				continue;
			}
			
			if(check('X')) {
				if(diff == 1 && !check('O'))
					System.out.println("valid");
				else
					System.out.println("invalid");
				continue;
			}
			
			if(check('O')) {
				if(diff == 0)
					System.out.println("valid");
				else
					System.out.println("invalid");
				continue;
			}
			
			if(dot == 0)
				System.out.println("valid");
			else
				System.out.println("invalid");
		}
	}
	static boolean check(char target) {
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				if(boards[r][c] != target) break;
				if(c == 2) return true;
			}
		}
		
		for(int c = 0; c < 3; c++) {
			for(int r = 0; r < 3; r++) {
				if(boards[r][c] != target) break;
				if(r == 2) return true;
			}
		}
		
		if(boards[1][1] == target) {
			if(boards[0][0] == target && boards[2][2] == target) return true;
			if(boards[0][2] == target && boards[2][0] == target) return true;
		}
		
		return false;
	}
}

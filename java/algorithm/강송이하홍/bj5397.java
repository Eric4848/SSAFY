package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < TC; tc++) {
			char[] pws = br.readLine().toCharArray();
			Stack<Character> answer = new Stack<Character>();
			Stack<Character> stack = new Stack<Character>();
			for(char pw : pws) {
				switch (pw) {
				case '<': 
					if(!answer.isEmpty())
						stack.add(answer.pop());
					break;
				case '>':
					if(!stack.isEmpty())
						answer.add(stack.pop());
					break;
				case '-':
					if(!answer.isEmpty())
						answer.pop();
					break;
				default:
					answer.add(pw);
					break;
				}
			}
			while(!stack.isEmpty())
				answer.add(stack.pop());
			for(char ans : answer)
				System.out.print(ans);
			System.out.println();
		}
	}
}

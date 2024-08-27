import java.util.*;
import java.io.*;

class swea1232
{
	static String[] strs;
	static Stack<Float> stack;
	static int[][] nxts;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			strs = new String[N+1];
			nxts = new int[N+1][2];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int loc = Integer.parseInt(st.nextToken());
				strs[loc] = st.nextToken();
				if(strs[loc].equals("+") || strs[loc].equals("-") || strs[loc].equals("*") || strs[loc].equals("/"))
					for(int j = 0; j < 2; j++) {
						nxts[loc][j] = Integer.parseInt(st.nextToken());
					}
			}
			
			stack = new Stack<>();
			postorder(1);
			System.out.println("#" + tc + " " + (int) Math.floor(stack.pop()));
		}
	}
	static void postorder(int i) {
		if (strs.length <= i)
			return;
		if(nxts[i][0] != 0) {
			postorder(nxts[i][0]);
			postorder(nxts[i][1]);
		}
		
		if (strs[i].equals("+"))
			stack.push(stack.pop() + stack.pop());
		else if(strs[i].equals("*"))
			stack.push(stack.pop() * stack.pop());
		else if(strs[i].equals("-")) {
			float num2 = stack.pop();
			float num1 = stack.pop();
			stack.push(num1 - num2);
		} else if(strs[i].equals("/")) {
			float num2 = stack.pop();
			float num1 = stack.pop();
			stack.push(num1 / num2);
		} else 
			stack.push(Float.parseFloat(strs[i]));
	}
}
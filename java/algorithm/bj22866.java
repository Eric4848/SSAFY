import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj22866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] buildings = new int[N];
		int[] cnts = new int[N];
		int[] locs = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<int[]> stack = new Stack<int[]>();
		stack.add(new int[] {buildings[0], 0});
		for(int i = 1; i < N; i++) {
			while(!stack.isEmpty()) {
				if(buildings[i] < stack.peek()[0]) break;
				stack.pop();
			}
			cnts[i] += stack.size();
			if(!stack.isEmpty())
				locs[i] = stack.peek()[1] + 1;
			stack.add(new int[] {buildings[i], i});
		}
		
		stack = new Stack<int[]>();
		stack.add(new int[] {buildings[N-1], N-1});
		for(int i = N-2; 0 <= i; i--) {
			while(!stack.isEmpty()) {
				if(buildings[i] < stack.peek()[0]) break;
				stack.pop();
			}
			cnts[i] += stack.size();
			if(!stack.isEmpty())
				if(locs[i] == 0 || stack.peek()[1] + 1 - i < i + 2 - locs[i])
					locs[i] = stack.peek()[1] + 1;
			stack.add(new int[] {buildings[i], i});
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(cnts[i]);
			if(0 < cnts[i])
				System.out.print(" " + locs[i]);
			System.out.println();
		}
	}
}

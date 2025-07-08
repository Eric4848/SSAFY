package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj1935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String formula = br.readLine();
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Stack<Double> stack = new Stack<>();
		for(char c : formula.toCharArray()) {
			if(65 <= c && c <= 65 + N) {
				stack.add((double)nums[c - 65]);
			}
			else {
				double b = stack.pop();
				double a = stack.pop();
				switch(c) {
				case('+'):
					stack.add(a + b);
					break;
				case('-'):
					stack.add(a - b);
					break;
				case('*'):
					stack.add(a * b);
					break;
				case('/'):
					stack.add(a / b);
					break;
				}
			}
		}
		System.out.println(String.format("%.2f", stack.pop()));
	}
}

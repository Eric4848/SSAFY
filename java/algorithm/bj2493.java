import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] towers = new int[N];
		int[] answers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty()) {
				if(towers[i] < towers[stack.peek()]) {
					answers[i] = stack.peek() + 1;
					break;
				}
				else {
					stack.pop();
				}
			}
			stack.add(i);
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(answers[i] + " ");
		}
	}
}


//public class bj2493 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] towers = new int[N];
//		int[] answers = new int[N];
//		for(int i = 0; i < N; i++) {
//			towers[i] = sc.nextInt();
//		}
//		
//		Stack<Integer> stack = new Stack<>();
//		stack.add(towers[N-1]);
//		int idx = N-1;
//		for(int i = N-2; 0 <= i; i--) {
//			while(!stack.isEmpty() && stack.peek() < towers[i]) {
//				stack.pop();
//				answers[idx] = i+1;
//				idx--;
//			}
//			stack.add(towers[i]);
//		}
//		
//		for(int i = 0; i < N; i++) {
//			System.out.print(answers[i] + " ");
//		}
//	}
//}


//public class bj2493 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] towers = new int[N];
//		int[] answers = new int[N];
//		for(int i = 0; i < N; i++) {
//			towers[i] = sc.nextInt();
//		}
//		
//		int highest = N-1;
//		
//		for(int i = N-1; 0 <= i; i--) {
//			if(towers[highest] < towers[i]) {
//				while(i < highest) {
//					answers[highest--] = i+1;
//				}
//			}
//		}
//		
//		for(int i = 0; i < N; i++) {
//			System.out.print(answers[i] + " ");
//		}
//	}
//}


//public class bj2493 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] towers = new int[N];
//		int[] answers = new int[N];
//		for(int i = 0; i < N; i++) {
//			towers[i] = sc.nextInt();
//		}
//		
//		for(int i = N-1; 0 < i; i--) {
//			for(int j = i-1; 0 <= j; j--) {
//				if(towers[i] < towers[j]) {
//					answers[i] = j+1;
//					break;
//				}
//			}
//		}
//		
//		for(int i = 0; i < N; i++) {
//			System.out.print(answers[i] + " ");
//		}
//	}
//}

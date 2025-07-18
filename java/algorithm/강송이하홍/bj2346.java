package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj2346 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> balloons= new ArrayDeque<>();
		int[] numbers = new int[N+1];
		for(int i = 1; i <= N; i++) {
			balloons.add(i);
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int balloon = balloons.pop();
		System.out.print(balloon);
		int number = numbers[balloon];
		while(!balloons.isEmpty()) {
			if(0 < number) {
				for(int i = 0; i < number - 1; i++) {
					balloons.add(balloons.pollFirst());
				}
				balloon = balloons.pop();
				System.out.print(" " + balloon);
				number = numbers[balloon];
			}
			else {
				for(int i = 0; number < i; i--) {
					balloons.addFirst(balloons.pollLast());
				}
				balloon = balloons.pop();
				System.out.print(" " + balloon);
				number = numbers[balloon];
			}
		}
	}
}

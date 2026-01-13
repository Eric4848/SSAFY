import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] is_visits = new boolean[100001];
		is_visits[N] = true;
		Queue<int[]> moves = new LinkedList<int[]>();
		moves.add(new int[] {N, 0});
		while(!moves.isEmpty()) {
			int[] curr = moves.poll();
			int loc = curr[0];
			int move = curr[1];
			if(loc == K) {
				System.out.println(move);
				break;
			}
			
			if(0 <= loc-1 && !is_visits[loc-1]) {
				moves.add(new int[] {loc-1, move+1});
				is_visits[loc-1] = true;
			}
			
			if(loc+1 <= 100000 && !is_visits[loc+1]) {
				moves.add(new int[] {loc+1, move+1});
				is_visits[loc+1] = true;
			}
			
			if(loc*2 <= 100000 && !is_visits[loc*2]) {
				moves.add(new int[] {loc*2, move+1});
				is_visits[loc*2] = true;
			}			
		}
	}
}

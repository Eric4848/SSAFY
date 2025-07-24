import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj17140 {
	static class Counted implements Comparable<Counted>{
		int num;
		int count;
		
		public Counted(int num, int count) {
			this.num = num;
			this.count = count;
		}
		
		public int compareTo(Counted o) {
			if(this.count == o.count)
				return this.num - o.num;
			return this.count - o.count;
		}
	}
	static int r, c, k, rl, cl;
	static int[][] arrays = new int[101][101];
	static int[] counts = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rl = 3;
		cl = 3;
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int time = 0;
		boolean able = false;
		for(int row = 1; row <= 3; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 1; col <= 3; col++) {
				arrays[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(time <= 100) {
			if(arrays[r][c] == k) {
				able = true;
				break;
			}
			if(cl <= rl)
				Row();
			else
				Col();
			time++;
		}
		
		if(able)
			System.out.println(time);
		else
			System.out.println(-1);
	}
	
	static void Row() {
		int L = 0;
		for(int row = 1; row <= rl; row++) {
			int l = 0;
			Arrays.fill(counts, 0);
			for(int col = 1; col <= cl; col++) {
				counts[arrays[row][col]]++;
			}
			
			PriorityQueue<Counted> pq = new PriorityQueue<>();
			for(int num = 1; num <= 100; num++) {
				if(counts[num] > 0) { 
					pq.add(new Counted(num, counts[num]));
					l++;
				}
			}
			
			int col = 1;
			while(!pq.isEmpty()) {
				Counted curr = pq.poll();
				arrays[row][col++] = curr.num;
				arrays[row][col++] = curr.count;
				if(col == 101)
					break;
			}
			while(col <= cl)
				arrays[row][col++] = 0;
			L = Math.max(L, l);
		}
		cl = L * 2;
	}
	
	static void Col() {
		int L = 0;
		for(int col = 1; col <= cl; col++) {
			int l = 0;
			Arrays.fill(counts, 0);
			for(int row = 1; row <= rl; row++) {
				counts[arrays[row][col]]++;
			}
			
			PriorityQueue<Counted> pq = new PriorityQueue<>();
			for(int num = 1; num <= 100; num++) {
				if(counts[num] > 0) { 
					pq.add(new Counted(num, counts[num]));
					l++;
				}
			}
			
			int row = 1;
			while(!pq.isEmpty()) {
				Counted curr = pq.poll();
				arrays[row++][col] = curr.num;
				arrays[row++][col] = curr.count;
				if(row == 101)
					break;
			}
			while(row <= rl)
				arrays[row++][col] = 0;
			L = Math.max(L, l);
		}
		rl = L * 2;
	}
}

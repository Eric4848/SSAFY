import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj2632 {
	static int m, n;
	static int[] apizza, bpizza;
	static PriorityQueue<Integer> asize, bsize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		apizza = new int[m * 2];
		bpizza = new int[n * 2];
		
		for(int i = 0; i < m; i++) {
			int ap = Integer.parseInt(br.readLine());
			apizza[i] = ap;
			apizza[m + i] = ap;
		}
		
		for(int i = 0; i < n; i++) {
			int bp = Integer.parseInt(br.readLine());
			bpizza[i] = bp;
			bpizza[n + i] = bp;
		}
		
		asize = new PriorityQueue<Integer>();
		bsize = new PriorityQueue<Integer>((a, b) -> {return b - a;});
		
		calca();
		calcb();
		
		int answer = 0;
		int curr = 0;
		int added = 0;
		while(!bsize.isEmpty()) {
			curr = bsize.poll();
			if(size < curr) continue;
			while(!asize.isEmpty()) {
				added = asize.poll();
				if(size < added) break;
				if(size < curr + added) curr = bsize.poll();
				if(curr + added == size) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	
	static void calca() {
		int sum = 0;
		for(int i = 0; i < m; i++)
			sum += apizza[i];
		asize.add(0);
		asize.add(sum);
		for(int l = 1; l < m; l++) {
			int total = 0;
			int head = 0;
			int tail = 0;
			while(tail < l) 
				total += apizza[tail++];
			for(int i = 0; i < m; i++) {
				asize.add(total);
				total -= apizza[head++];
				total += apizza[tail++];
			}
		}
	}
	
	static void calcb() {
		int sum = 0;
		for(int i = 0; i < n; i++)
			sum += bpizza[i];
		bsize.add(0);
		bsize.add(sum);
		for(int l = 1; l < n; l++) {
			int total = 0;
			int head = 0;
			int tail = 0;
			while(tail < l) 
				total += bpizza[tail++];
			for(int i = 0; i < n; i++) {
				bsize.add(total);
				total -= bpizza[head++];
				total += bpizza[tail++];
			}
		}
	}
}

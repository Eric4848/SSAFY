import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class bj2632 {
	static int m, n;
	static int[] apizza, bpizza;
	static Map<Integer, Integer> asize;
	static List<Integer> bsize;
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
		
		asize = new HashMap<Integer, Integer>();
		bsize = new ArrayList<Integer>();
		
		calca();
		calcb();
		
		int answer = 0;
		for(int i = 0; i < bsize.size(); i++) {
			int bp = bsize.get(i);
			int ap = size - bp;
			if(asize.containsKey(ap))
				answer += asize.get(ap);
		}
		System.out.println(answer);
	}
	
	static void calca() {
		int sum = 0;
		for(int i = 0; i < m; i++)
			sum += apizza[i];
		asize.put(0, 1);
		asize.put(sum, 1);
		for(int l = 1; l < m; l++) {
			int total = 0;
			int head = 0;
			int tail = 0;
			while(tail < l) 
				total += apizza[tail++];
			for(int i = 0; i < m; i++) {
				if(asize.containsKey(total))
					asize.put(total, asize.get(total) + 1);
				else
					asize.put(total, 1);
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

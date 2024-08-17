import java.util.*;
import java.io.*;

class swea2930
{
	static long[] heap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			heap = new long[N+1];
			int heapSize = 0;
			sb = new StringBuilder();
			sb.append("#" + tc);
			boolean is_end = false;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(st.nextToken());
				if(order == 1) {
					heap[++heapSize] = Integer.parseInt(st.nextToken());
					
					int ch = heapSize;
					int p = ch / 2;
					
					while(ch != 1 && heap[p] < heap[ch]) {
						swap(ch, p);
						ch = p;
						p = ch / 2;
					}
				}
				else {					
					if(heapSize == 0) {
						sb.append(" " + -1);
						continue;
					}
					sb.append(" " + heap[1]);
					heap[1] = heap[heapSize--];
					int p = 1;
					int ch = p * 2;
					if(ch + 1 <= heapSize && heap[ch] < heap[ch+1])
						ch++;
					while(ch <= heapSize && heap[p] < heap[ch]) {
						swap(p, ch);
						p = ch;
						ch = p * 2;
						if(ch + 1 <= heapSize && heap[ch] < heap[ch+1])
							ch++;
					}
				}
			}
			System.out.println(sb);
		}
	}
	
	static void swap(int a, int b) {
		long tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
}
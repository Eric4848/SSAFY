import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj20920 {
	static class Word implements Comparable<Word>{
		String word;
		int cnt;
		
		Word(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Word o) {
			if(this.cnt == o.cnt) {
				if(this.word.length() == o.word.length()) {
					int i = 0;
					int L = word.length();
					while(i < L) {
						if(this.word.charAt(i) != o.word.charAt(i)) {
							return this.word.charAt(i) - o.word.charAt(i);
						}
						i++;
					}
				}
				return o.word.length() - this.word.length();
			}
			return o.cnt - this.cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> words = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			if(!words.containsKey(word)) {
				words.put(word, 1);
			} else {
				words.put(word, words.get(word) + 1);
			}
		}
		
		PriorityQueue<Word> pq = new PriorityQueue<>();
		for(String word : words.keySet()) {
			pq.add(new Word(word, words.get(word)));
		}
		
		while(!pq.isEmpty()) {
			Word word = pq.poll();
			if(word.word.length() < M) continue;
			sb.append(word.word).append("\n");
		}
		
		System.out.println(sb);
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bj5670 {
	static class Trie{
		Map<Character, Trie> child = new HashMap<>();
		boolean end;
		
		public void insert(String word) {
			Trie trie = this;
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				
				trie.child.putIfAbsent(c, new Trie());
				trie = trie.child.get(c);
				
				if(i == word.length()-1)
					trie.end = true;
			}
		}
		
		public int count(String word) {
			Trie trie = this;
			int cnt = 0;
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				Trie nxt = trie.child.get(c);
				if(i == 0) {
					cnt++;
				}
				else if(trie.end || 1 < trie.child.size()) {
					cnt++;
				}
				trie = nxt;
			}
			return cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = br.readLine()) != null) {
			int N = Integer.parseInt(line);
			String[] words = new String[N];
			Trie trie = new Trie();
			for(int i = 0; i < N; i++) {
				String word = br.readLine();
				words[i] = word;
				trie.insert(word);
			}
			double answer = 0;
			for(String word : words)
				answer += trie.count(word);
			System.out.println(String.format("%.2f", answer/words.length));
		}
	}
}

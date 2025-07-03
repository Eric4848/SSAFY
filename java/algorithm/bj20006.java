import java.io.*;
import java.util.*;

public class bj20006 {
	static class Player implements Comparable<Player>{
		int level;
		String nickname;
		
		Player(int level, String nickname){
			this.level = level;
			this.nickname = nickname;
		}
		
		@Override
		public int compareTo(Player o) {
			return this.nickname.compareTo(o.nickname);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer> parties = new ArrayList<Integer>();
		List<Integer> counts = new LinkedList<Integer>();
		List<PriorityQueue<Player>> players = new ArrayList<PriorityQueue<Player>>();
		
		for(int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			boolean is_added = false;
			for(int j = 0; j < parties.size(); j++) {
				int able_level = parties.get(j);
				if(counts.get(j) < m && able_level - 10 <= l && l <= able_level + 10) {
					int cnt = counts.remove(j);
					counts.add(j, cnt+1);
					is_added = true;
					PriorityQueue<Player> pq = players.remove(j);
					pq.add(new Player(l, n));
					players.add(j, pq);
					break;
				}
			}
			
			if(!is_added) {
				parties.add(l);
				counts.add(1);
				PriorityQueue<Player> pq = new PriorityQueue<>();
				pq.add(new Player(l, n));
				players.add(pq);
			}
		}
		
		for(int i = 0; i < parties.size(); i++) {
			if(counts.get(i) == m)
				System.out.println("Started!");
			else
				System.out.println("Waiting!");
			
			PriorityQueue<Player> pq = players.get(i);
			while(!pq.isEmpty()) {
				Player player = pq.poll();
				System.out.println(player.level + " " + player.nickname);
			}
		}
	}
}

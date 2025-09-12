import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj9017 {
	static class Team implements Comparable<Team> {
		int score = 0;
		int goal = 0;
		int fifth = -1;
		int num;

		@Override
		public int compareTo(Team o) {
			if(this.score == o.score) {
				return this.fifth - o.fifth;
			}
			return this.score - o.score;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] results = new int[N+1];
			int[] cnts = new int[201];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				int team = Integer.parseInt(st.nextToken());
				results[i] = team;
				cnts[team] += 1;
			}
			
			Team[] teams = new Team[201];
			for(int i = 1; i <= 200; i++) {
				teams[i] = new Team();
			}
			
			int points = 1;
			for(int i = 1; i <= N; i++) {
				int t = results[i];
				if(cnts[t] != 6) continue;
				if(teams[t].goal < 4)
					teams[t].score += points;
				points++;
				teams[t].goal += 1;
				if(teams[t].goal == 5)
					teams[t].fifth = points;
			}
			
			PriorityQueue<Team> pq = new PriorityQueue<Team>();
			for(int i = 1; i <= 200; i++) {
				if(6 == teams[i].goal) {
					teams[i].num = i;
					pq.add(teams[i]);
				}
			}
			System.out.println(pq.poll().num);
		}
	}
}

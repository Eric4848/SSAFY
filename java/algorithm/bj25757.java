import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj25757 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		int pn = 0;
		switch(game) {
		case "Y":
			pn = 2;
			break;
		case "F":
			pn = 3;
			break;
		case "O":
			pn = 4;
			break;
		default:
			break;
		}
		Set<String> players = new HashSet<String>();
		for(int i = 0; i < N; i++)
			players.add(br.readLine());
		System.out.println(players.size() / (pn - 1));
	}
}

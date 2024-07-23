import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int minIdx = 100;
			int maxIdx = 0;
			int[] cnts = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
				int heights = Integer.parseInt((String) st.nextElement());
				cnts[heights] += 1;
				maxIdx = Math.max(maxIdx, heights);
				minIdx = Math.min(minIdx, heights);
			}
			for(int dump = 0; dump < T; dump++) {
				cnts[maxIdx] -= 1;
				cnts[maxIdx-1] += 1;
				cnts[minIdx] -= 1;
				cnts[minIdx+1] += 1;
				if(cnts[maxIdx] == 0)
					maxIdx--;
				if(cnts[minIdx] == 0)
					minIdx++;
			}
			System.out.println("#" + tc + " " + (maxIdx - minIdx));
		}
	}
}


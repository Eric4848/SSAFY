import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1245 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			double[] locs = new double[N];
			double[] weights = new double[N];
			for(int i = 0; i < N; i++) {
				locs[i] = Double.parseDouble(st.nextToken());
			}
			for(int i = 0; i < N; i++) {
				weights[i] = Double.parseDouble(st.nextToken());
			}
			double[] answers = new double[N-1];
			for(int i = 0; i < N-1; i++) {
				double dist = locs[i+1] - locs[i];
				double ratio =  weights[i+1] / weights[i];
				answers[i] = locs[i] + dist * (1 / (Math.sqrt(ratio)+1));
//				double f1 = weights[i] / Math.pow(answers[i] - locs[i], 2);
//				double f2 = weights[i+1] / Math.pow(answers[i] - locs[i+1], 2);
//				System.out.println("diff : " + (f1 - f2));
			}
			System.out.print("#" + tc);
			for(int i = 0; i < N-1; i++) {
				System.out.printf(" %.10f", answers[i]);
			}
			System.out.println();
		}
	}
}



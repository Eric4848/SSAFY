import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2098 {
	static int N;
	static int max = 16000000;	// 오버플로우 방지를 위해 가능한 최댓값 계산
	static int[][] W, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		dp = new int[N][1 << N];	// 각 도시별로 방문해야 할 도시들을 가장 효율적으로 방문하는 시간 저장 / 비트를 통해 이미 방문한 도시 표시
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				W[r][c] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[r], -1);
		}
		System.out.println(tsp(0, 1));
	}
	
	static int tsp(int curr, int visited) {
		if(visited == (1 << N) - 1) {	// 모든 도시를 방문했을 때
			if(0 < W[curr][0]) {	// tsp를 시작한 위치(이번 경우는 0)로 갈 수 있다면
				return W[curr][0];	// 시작 위치로 가는 시간 반환
			}
			return max;
		}
		
		// 현재 위치기준으로 방문한 도시들이 같은 결과가 있는 경우
		if(dp[curr][visited] != -1) {
			return dp[curr][visited];
		}
		
		// 계산을 위해 초기화
		dp[curr][visited] = max;
		
		for(int nxt = 0; nxt < N; nxt++) {
			// 방문한 도시(& 연산을 통해 1로 저장되었는지 확인)이거나 갈수 없다면 통과
			if((visited & (1 << nxt)) != 0 || W[curr][nxt] == 0) continue;
			// 현재 기준 남은 도시를 순회하는 최소 시간과 다음 도시에 가서 남은 도시를 순회하는 시간을 비교하여 적은 것 저장
			dp[curr][visited] = Math.min(dp[curr][visited], W[curr][nxt] + tsp(nxt, visited | (1 << nxt)));
		}
		
		return dp[curr][visited];
	}
}

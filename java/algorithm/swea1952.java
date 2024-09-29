import java.util.*;
import java.io.*;

class swea1952
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			// 가격 정보 저장
			int[] prices = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			int answer = prices[3];	// 정답을 1년권 값으로 초기화
			
			// 일정 저장
			int[] plans = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}
			
			// dp 진행할 배열
			int[][] answers = new int[2][13];
			
			// 0번 행에 일일권, 월간권 가격 비교하여 적은 것 거장
			for(int i = 1; i <= 12; i++) {
				answers[0][i] = Math.min(prices[0] * plans[i-1], prices[1]);
			}
			
			// 0번 행의 가격 누적합으로 만들기
			for(int i = 0; i < 12; i++) {
				answers[0][i+1] += answers[0][i];
			}
			
			// 1번행에 0번행 가격 복사
			for(int i = 0; i < 12; i++) {
				answers[1][i] = answers[0][i];
			}
			
			// dp계산
			for(int i = 3; i <= 12; i++) {	// 3개월권이므로 3월부터 계산(처음 2개까지만 묶는 경우는 없으므로)
				// 3개월권까지 비교한 i-1월의 값 + 이번달(0행의 현재 - 0행의 현재-1월)과 3달 전까지의 합 + 3개월권 중 적은 값을 저장
				answers[1][i] = Math.min(answers[1][i-1] + answers[0][i] - answers[0][i-1], answers[1][i-3] + prices[2]);
			}
			
			answer = Math.min(answer, answers[1][12]);	// 1년권과 비교하여 적은 값 저장
			System.out.println("#" + tc + " " + answer);
		}
	}
}
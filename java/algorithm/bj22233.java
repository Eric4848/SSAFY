import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj22233 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> keywords = new HashSet<String>();
		for(int i = 0; i < N; i++) {
			keywords.add(br.readLine());
		}
		int answer = N;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			while(st.hasMoreTokens()) {
				String keyword = st.nextToken();
				if(keywords.remove(keyword))
					answer--;
			}
			System.out.println(answer);
		}
	}
}


//public class bj22233 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		Set<String> keywords = new HashSet<String>();
//		for(int i = 0; i < N; i++) {
//			keywords.add(br.readLine());
//		}
//		for(int i = 0; i < M; i++) {
//			String[] articles = br.readLine().split(",");
//			for(int j = 0; j < articles.length; j++) {
//				if(keywords.contains(articles[j]))
//					keywords.remove(articles[j]);
//			}
//			System.out.println(keywords.size());
//		}
//	}
//}

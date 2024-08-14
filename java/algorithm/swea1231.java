import java.util.*;
import java.io.*;


class swea1231
{
	static String[] strs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int L = 1;
			while (L < N+1)
				L *= 2;
			strs = new String[L];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int loc = Integer.parseInt(st.nextToken());
				strs[loc] = st.nextToken();
			}
			System.out.print("#" + tc + " ");
			inorder(1);
			System.out.println();
		}
	}
	static void inorder(int i) {
		if (strs.length <= i || strs[i] == null)
			return;
		inorder(i * 2);
		System.out.print(strs[i]);
		inorder(i * 2 + 1);
	}
}

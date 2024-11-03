package baekjoon;

import java.util.Scanner;

public class bj1987 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static char[][] alphs;
	static int R, C, answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer = 0;
		R = sc.nextInt();
		C = sc.nextInt();
		alphs = new char[R][C];
		for(int r = 0; r < R; r++) {
			alphs[r] = sc.next().toCharArray();
		}
		dfs(0, 0, "" + alphs[0][0]);
		System.out.println(answer);
	}
	
	static void dfs(int r, int c, String checked) {
		int l = checked.length();
		answer = Math.max(l, answer);
		
		cp:for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(0 <= nr && nr < R && 0 <= nc && nc < C) {
				char nxt = alphs[nr][nc];
				for(int i = 0; i < l; i++) {
					if(nxt == checked.charAt(i)) continue cp;
				}
				dfs(nr, nc, checked+nxt);
			}
		}
	}
}



//public class bj1987 {
//	static class node {
//		int r;
//		int c;
//		String checked;
//		
//		node(int r, int c, String checked) {
//			this.r = r;
//			this.c = c;
//			this.checked = checked;
//		}
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int[] dr = {1, -1, 0, 0};
//		int[] dc = {0, 0, 1, -1};
//		int answer = 0;
//		int R = sc.nextInt();
//		int C = sc.nextInt();
//		String[] alphs = new String[R];
//		for(int r = 0; r < R; r++) {
//			alphs[r] = sc.next();
//		}
//		
//		Queue<node> q = new LinkedList<>();
//		q.add(new node(0, 0, alphs[0].substring(0, 1)));
//		while(!q.isEmpty()) {
//			node now = q.poll();
//			String checked = now.checked;
//			int l = checked.length();
//			answer = Math.max(answer, l);
//			cp:for(int d = 0; d < 4; d++) {
//				int nr = now.r + dr[d];
//				int nc = now.c + dc[d];
//				if(0 <= nr && nr < R && 0 <= nc && nc < C) {
//					char nxt = alphs[nr].charAt(nc);
//					for(int i = 0; i < l; i++) {
//						if(nxt == checked.charAt(i)) continue cp;
//					}
//					q.add(new node(nr, nc, checked + nxt));
//				}
//			}
//		}
//		System.out.println(answer);
//	}
//}

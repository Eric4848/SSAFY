package 종만북;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class POTION {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc <= C; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] ingredients = new int[n];
			int[] contains = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				ingredients[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				contains[i] = Integer.parseInt(st.nextToken());
			}
			
			int gcd = gcd(ingredients[0], ingredients[1]);
			for(int i = 2; i < n; i++) {
				gcd = gcd(gcd, ingredients[i]);
			}
			
			int[] ratios = new int[n];
			for(int i = 0; i < n; i++) {
				ratios[i] = ingredients[i] / gcd;
			}
			
			int[] target = new int[n];
			int pw = 1;
			cp : while(true) {
				for(int i = 0; i < n; i++) {
					if(ratios[i] * pw < ingredients[i] || ratios[i] * pw < contains[i]) {
						pw++;
						continue cp;
					}
				}
				break;
			}
			for(int i = 0; i < n; i++) {
				System.out.print(ratios[i] * pw - contains[i] + " ");
			}
			System.out.println();
		}
	}
	
	static int gcd(int p, int q) {
		if(q == 0) return p;
		return gcd(q, p % q);
	}
}

//3
//4
//4 6 2 4
//6 4 2 4
//4
//4 6 2 4
//7 4 2 4
//3
//4 5 6
//1 2 3
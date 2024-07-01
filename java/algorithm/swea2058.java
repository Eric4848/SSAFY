import java.util.Scanner;

public class swea2058 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;
		num = sc.nextInt();
		
		int answer = 0;
		
		answer += num % 10;
		num /= 10;
		answer += num % 10;
		num /= 10;
		answer += num % 10;
		num /= 10;
		answer += num % 10;
		
		System.out.println(answer);
	}

}

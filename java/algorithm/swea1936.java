import java.util.Scanner;

public class swea1936 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A, B;
		A = sc.nextInt();
		B = sc.nextInt();
		int result = (A - B) % 3;
		if (result == 1 || result == -2) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}

	}

}

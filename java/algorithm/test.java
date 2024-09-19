import java.util.Arrays;
import java.util.Collections;

public class test {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 5, 93, 2, 4, 6, 99};
		System.out.println(Arrays.stream(nums).max().getAsInt() == 99);
		String str = "5";
		System.out.println((char) (3 + '0') + str);
	}
}

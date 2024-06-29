
public class ArrayApp {
	
	public static void main(String[] args) {
		
//		String users = "Eric, jinhuck, youbin";
		String[] users = new String[3];
		users[0] = "Eric";
		users[1] = "jinhuck";
		users[2] = "youbin";
		
		System.out.println(users[1]);
		System.out.println(users.length);
		
		int[] scores = {10, 80, 100};
		System.out.println(scores[1]);
		System.out.println(scores.length);		
		
	}

}

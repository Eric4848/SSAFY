
public class AuthApp {

	public static void main(String[] args) {
		
		String id = "Eric";
		String inputId = args[0];
		
		String pw = "1111";
		String inputPw = args[1];

		System.out.println("Hi.");
		
//		if (inputId == id) {
//		if (inputId.equals(id)) {
//			if (inputPw.equals(pw)) {
//				System.out.println("Master");
//			} else {
//				System.out.println("Who are you?");
//			}
//		} else {
//			System.out.println("Who are you?");
//		}
//	}
		if (inputId.equals(id) && inputPw.equals(pw)) {
			System.out.println("Master");
		} else {
			System.out.println("Who are you?");
		}
	}

}
f
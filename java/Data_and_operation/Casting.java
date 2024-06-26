
public class Casting {
	
	public static void main(String[] args) {
		
		double a = 1.1;
		double b = 1;
		System.out.println(b);
		
		// int c = 1.1; // int에 double형 저장 불가능
		double d = 1.1;
		int e = (int) 1.1;
		System.out.println(e);
		
		String f = Integer.toString(1);
		System.out.println(f.getClass());
		
	}

}

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class InstanceApp {

	public static void main(String[] args) throws IOException {

		PrintWriter p1 = new PrintWriter("result1.txt");
		p1.write("Hello 1");
		p1.close();
		
		PrintWriter p2 = new PrintWriter("result2.txt");
		p2.write("Hello 2");
		p2.close();
		
		System.out.println(p1.toString());
		p2.toString();
		p2.write("Hello 2");
		
//		PrintWriter.write("result1.txt", "Hello 1");
//		PrintWriter.write("result2.txt", "Hello 2");
//		PrintWriter.write("result3.txt", "Hello 3");
//		PrintWriter.write("result4.txt", "Hello 4");
//		PrintWriter.write("result5.txt", "Hello 5");
//		PrintWriter.write("result6.txt", "Hello 6");
//		PrintWriter.write("result7.txt", "Hello 7");

	}

}

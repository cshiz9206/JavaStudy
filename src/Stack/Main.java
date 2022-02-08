package Stack;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		MyStack stack = new MyStack();
		
		while(true) {
			System.out.print("MyStack> ");
			String comdLine = s.nextLine();
			String[] tmp = comdLine.split(" ");
			String command = tmp[0];
			int parameter = 0;
			try {
				if (command.equals("push") && tmp.length == 2) {
					parameter = Integer.parseInt(tmp[1]);
					stack.push(parameter);
				}
				else if(command.contentEquals("pop"))
					stack.pop();
				else if(command.contentEquals("exit")) {
					System.out.println("안녕~");
					break;
				}
				else System.out.println("잘못된 명령어입니다.");
			} catch(Exception e) { 
				System.out.println("잘못된 명령어입니다.");
				continue;
			}
		}
	}
}

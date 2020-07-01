package 제05장_스택__후위식_계산하기;

import java.io.*;
import java.util.Scanner;

class Stack {
	class ListNode {
		Object data;
		ListNode link;
	}
	
	private ListNode top;
	
	public boolean isEmpty() {
		return (top == null);
	}
	
	public void push(Object x) {
		ListNode newNode = new ListNode();
		newNode.data = x;
		newNode.link = top;
		top = newNode;
	}
	
	public Object pop() {
		if(isEmpty()) return null; 
		else {
			Object item = top.data;
			top = top.link;
			return item;
		}
	}
	
	public void delete() {
		if (isEmpty()) return;
		else top = top.link;
	}
	
	public Object peek() {
		if (isEmpty()) return null;
		else return top.data;
	}
}


class Main {
	
	// 필요한 필드나 메소드가 있으면 작성하시오.
	
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		Double a;
		
		
		// 아래 코드를 완성하시오.
		String str = scan.next();
		while (!str.equals("$")) {

			if (str.equals("+")) {
				double cal1 = (double) stack.pop();
				double cal2 = (double) stack.pop();
				stack.push(cal2+cal1);
				
			} else if (str.equals("-")) {
				double cal1 = (double) stack.pop();
				double cal2 = (double) stack.pop();
				stack.push(cal2-cal1);
				
			} else if (str.equals("*")) {
				double cal1 = (double) stack.pop();
				double cal2 = (double) stack.pop();
				stack.push(cal2*cal1);
				
				
			} else if (str.equals("/")) {
				double cal1 = (double) stack.pop();
				double cal2 = (double) stack.pop();
				stack.push(cal2/cal1);
				
			} else {
				double operand = Double.parseDouble(str);	
				stack.push(operand);
				
			}
			
			str = scan.next();
		}
		System.out.println(stack.pop());
	}
}
/*///////////////////////////////////////////////////////////
후위식을 입력받아 스택을 이용하여 이를 계산한다.							
예를 들어 다음과 같은 식이 입력되었다고 가정하자. 여기서 $는 입력의 끝은 뜻한다.	
2 3 4 * + 4 2 / - $										
이를 계산한 결과를 다음과 같이 출력한다.
12.0
주의
모든 결과는 소숫점 한자리까지 연산한다.
예시 1
입력
2 3 4 * + 4 2 / - $
출력
12.0
예시 2
입력
2 5 * 4 / 3 2 * - 5 + $
출력
1.5
///////////////////////////////////////////////////////////*/
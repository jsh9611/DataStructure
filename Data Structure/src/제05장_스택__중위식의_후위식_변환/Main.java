package 제05장_스택__중위식의_후위식_변환;

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

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		String str = scan.next();
		StringBuffer postfix = new StringBuffer("");
		
		while (!str.equals("$")) {
			
			switch (str) {
			case "(":
					stack.push(str);
					break;
			case ")":
					while(!stack.isEmpty() && !stack.peek().equals("(")) {
						if(stack.peek().equals("(")) {
							stack.pop();
							continue;
						}
						postfix.append(" " + stack.pop()); 
					}
					break;	
			case "*":
			case "/":
					while(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
						if(stack.peek().equals("(")) {
							stack.pop();
							continue;
						}
						postfix.append(" " + stack.pop());
					}
					stack.push(str);
					break;
			case "+":
			case "-": 
					while(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
						if(stack.peek().equals("(")) {
							stack.pop();
							continue;
						}
						postfix.append(" " + stack.pop());
					}
					while(!stack.isEmpty() && (stack.peek().equals("+") || stack.peek().equals("-"))) {
						if(stack.peek().equals("(")) {
							stack.pop();
							continue;
						}
						postfix.append(" " + stack.pop());
					}
					stack.push(str);
					break;
			default: //case "0"~"9"
					postfix.append(" " + str);
					break;	
			}
			str = scan.next();
		}
		while(!stack.isEmpty()) {
			if(stack.peek().equals("(")) {
				stack.pop();
				continue;
			}
			postfix.append(" " + stack.pop());
		}
		System.out.println(postfix);
	}
}
/*////////////////////////////////////////////
중위식을 후위식으로 변환한다. 예를 들어 다음 수식을 입력할 경우
1 * 2 ( 3 + 4 ) / 5 $
위 식의 후위식은 다음과 같다.
1 2 3 4 + * 5 /
입력값에서 $는 마지막을 나타낸다.
예시 1
입력
1 * 2 - ( 3 + 4 ) / 5 $
출력
1 2 * 3 4 + 5 / -
예시2
입력
1 * ( 2 + ( 5 - 4 ) * ( 6 + 7 ) ) $
출력
1 2 5 4 - 6 7 + * + *
////////////////////////////////////////////*/

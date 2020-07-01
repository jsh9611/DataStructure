package 제06장_큐__배열을_이용한_큐;

import java.io.*;

class Queue {
	private String[] data;
	private static final int QUEUE_SIZE = 5;
	
	private int front = 0;
	private int rear = 0;

	public Queue() {
		data = new String[QUEUE_SIZE];
	}

	public void enque(String str) {
		data[rear] = str;
		rear = (rear + 1) % QUEUE_SIZE;
	}

	public String deque() {
		String str = data[front];
		front = (front + 1) % QUEUE_SIZE;
		return str;
	}
	
	public void print() {}
}

class Main {
	
	// 아래 main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Queue queue = new Queue();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int no = Integer.parseInt(input);
		
		for(int i = 0; i < no; i++) {
			String cmd = br.readLine();
			
			if (cmd.equals("enque")) {
				String name = br.readLine();
				queue.enque(name);
			} else if (cmd.equals("deque")) {
				System.out.println(queue.deque());
			} else {
				throw new IllegalArgumentException();
			}
		}
		
		queue.print();
		
		br.close();
  }
}
/*
스택을 작성하시오. 작성해야 하는 함수는 다음과 같다.
1. enque : 큐에 삽입
2. deque : 큐에서 삭제
주의 : 원형 큐로 만드시오. 큐가 가득차도 배열이 커지지 않는다.
예시1
6
enque
One
enque
Two
enque
Three
deque
deque
deque
*
One
Two
Three

예시2
12
enque
One
enque
Two
enque
Three
deque
deque
enque
Four
enque
Five
deque
deque
enque
Six
deque
deque
*
One
Two
Three
Four
Five
Six
*/
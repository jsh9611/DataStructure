package 제8장_이원탐색트리_힙;

import java.io.*;
import java.util.Scanner;

class MaxHeap {
		
	private int size = 0;	// MaxHeap에 저장된 데이터 갯수. p.336에서는 변수 n으로 표현
	private int[] heap; // MaxHeap
	
	/**
	 * @param capacity 힙 배열의 크기
	 */
	public MaxHeap(int capacity) {
		heap = new int[capacity];
	}
	
	public void print() {
		for(int i = 0; i < size; i++)
			System.out.print(heap[i] + " ");
	}
	
	// 아래 2개의 메소드(insert, delete)를 작성하시오.
	
	/**
	 * 교재 p.336 참조
	 * @param x 삭입하고자 하는 데이터
	 */
	public void insert(int x) {
		
		
	}
	
	/**
	 * 교재 p.338 참조
	 * MaxHeap에서 최대값을 삭제하고 그 같은 반환한다.
	 * @return 최대값 출력
	 */
	public int delete() {
		
		
		return 0;
	}
}
	
class Main {
	
	// 아래 main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		MaxHeap heap = new MaxHeap(100);
		
		while (scan.hasNext()) {
			String command = scan.next();
			
			if (command.equals("I")) {
				int data = Integer.parseInt(scan.next());
				heap.insert(data);
			} else if (command.equals("D")) {
				heap.delete();
			} else if (command.equals("P")) {
				heap.print();
			} else if (command.equals("E")) {
				break;
			}
		}
		scan.close();
	}
	
}
package 제08장_이원탐색트리_힙;

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
			System.out.print(heap[i+1] + " ");
	}
	
	// 아래 2개의 메소드(insert, delete)를 작성하시오.
	
	/**
	 * 교재 p.336 참조
	 * @param x 삭입하고자 하는 데이터
	 */
	public void insert(int x) {
		if (size == heap.length-1) {
			System.out.println("heap size 초과");
			return;
		}
		int i = ++size;
		while(true) {
			if(i == 1) {
				break;
			}
			if(x < heap[i/2]) {
				break;
			}
			heap[i] = heap[i/2];
			i = i/2;
			 
		}
		
		heap[i] = x;
		
	}
	
	/**
	 * 교재 p.338 참조
	 * MaxHeap에서 최대값을 삭제하고 그 같은 반환한다.
	 * @return 최대값 출력
	 */
	public int delete() {
		
		if(size==0) {
			System.out.println("Error");
			return 0;
		}
		int item = heap[1]; // 우선순위가 가장 높은 노드부터 삭제
		int temp = heap[size];
		
		size--; //마지막 원소 삭제
		int i = 1;
		int j = 2;
		while(j <= size) {
			if(j < size) {
				if (heap[j] < heap[j+1]) {
					j = j+1;
				}
			}
			if (temp >= heap[j]) {
				break;
			}
			heap[i] = heap[j];
			i = j;
			j = j*2;
		}
		heap[i] = temp;
		
		return item;
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
/*
예시1
입력
I 13
I 5
I 18
I 8
I 12
P
출력
18 12 13 5 8
예시2
입력
I 13
I 5
I 18
I 8
I 12
D
P
출력
13 12 8 5
예시3
입력
I 5
I 10
I 15
I 20
I 25
I 30
P
출력
30 20 25 5 15 10
예시4
입력
I 5
I 10
I 15
I 20
I 25
I 30
D
D
P
출력
20 15 10 5
*/
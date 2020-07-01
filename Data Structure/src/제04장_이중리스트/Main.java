package 제04장_이중리스트;

import java.io.*;
import java.util.Scanner;

class ListNode {
	String data;
	ListNode rlink;
	ListNode llink;
	
}


class DoubleLinkedList {
	private ListNode head; // 리스트의 첫번째 노드를 가리킴
	private ListNode tail; // 리스트의 마지막 노드를 가리킴

	public DoubleLinkedList() {
		head = tail = null; // 리스트가 비어있을 때는 모두 null 이다.
	}

	/**
	 * @param str 삽입하고자 하는 데이터
	 * 작성하여야 한다.
	 */

	public void insert(String str) {
		ListNode node = new ListNode();
		node.rlink = null;
		node.llink = null;
		node.data = str;

		if (head == null) {
			head = node;
			tail = node;
			return;
		}

		for (ListNode p = head; p != null; p = p.rlink) {
			if (p.data.compareTo(str) < 0) { // p.data가 str보다 작은경우
				if (p.rlink == null) {
					// node.rlink = null;
					p.rlink = node;
					node.llink = p;
					tail = node;
					return;
				} else {
					continue;
				}
			} else if (p.data.compareTo(str) >= 0) { // p.rlink.data >= str

				if (p.llink == null) {
					node.rlink = p;
					p.llink = node;
					head = node;
					return;
				} else {
					node.llink = p.llink;
					p.llink.rlink = node;

					node.rlink = p;
					p.llink = node;
					return;
				}

			}

		}

	}

	/**
	 * @param str 삭제하고자 하는 데이터
	 * 작성하여야 한다.
	 */
	public void delete(String str) {
		if (head == null) {
			return;
		}
		if (head.equals(tail)) {
			head = tail = null;
			return;
		}
		if (head.data.equals(str)) {
			head = head.rlink;
			head.llink = null;
			return;
		} else if (tail.data.equals(str)) {
			tail = tail.llink;
			tail.rlink = null;
			return;
		}
		for (ListNode p = head; p.rlink != null; p = p.rlink) {
			if (p.data.equals(str)) {
				if (head.equals(tail)) {
					head = tail = null;
					return;
				} else if (p.llink == null) {
					head = p.rlink;
					head.llink = null;
					return;
				} else if (p.rlink == null) {
					tail = p.llink;
					tail.rlink = null;
					return;
				}
				p.llink.rlink = p.rlink;
				p.rlink.llink = p.llink;
				return;
			}
		}
		
	}
	// 저장된 모든 데이터를 출력한다.
	public void print() {
		if (head == null) {
			System.out.println("EMPTY");
			return;
		}

		String str = "";
		for(ListNode p = head; p != null; p = p.rlink)
			System.out.print(p.data + " ");
		System.out.println();
	}
}


class Main {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		DoubleLinkedList list = new DoubleLinkedList();
	
		while (true) {
			String cmd = scan.next();
			if (cmd.equals("E"))
				break;

			if (cmd.equals("I")) {
				list.insert(scan.next());
			} else if (cmd.equals("D")) {
				list.delete(scan.next());
			} else if (cmd.equals("P")) {
				list.print();
			} else {
				System.out.println("ERROR");
			}
		}
	}
}
/* 
ex1)
I tom
I john
I peter
D tom
P
E
=>john peter

ex2)
I tom
P
I john
P
I peter
P
E
=>tom
john tom
john peter tom

ex3)
I peter
I tom
I john
I jane
P
D john
D jane
P
I scot
P
E
=>jane john peter tom
peter tom
peter scot tom
 
ex4)
I scot
I tom
I peter
D tom
D scot
D peter
P
E
=>EMPTY
  */
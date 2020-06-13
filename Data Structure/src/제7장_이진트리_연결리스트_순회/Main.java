package 제7장_이진트리_연결리스트_순회;

import java.io.*;
import java.util.Scanner;

class BinaryTree {
	String data;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(String data) {
		this.data = data;
		left = right = null;
	}
	
	public void setChildren(BinaryTree left, BinaryTree right) {
		this.left = left;
		this.right = right;
	}
}

class ListNode {
	BinaryTree data;
	ListNode link;
}

class Stack {
	ListNode top;

	public void push(BinaryTree item) {
		ListNode newNode = new ListNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
	}

	public BinaryTree pop() {
		if(isEmpty()) return null;
		else {
			BinaryTree t = top.data;
			top = top.link;
			return t;
		}
	}

	public boolean isEmpty() {
		return (top == null);
	}
	public BinaryTree peek() {
		if (isEmpty()) return null;
		else return top.data;
	}
}

// 추가적으로 필요한 클래스(예를 들어 큐)가 있으면 작성하시오.
class Queue {
	ListNode head = null;	
	ListNode front = null;
	ListNode rear = null;
	
	public void Queue() {
		head = new ListNode();
		front = null;
		rear = null;
	}
	public void enqueue(BinaryTree data){
		if(!isEmpty()){
			ListNode newNode = new ListNode();
			newNode.data = data;
			rear.link = newNode;
			rear = newNode;
		}else{
			ListNode newNode = new ListNode();
			newNode.data = data;
			newNode.link = null;
			head = newNode;
			front = newNode;
			rear = newNode;
		}
	}
	
	public BinaryTree dequeue(){
		BinaryTree v = front.data;
		if(front == rear){
			head = null;
			rear = head;
			front = rear;
			return v;
		}else{
			head = front.link;
			front = front.link;
			return v;
		}
	}
	public boolean isEmpty(){
		return (head == null);
	}
}

class Main {
	
	//중위 순회(inorder traversal)
	public static void inorder(BinaryTree node) {
		if(node.left != null) {
			inorder(node.left);
		}
		System.out.print(node.data + " ");
		if(node.right != null) {
			inorder(node.right);
		}
	}
	
	//전위 순회(preorder traversal)
	public static void preorder(BinaryTree node) {
		System.out.print(node.data + " ");
		if(node.left != null) {
			preorder(node.left);
		}
		if(node.right != null) {
			preorder(node.right);
		}
	}
	
	//후위 순회(postorder traversal)
	public static void postorder(BinaryTree node) {
		if(node.left != null) {
			postorder(node.left);
		}
		if(node.right != null) {
			postorder(node.right);
		}
		System.out.print(node.data + " ");
	}
	
	//레벨 순서 순회(level order traversal)
	public static void levelorder(BinaryTree node) { 
		Queue queue = new Queue();
		queue.enqueue(node);
		BinaryTree n;
		
		while(!queue.isEmpty()) {
			n = queue.dequeue();
			System.out.print(n.data + " ");
			if(n.left != null) {
				queue.enqueue(n.left);
			}
			if(n.right != null) {
				queue.enqueue(n.right);
			}
		}
	}
	
	// 아래 main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		
		BinaryTree root = null;
		
		// 이진 트리 생성
		while(scan.hasNext()) {
			String token = scan.next();
			if (token.equals("null")) {
				stack.push(null);
			} else if (token.equals(")")) {
				BinaryTree right = stack.pop();
				if (stack.isEmpty()) {
					root = right;
					break;
				}
				BinaryTree left = stack.pop();
				root = stack.pop();
				root.setChildren(left, right);
				stack.push(root);
			} else if (token.equals("(")) {
				continue;
			} else {
				stack.push(new BinaryTree(token));
			}
		}
		scan.close();
		
		inorder(root);
		System.out.println();
		preorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
		levelorder(root);
	}
}
/*
7장. 연결 리스트를 이용한 이진트리의 순회
이진 트리를 입력받아 이를 중위순회, 전위순회, 후위순회, 레벨순회를 하여 그 결과를 출력하는 프로그램을 작성하시오.
    /***********************************
     * 아래 4개의 메소드를 작성하시오. *
     ***********************************/
/*
    public static void inorder(BinaryTree node) {

    }
    
    public static void preorder(BinaryTree node) {

    }
    
    public static void postorder(BinaryTree node) {

    }
        
    public static void levelorder(BinaryTree node) {

    }
}

예시 1
입력
( A ( B ( D ( H I ) E ( J null ) ) C ( F G ( K null ) ) ) )
출력
H D I B J E A F C K G
A B D H I E J C F G K
H I D J E B F K G C A
A B C D E F G H I J K
예시 2
입력
( A ( B ( D E ( null H ) ) C ( F G ( I null ) ) ) )
출력
D B E H A F C I G
A B D E H C F G I
D H E B F I G C A
A B C D E F G H I
예시3
입력
( A ( B ( C ( D null ) null ) null ) )
출력
D C B A
A B C D
D C B A
A B C D
예시4
입력
( + ( * ( 2 3 ) / ( 6 * ( 4 8 ) ) ) )
출력
2 * 3 + 6 / 4 * 8
+ * 2 3 / 6 * 4 8
2 3 * 6 4 8 * / +
+ * / 2 3 6 * 4 8

*/
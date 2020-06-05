package 제8장_이원탐색트리_삭제;

import java.io.*;
import java.util.Scanner;

class BinarySearchTree {
	class TreeNode {
		String key;
		TreeNode left;
		TreeNode right;
	}
	
	private TreeNode rootNode;
	
	public void insert(String x) {
		rootNode = insertKey(rootNode, x);
	}
	
	public TreeNode find(String x) {
		TreeNode t = rootNode;
		int result;
		
		while (t != null) {
			if ((result = x.compareTo(t.key)) < 0) {
				t = t.left;
			} else if (result == 0) {
				return t;
			} else {
				t = t.right;
			}
		}
		
		return t;
	}
	
	private void printNode(TreeNode n) {
		if (n != null) {
			System.out.print("(");
			printNode(n.left);
			System.out.print(n.key);
			printNode(n.right);
			System.out.print(")");
		}
	}
	
	public void print() {
		printNode(rootNode);
		System.out.println();
	}
	
	// 아래 2개의 메소드 insertKey, delete를 완성하시오.
	
	/**
	 * 교재 p.325 참조
	 * 이원탐색트리의 노드 t에 데이터 x를 추가한다. 순환함수로 작성해야 한다.
	 * @param t 이원탐색트리의 노드. 이 노드 아래에 데이터를 삽입한다.
	 * @param x 삽입하고자 하는 데이터
	 * @return 사입한 이원탐색트리의 부모 노드
	 */
	private TreeNode insertKey(TreeNode t, String x) {
		if (t == null) {
			TreeNode newNode = new TreeNode();
			newNode.key = x;
			return newNode;
		} else if (x.compareTo(t.key) < 0) {
			t.left = insertKey(t.left, x);
			return t;
		} else if (x.compareTo(t.key) > 0) {
			t.right = insertKey(t.right, x);
			return t;
		} else {
			return t;
		}
	}

	/**
	 * 교재 p.324 참조
	 * 이진 트리에서 x 를 찾아서 그 노드를 삭제한다.
	 * @param x 삭제하고자 하는 데이터
	 */
	public void delete(String x) {
		TreeNode findNode = find(x);
		TreeNode deleteNode = null;	//삭제할 key값을 가진 노드
		TreeNode parent = null;		//삭제할 노드의 부모 노드
		
		while(findNode != null) {
			if(findNode.key == x) {
				deleteNode = findNode;
				break;
			}
			parent = findNode;	//노드의 부모 노드를 기억
			if(findNode.key.compareTo(x) < 0) {
				findNode = findNode.right;
			} else {
				findNode = findNode.left;
			}
		}
		if (deleteNode == null) return;
		if(deleteNode.left == null && deleteNode.right == null) {
			if(parent.left.key.equals(deleteNode.key)) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if(deleteNode.left == null || deleteNode.right == null) {
			if(deleteNode.left != null) {
				if(parent.left.key.equals(deleteNode.key)) {
					parent.left = deleteNode.left;
				} else {
					parent.right = deleteNode.left;
				}
			} else {
				if(parent.left.key.equals(deleteNode.key)) {
					parent.left = deleteNode.right;
				} else {
					parent.right = deleteNode.right;
				}
			}
		} else {
			TreeNode q = deleteNode.left;
			deleteNode.key = q.key;
			delete(deleteNode.key);
		}
	}
}
	
class Main {
	
	// 아래 main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree tree = new BinarySearchTree();
		
		while (scan.hasNext()) {
			String command = scan.next();
			
			if (command.equals("I")) {
				String data = scan.next();
				tree.insert(data);
			} else if (command.equals("D")) {
				String data = scan.next();
				tree.delete(data);
			} else if (command.equals("P")) {
				tree.print();
			}
		}
		scan.close();
	}
	
}
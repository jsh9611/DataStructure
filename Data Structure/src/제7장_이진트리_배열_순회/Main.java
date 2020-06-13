package 제7장_이진트리_배열_순회;

import java.io.*;
import java.util.Scanner;

class BinaryTree {
	String[] array;
	public static final int INIT_SIZE = 10;
	public static final int ROOT = 1;
    
	public BinaryTree() {
		array = new String[INIT_SIZE];
	}
	
	public void set(int index, String data) {
		if (index >= array.length) {
			String[] newArray = new String[index + 10];
			for(int i = 0; i < array.length; i++)
				newArray[i] = array[i];
			array = newArray;
		}
		array[index] = data;
	}

	// 배열에서 원소를 얻는 메소드
	public String get(int index) {
		if (index >= array.length)
			return null;
		
		return array[index];
	}
	
	public void inorder() {
		inorder(ROOT);
	}
	
	public void preorder() {
		preorder(ROOT);
	}
	
	public void postorder() {
		postorder(ROOT);
	}
	
	public void levelorder() {
		levelorder(ROOT);
	}

	private void inorder(int idx) {
		if(idx >= array.length || array[idx] == null) return;
		inorder(idx*2);
		System.out.print(array[idx] + " ");
		inorder(idx*2+1);
	}
	
	private void preorder(int idx) {
		if(idx >= array.length || array[idx] == null) return;
		System.out.print(array[idx] + " ");
		preorder(idx*2);
		preorder(idx*2+1);
	}
	
	private void postorder(int idx) {
		if(idx >= array.length || array[idx] == null) return;
		postorder(idx*2);
		postorder(idx*2+1);
		System.out.print(array[idx] + " ");
	}
	
	private void levelorder(int idx) {
		for (int i = 0; i<array.length; i++) {
			if(array[i] == null) {
				continue;
			}
			System.out.print(array[i] + " ");
		}
	}
}

class Main {
	
	// 아래 main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		BinaryTree tree = new BinaryTree();
		
		int no = scan.nextInt();
		for(int i = 0; i < no; i++) {
			int index = scan.nextInt();
			String data = scan.next();
			
			tree.set(index, data);
		}
		
		scan.close();
		
		tree.inorder();
		System.out.println();
		
		tree.preorder();
		System.out.println();
		
		tree.postorder();
		System.out.println();
		
		tree.levelorder();
	}
}
package 제07장_이진트리_배열_순회;

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
/*
7장. 배열을 이용한 이진트리의 순회
이진 트리를 입력받아 이를 중위순회, 전위순회, 후위순회, 레벨순회를 하여 그 결과를 출력하는 프로그램을 작성하시오. 
이때 이진트리는 배열에 저장합니다.
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

    // 배열을 얻는 
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
    
    /*************************************
     * 작성해야 하는 함수
     *************************************/
/*
    private void inorder(int idx) {
       
    }
    
    private void preorder(int idx) {
        
    }
    
    private void postorder(int idx) {
        
    }
    
    private void levelorder(int idx) {
        
    }
}
예시 1
입력
11
1 A
2 B
3 C
4 D
5 E
6 F
7 G
8 H
9 I
10 J
14 K
출력
H D I B J E A F C K G
A B D H I E J C F G K
H I D J E B F K G C A
A B C D E F G H I J K
예시 2
입력
9
1 A
2 B
3 C
4 D
5 E
6 F
7 G
11 H
14 I
출력
D B E H A F C I G
A B D E H C F G I
D H E B F I G C A
A B C D E F G H I
예시 3
입력
9
1 +
2 *
3 /
4 2
5 3
6 6
7 *
14 4
15 8
출력
2 * 3 + 6 / 4 * 8
+ * 2 3 / 6 * 4 8
2 3 * 6 4 8 * / +
+ * / 2 3 6 * 4 8
예시4
입력
4
1 A
2 B
4 C
8 D
출력
D C B A
A B C D
D C B A
A B C D
*/
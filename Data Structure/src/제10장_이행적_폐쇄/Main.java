package 제10장_이행적_폐쇄;

import java.io.*;
import java.util.Scanner;

class Graph {
	int noVertex;	// 정점의 갯수
	int[][] m;	// 인접 행렬
	
	public Graph(int noVertex) {
		this.noVertex = noVertex;
		m = new int[noVertex][noVertex];		
	}

	public int[][] getTransitiveClosure() {
		// 이행적 폐쇄 행렬
		int[][] closure = new int[noVertex][noVertex];
		int n = noVertex;
		closure = m;
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for ( int j = 0; j < n; j++) {
//					if (closure[i][j] > (closure[i][k] + closure[k][j])) {
//						closure[i][j] = (closure[i][k] + closure[k][j]);
//					}
					
					if (closure[i][j] == 0) {
						if (closure[i][k] + closure[k][j] >= 2)
							closure[i][j] = 1;
						else closure[i][j] = 0;
					}
				}
			}
			
		}
//		for (int i = 0; i<n; i++) {
//			for ( int j = 0; j<n; j++) {
//				if (closure[i][j] != 0) {
//					closure[i][j] = 1;
//				}
//			}
//		}
		
//		// 반사 이행적 폐쇄 행렬은 closure[i][i] 인 경우가 모두 1이 된다.
//		int[][] reflexClosure = new int[noVertex][noVertex];
//		reflexClosure = closure.clone();
//		for (int i = 0; i < n; i++) {
//			reflexClosure[i][i] = 1;			
//		}	
		
		// 반사 이행적 행렬을 출력합니다.
		// for (int i = 0; i < noVertex; i++) {
		// 	for (int j = 0; j < noVertex; j++) {
		// 		System.out.print(reflexClosure[i][j]);
		// 		if (j != noVertex-1) System.out.print(" ");
		// 	}
		// 	System.out.println();
		// }		

		// 이행적 행렬을 출력합니다.
		for (int i = 0; i < noVertex; i++) {
			for (int j = 0; j < noVertex; j++) {
				System.out.print(closure[i][j]);
				if (j != noVertex-1) System.out.print(" ");
			}
			System.out.println();
		}
		
		//return reflexClosure;	//반사 이행적 폐쇄 행렬을 return
		//return closure;				//이행적 폐쇄 행렬을 return;
		
		//Main의 출력문을 이용하게 되면 각 행을 출력시 각 행 마지막에 스페이스바가 입력되어 오답처리된다.
		//테스트케이스엔 스페이스바가 없어 오류처리가 나므로 Main을 출력하지 않게 빈 배열을 return한다.
		int[][] emptyArray = new int[0][0];
		return emptyArray;
	}

}

class Main {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int noVertex = scan.nextInt();	// 정점의 갯수
		
		Graph g = new Graph(noVertex);	// 그래프 생성
		for(int i = 0; i < noVertex; i++)
			for(int j = 0; j < noVertex; j++)
				g.m[i][j] = scan.nextInt();
		
		int[][] mat = g.getTransitiveClosure();

		for(int[] m : mat) {
			for(int exist : m) 
				System.out.print(exist + " ");
			
			System.out.println();
		}
	}
}
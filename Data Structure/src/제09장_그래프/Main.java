package 제09장_그래프;

import java.io.*;
import java.util.Scanner;

// 필요한 메소드를 추가하여 아래 클래스를 완성하시오.
class Graph {
	
	Graph link;
	private int vertex;
	private int headListSize;	//정점의 개수
	
	//생성자
	public Graph(int noVertex) {
		this.link = null;
		vertex = noVertex;
		if(headListSize == 0) 
			headListSize = noVertex;
	}
	
	public int getVertex() {
		return vertex;
	}
	
	public void setVertex(int setVertex) {
		vertex = setVertex;
	}

	Graph[] headList; //vertex를 담을 배열 생성
	private int count;
	
	// 간선 (i, j)를 삽입
	public void addEdge(int i, int j) {
		if(count++ == 0) 
			headList = new Graph[headListSize];
		
		if(i >= headListSize || j >= headListSize)  //vertex 값이 잘못됬을 경우
			System.out.println("Error!");
		else {
			Graph add = new Graph(j);
			add.link = headList[i];
			headList[i] = add;
			
			Graph temp = headList[i];
			int tempValue;
			
			//오름차순으로 정렬
			while(temp.link != null) {
				if(temp.getVertex() > temp.link.getVertex()) { //정렬이 안되었을 경우 temp를 이용해 맞바꾼다
					tempValue = temp.link.getVertex();
					temp.link.setVertex(temp.getVertex());
					temp.setVertex(tempValue);
				}
				temp = temp.link;
			}
			
		}
	}
	
	// 간선 (i, j)를 삭제한다.
	public void removeEdge(int i, int j) {
		if(i >= headListSize || j >= headListSize)  //vertex 값이 잘못됬을 경우
			System.out.println("Error!");
		if(headList[i] != null) {
			while(headList[i].link != null) {
				if(headList[i].getVertex() == j) {
					headList[i] = null;
				}
				headList[i] = headList[i].link;
			}
		}
	}
	
	// BFS로 탐색하면서 방문하는 노드를 출력한다.
	public void bfs() {
		
	}
	
	// DFS로 탐색하면서 방문하는 노드를 출력한다.
	public void dfs() {
		
	}
	
	// 그래프를 출력하는 메소드이다.
	public void print() {
		for(int i = 0; i < headListSize; i++) {
			Graph temp = headList[i];
			System.out.print(i + " ");	//정점 출력
			
			while(temp.link != null) {
				System.out.print(temp.getVertex() + " "); //정점 리스트 temp.link가 null이 아닐때까지 출력
				temp = temp.link;
			}
			System.out.println(temp.getVertex());	//정점 리스트 출력

		}
	}
}

class Main {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		int noVertex = scan.nextInt();
		Graph graph = new Graph(noVertex);

		for(int i = 0; i < noVertex; i++) {
			for(int j = 0; j < noVertex; j++) {
				int vertex = scan.nextInt();
				if (vertex == 1)
					graph.addEdge(i, j);
			}
		}
		
		
		while(scan.hasNext()) {
			String cmd = scan.next();
			if (cmd.equals("P"))
				graph.print();
			else if (cmd.equals("I")) {
				int from = scan.nextInt();
				int to = scan.nextInt();
				graph.addEdge(from, to);
			} else if (cmd.equals("D")) {
				int from = scan.nextInt();
				int to = scan.nextInt();
				graph.removeEdge(from, to);
			} else if (cmd.equals("DFS")) {
				graph.dfs();
			} else if (cmd.equals("BFS")) {
				graph.bfs();
			} else if (cmd.equals("E")) { // 종료한다.
				break;
			}
		}
		
		scan.close();		
	}
}
/*
입력1
4
0 1 0 1
1 0 1 1
0 1 0 1
1 1 1 0
P
출력
0 1 3
1 0 2 3
2 1 3
3 0 1 2
*/
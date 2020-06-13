package 제9장_그래프;

import java.io.*;
import java.util.Scanner;

// 필요한 메소드를 추가하여 아래 클래스를 완성하시오.
class Graph {
	
	// 필요한 field, method는 추가하시오.
	
	
	// 생성자를 작성하시오.
	public Graph(int noVertex) {
		
	}
	
	// 간선 (i, j)를 삽입한다.
	public void addEdge(int i, int j) {
		
	}
	
	// 간선 (i, j)를 삭제한다.
	public void removeEdge(int i, int j) {
		
	}
	
	// BFS로 탐색하면서 방문하는 노드를 출력한다.
	public void bfs() {
		
	}
	
	// DFS로 탐색하면서 방문하는 노드를 출력한다.
	public void dfs() {
		
	}
	
	// 그래프를 출력하는 메소드이다.
	public void print() {
		
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
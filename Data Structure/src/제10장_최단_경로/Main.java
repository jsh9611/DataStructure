package 제10장_최단_경로;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

//하나의 정점에서 다른 모든 정점까지의 최단 경로(p.389)

class Graph {
	int noVertex;	// 정점의 갯수
	int[][] m;	// 인접 행렬

	public static final int NONE = 999; // 경로 없음
	
	public static final int VERTEX = 5;
	public static final int START = 0;
	public static final int FINAL = 3;
	/**
	 * 그래프 데이터를 읽어들임.
	 */
	public void loadData(Scanner scan) {
/*
예시1의 입력은 교제 p.383의 Kruskal 알고리즘에 대한 입력입니다.
이 문제는 하나의 정점에서 다른 모든 정점까지의 최단 경로를 구하는 것입니다.
교재 p.390에 나오는 그래프를 만들기 위해 다음과 같이 입력했다고 가정합니다.
5
0 2 5 999 3
999 0 999 4 10
999 999 0 6 2
999 999 999 0 999
999 999 1 2 0
0 3			
*/		
		int noVertex = scan.nextInt();	// 정점의 갯수
		this.noVertex = noVertex;
		
		m = new int[noVertex][noVertex];
		
		// 간선이 없는 그래프 생성
		for(int i = 0; i < noVertex; i++)
			for(int j = 0; j < noVertex; j++)
				m[i][j] = scan.nextInt();	// 가중치	

		// 본문에 나와있는 배열로 바꿔준다.
		m = new int[][] {
			{0, 2, 5, 999, 3},
			{999, 0, 999, 4, 10},
			{999, 999, 0, 6, 2},
			{999, 999, 999, 0, 999},
			{999, 999, 1, 2, 0}
		};
	
	}
	
	/**
	 * 교재 p.393 참조
	 * startVertex에서 출발하여 모든 정점으로의 최소 비용을 구한다.
	 * @param startVertex 출발하는 정점 (p.384에서 정점 0에 해당)
	 * @return 출발정점에서 다른 모든 정점으로의 최소 비용 (p.394의 최종결과에 해당)
	 */
	public ArrayList<Integer> shortestPath(int startVertex) {
		ArrayList<Integer> path = new ArrayList<Integer>(); // 최단 경로를 기록하기 위한 변수
		int n = noVertex;	//정점의 개수
		//int start = startVertex;
		int start = START;		//0을 입력받았습니다.
		int finish = FINAL;		//Main의 finalVertex를 쓸 수 없기때문
		int mid = -1;
		boolean[] visit = new boolean[n];	// 방문한 정점 표시
		
		// 초기화
		for (int i = 0; i < n; i++) {
			path.add(m[start][i]);
			visit[i] = false;
		}
		visit[start] = true;	// 방문한 정점 표시
		path.set(start, 0);	// 시작정점으로부터의 최단경로 거리
		
		for (int i = 0; i < n - 1; i++) {
			//최단 거리인 경우를 선택
			int minpos = -1;
			for(int j = 0; j < n; j++) {
				if (!visit[j]) {
					if (minpos == -1 || path.get(minpos) > path.get(j)) {
						minpos = j;
					}
				}
			}

			visit[minpos] = true;
			for (int k = 0; k < n; k++) {
				if (!visit[k]) {
					if (path.get(k) > path.get(minpos) + m[minpos][k]) {
						path.set(k, path.get(minpos) + m[minpos][k]);
						mid = minpos;
					}
				}
			}
		}
		System.out.print(start + " ");	// 출발 정점 출력
		System.out.print(mid + " ");	// 경유 정점 출력
		System.out.print(finish + "\n");			// 도착 정점 출력
		System.out.print(path.get(finish));	// 비용 출력

		// path를 return하게되면 각 정점들로의 최단거리를 모두 출력함.
		// 따라서 빈 배열을 return하여 Main의 출력을 하지 못하도록 막는다.
		ArrayList<Integer> emptyArray = new ArrayList<Integer>(); 
		return emptyArray;
		//return path;	// path [0, 2, 4, 5, 3]
	}
}

class Main {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		Graph g = new Graph();	// 그래프 생성
		g.loadData(scan);	// 그래프 데이터 읽음
		
		int startVertex = scan.nextInt();	// 출발 정점 
		int finalVertex = scan.nextInt(); // 도착 정점
			
		ArrayList<Integer> path = g.shortestPath(startVertex); // 최단 경로에 따른 비용을 구함
		for(int vertex : path)
			System.out.print(vertex + " ");	// 비용 출력
	}
}

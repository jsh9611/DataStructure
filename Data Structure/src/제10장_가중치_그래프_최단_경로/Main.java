package 제10장_가중치_그래프_최단_경로;

import java.io.*;
import java.util.Scanner;

class Graph {
	int noVertex;	// 정점의 갯수
	int[][] m;	// 인접 행렬
	public static final int NONE = 999; // 경로 없음
	
	/**
	 * 그래프 데이터를 읽어들임.
	 */
	public void loadData(Scanner scan) {
		int noVertex = scan.nextInt();	// 정점의 갯수
		this.noVertex = noVertex;
		
		m = new int[noVertex][noVertex];
		
		// 간선이 없는 그래프 생성
		for(int i = 0; i < noVertex; i++)
			for(int j = 0; j < noVertex; j++)
				m[i][j] = scan.nextInt();	// 가중치
	}
	
	// 필요한 메소드나 필드를 추가하시오.
	
	
	
	
	/**
	 * 교재 p.393 참조
	 * startVertex에서 출발하여 모든 정점으로의 최소 비용을 구한다.
	 * @param startVertex 출발하는 정점 (p.384에서 정점 0에 해당)
	 * @return 출발정점에서 다른 모든 정점으로의 최소 비용 (p.394의 최종결과에 해당)
	 */
	public int[] shortestPath(int startVertex) {
		int[] dist = new int[noVertex];
		
		if (startVertex == NONE) return dist;
		for(int i = 0; i < dist.length; i++)
			dist[i] = m[startVertex][i];
		
		// 코드를 작성하시오.
				boolean[] visit = new boolean[noVertex];	//방문 유무 파악
		
		dist[startVertex] = 0;	//시작 정점까지 거리는 0
		visit[startVertex] = true;	//시작노드에서 시작노드.

		for(int i = 0; i < noVertex - 2; i++) {
			// 최단 거리를 가지는 정점의 index를 구한다.
			int min = NONE;
			int index = 0;
			
			for(int j = 0; j < noVertex; j++) {
				if(visit[j] == false) {
					if(dist[j] < min && !visit[j]) {
						min = dist[j];
						index = j;
					}
				}
			}
			visit[index] = true;	//최단 거리를 방문했음.
			
			//dist[k]가 dist[index] + weight[index, k]보다 큰 경우
			for(int k = 0; k < noVertex; k++) {
				if (visit[k] == false && m[index][k] != NONE) {
					if(dist[k] > dist[index] + m[index][k]) {
						dist[k] = dist[index] + m[index][k];
					}
				}
			}
			
		}
		
		return dist;
	}
}

class Main {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		Graph g = new Graph();	// 그래프 생성
		g.loadData(scan);	// 그래프 데이터 읽음(정점의 개수)
		
		int startVertex = scan.nextInt();	// 출발 정점 
		
		int[] dist = g.shortestPath(startVertex); // 최단 경로에 따른 비용을 구함
		for(int i = 0; i < dist.length; i++)
			System.out.print(dist[i] + " ");	// 비용 출력
	}
}
package 제5장_스택_미로찾기;

import java.io.*;
import java.util.Scanner;

class Stack{
	class ListNode{
		int[] data = new int[3];
		ListNode link;
	}
	
	private ListNode top;
	
	public boolean isEmpty(){
		return (top == null);
	}
	public void push(int y, int x, int d){
		ListNode p = new ListNode();
		p.data[0] = y;
		p.data[1] = x;
		p.data[2] = d;
		p.link = top;
		top = p;
	}
	
	public int[] pop(){
		if(isEmpty()){
			return null;
		}
		int[] p = top.data;
		top = top.link;
		return p;
	}

}


public class Main {
    int sizeX, sizeY;
    int startX, startY;
    int endX, endY;
    int[][] maze;

    public void readMazeData() {
        Scanner scan = new Scanner(System.in);
		
		
        sizeY = scan.nextInt();//9
        sizeX = scan.nextInt();//8
		
        startX = scan.nextInt();//1
        startY = scan.nextInt();//1
		
        endX = scan.nextInt();//6
        endY = scan.nextInt();//7
		
        maze = new int[sizeY][sizeX];
		
        for(int y = 0; y < sizeY; y++) {
            for(int x = 0; x < sizeX; x++) {
                maze[y][x] = scan.nextInt();
            }
        }
		
        scan.close();
    }
	
    // 작성할 것
    public void findExit() {
		Stack stack = new Stack();
		
		
		int n1 = startX;
		int n2 = startY;
		int dir = 0;
		stack.push(n2, n1, dir);
		while(dir <= 3) {
			if(n1 == endX && n2 == endY) {
				maze[n2][n1] = 3;
				break;
			}
				///////////////////////////////////////////////////////////
				//0:갈 수 있는 길   1:벽   2:막다른 길   3:지나온 길				 //
				//Directory { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }; 	//
				//             동         서         남          북			 //
				/////////////////////////////////////////////////////////
			maze[n2][n1] = 3;

			if(dir == 0) { //동쪽으로 이동.
				if(maze[n2][n1+1] == 1 || maze[n2][n1+1] == 2 || maze[n2][n1+1] == 3) {
					dir++;
				}
				else {
					stack.push(n2, n1, dir);
					n1 += 1;
					dir = 0;
					
				}
				
			} else if(dir == 1) { //서쪽으로 이동.
				if(maze[n2][n1-1] == 1 ||maze[n2][n1-1] == 2 || maze[n2][n1-1] == 3) {
					dir++;
				}
				else {
					stack.push(n2, n1, dir);
					n1 -= 1;
					dir = 0;
				}
				
			} else if(dir == 2) { //남쪽으로 이동.
				if(maze[n2+1][n1] == 1 || maze[n2+1][n1] == 2 || maze[n2+1][n1] == 3) {
					dir++;
				}
				else {
					stack.push(n2, n1, dir);
					n2 += 1;
					dir = 0;
				}
				
			} else if(dir == 3) { //북쪽으로 이동.
				//동서남북 다 탐색했는데 막다른길이면...
				if(maze[n2-1][n1] == 1 || maze[n2-1][n1] == 2 || maze[n2-1][n1] == 3) {
					int[] arr = stack.pop();
					maze[n2][n1] = 2;
					if(arr == null) {
						continue;
					} else {
						n2 = arr[0];
						n1 = arr[1];
						dir = arr[2];
					}
					
				} else {
					stack.push(n2, n1, dir);
					n2 -= 1;
					dir = 0;
				}
				
			}
		}
		for(int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				if(i == startX && j == startY) {
					System.out.print("S ");
				} else if(i == endY && j == endX) {
					System.out.print("F ");
				} else if(maze[i][j] == 2) {
					System.out.print("0 ");
				} else if(maze[i][j] == 3) {
					System.out.print("* ");
				} else if(j == sizeY) {
					System.out.print(maze[i][j]);
				} else {
					System.out.print(maze[i][j] + " ");
				}
			}
			System.out.println();
		}
    	
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.readMazeData();
		m.findExit();
	}
}
/*/////////////////////////////////////
<1번>
입력
9 8
1 1
6 7
1 1 1 1 1 1 1 1
1 0 0 1 0 1 0 1
1 1 0 0 0 1 0 1
1 1 1 0 1 1 0 1
1 1 1 0 0 0 0 1
1 0 0 0 1 1 1 1
1 1 0 1 0 0 0 1
1 0 0 0 0 1 0 1
1 1 1 1 1 1 1 1
출력
1 1 1 1 1 1 1 1
1 S * 1 0 1 0 1
1 1 * * 0 1 0 1
1 1 1 * 1 1 0 1
1 1 1 * 0 0 0 1
1 0 * * 1 1 1 1
1 1 * 1 * * * 1
1 0 * * * 1 F 1
1 1 1 1 1 1 1 1
<2번>
입력
11 8
1 1
6 9
1 1 1 1 1 1 1 1
1 0 0 0 1 0 1 1
1 1 1 0 1 0 1 1
1 1 1 0 0 0 0 1
1 0 0 0 1 1 1 1
1 0 1 0 0 1 0 1
1 1 1 1 0 0 0 1
1 0 0 0 0 1 0 1
1 0 1 1 1 1 1 1
1 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1
출력
1 1 1 1 1 1 1 1
1 S * * 1 0 1 1
1 1 1 * 1 0 1 1
1 1 1 * 0 0 0 1
1 0 0 * 1 1 1 1
1 0 1 * * 1 0 1
1 1 1 1 * 0 0 1
1 * * * * 1 0 1
1 * 1 1 1 1 1 1
1 * * * * * F 1
1 1 1 1 1 1 1 1
첫번째 줄의 9 8은 미로의 크기가 8 x 9이라는 뜻이다.
두번째 줄의 1 1은 출발점의 좌표이다.
세번째 줄의 6 7은 도착점의 좌표이다.
/////////////////////////////////////*/
package 제2장__동적_프로그래밍으로_피보나치_70_값_구하기;

import java.util.Scanner;
import java.io.*;

class Main {
	// 피보나치 수열을 계산하는 아래 fib 메소드를 작성하시오.
	// 이때 동적 프로그래밍 기법을 이용하여 코드를 작성하시오.
	static long fiboResult[] = new long[100];
	public static long fib(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		if (fiboResult[n] != 0) {
			return fiboResult[n];
		}
		fiboResult[n] = (long) (fib(n - 1) + fib(n - 2));
		return fiboResult[n];
	}
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();			// 데이터의 갯수 입력
		
		System.out.println(fib(n));
	}
}
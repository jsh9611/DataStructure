package 제3장__배열을_이용한_다항식_덧셈;

import java.io.*;
import java.util.Scanner;

class Polynomial {
	private int[][] term;
	private static int curNoTerm = 0;

	// @param noTerm 항의 개수
	public Polynomial(int noTerm) {
		term = new int[noTerm][2];
	}

	public Polynomial() {
		this(20); // default로 최대 20개의 항을 저장함
	}

	/**
	 * @param coef 계수
	 * @param exp  지수
	 */
	static int nextStart = 0;

	public void addTerm(int coef, int exp) {
		term[curNoTerm][0] = exp; //
		term[curNoTerm][1] = coef;
		if (curNoTerm != 0) {
			if (term[curNoTerm][0] > term[curNoTerm - 1][0]) {
				nextStart = curNoTerm;
			}
		}
		curNoTerm++;

	}

	// @param exp
	// 작성하시오
	public void delTerm(int exp) {

	}

	/**
	 * 출력할 때 사용
	 * 
	 * @return 객체를 문자열로 반환 (예: 3x^15+2x^3+4x^2+x+5 ) 작성하시오.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("");
		for (int i = curNoTerm; i < curNoTerm * 2; i++) {
			if (term[i][1] == 0 && term[i][0] == 0) {
				if (term[curNoTerm][1] == 0)
					str.append("0");
				break;
			}
			if (term[i][1] == 0)
				break;
			if (term[i][0] == 0) {
				str.append(term[i][1]);
				break;
			}
			if (term[i][1] == 1) {
				str.append("x").append("+");
				continue;
			}
			str.append(term[i][1]).append("x^").append(term[i][0]);
			if (term[i + 1][1] != 0)
				str.append("+");
		}
		return str.toString();
	}

	/**
	 * 두 개의 다항식을 더한다.
	 * 
	 * @param p1 첫번째 다항식
	 * @param p2 두번째 다항식
	 * @return
	 * @return 두 개의 다항식을 더한 결과 작성할 것
	 */

	public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {
		Polynomial p3 = new Polynomial();
		int p1Num = 0, p2Num = nextStart, p3Num = curNoTerm;//
		while (p1Num < nextStart && p2Num < curNoTerm) {
			if (p1.term[p1Num][0] > p2.term[p2Num][0]) {
				p3.term[p3Num][0] = p1.term[p1Num][0];
				p3.term[p3Num][1] = p1.term[p1Num][1];
				p1Num++;
				p3Num++;
			} else if (p1.term[p1Num][0] == p2.term[p2Num][0]) {
				p3.term[p3Num][0] = p1.term[p1Num][0];
				p3.term[p3Num][1] = p1.term[p1Num][1] + p2.term[p2Num][1];

				if (p3.term[p3Num][1] == 0) {
					p1Num++;
					p2Num++;
					continue;
				}
				p1Num++;
				p2Num++;
				p3Num++;

			} else {
				p3.term[p3Num][0] = p2.term[p2Num][0];
				p3.term[p3Num][1] = p2.term[p2Num][1];
				p2Num++;
				p3Num++;
			}
		}
		if (p1Num < nextStart) {
			for (int i = p1Num; i < nextStart; i++) {
				p3.term[p3Num][0] = p1.term[p1Num][0];
				p3.term[p3Num][1] = p1.term[p1Num][1];
				p1Num++;
				p3Num++;
			}

		} else if (p2Num < curNoTerm) {
			for (int i = p2Num; i < curNoTerm; i++) {
				p3.term[p3Num][0] = p2.term[p1Num][0];
				p3.term[p3Num][1] = p2.term[p1Num][1];
				p2Num++;
				p3Num++;
			}
		}

		return p3;
	}

}

class Main {

	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		// 첫번째 다항식 입력
		Polynomial p1 = new Polynomial();
		int no = scan.nextInt();
		for (int i = 0; i < no; i++) {
			int coef = scan.nextInt();
			int exp = scan.nextInt();
			p1.addTerm(coef, exp);
		}

		Polynomial p2 = new Polynomial();
		// 두번째 다항식 입력 코드 작성할 것
		int no2 = scan.nextInt();
		for (int i = 0; i < no2; i++) {
			int coef = scan.nextInt();
			int exp = scan.nextInt();
			p2.addTerm(coef, exp);
		}

		// 두개의 다항식 덧셈
		Polynomial p3 = Polynomial.polyAdd(p1, p2);

		System.out.print(p3); // 이것은 System.out.print(p3.toString())과 동일
	}
}
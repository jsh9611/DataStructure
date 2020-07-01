package 제03장__희소_행렬의_전치_행렬_구하기;

import java.io.*;
import java.util.Scanner;

class SparseMatrix {
	int[][] m;
	int nRows;
	int nCols;
	int nTerms;

	public SparseMatrix(int row, int col, int no){
		m = new int[no+1][3];
		m[0][0] = row;
		m[0][1] = col;
		m[0][2] = no;
		this.nCols = row;
		this.nRows = col;
		this.nTerms = no;
	}

	public void transpose(){
		SparseMatrix b = new SparseMatrix(nCols, nRows, nTerms);
		int[] rowTerm = new int[nCols];
		int[] rowBegins = new int[nCols];
		if(nTerms > 0){
			for(int i = 0; i < nCols; i++){
				rowTerm[i] = 0;
			}
			for(int i = 0; i < nTerms; i++){
				rowTerm[ m[i + 1][1] ]++;
			}
			
			rowBegins[0] = 1;
			for(int i = 1; i < nCols; i++){
				rowBegins[i] = rowBegins[i-1] + rowTerm[i-1];
			}
			
			for(int i = 1; i <= nTerms; i++){
				int no = rowBegins[ m[i][1] ]++;
				b.m[no][0] = m[i][1];
				b.m[no][1] = m[i][0];
				b.m[no][2] = m[i][2];
			}
		}
		m = b.m;
	}
	
	public String toString(){
		StringBuffer str = new StringBuffer();
		
		for(int i=0; i <= m[0][2]; i++){
			str.append(m[i][0]).append(" ").append(m[i][1]).append(" ").append(m[i][2]).append("\n");
		}
		return str.toString();
	}
}

class Main {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int col = scan.nextInt();
		int row = scan.nextInt();
		int no = scan.nextInt();

		SparseMatrix matrix = new SparseMatrix(row, col, no);

		for(int i = 1; i <= no; i++) {
			matrix.m[i][0] = scan.nextInt();
			matrix.m[i][1] = scan.nextInt();
			matrix.m[i][2] = scan.nextInt();
		}

		matrix.transpose();

		System.out.print(matrix);
	}
}
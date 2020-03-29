package com.example.first;

import java.util.ArrayList;
import java.util.Iterator;

public class Ass3_Question3 {
	public double solution(int n){
		double [][] matrix = 
			   {{0, 0, 0.2, 0, 0, 0, 0, 0, 0, 0},
	            {0, 0, 0, 0, 0, 0, 0, 0.4, 0, 0},
	            {0.3, 0, 0, 0.1, 0, 0, 0.2, 0, 0, 0},
	            {0, 0, 0.4, 0, 0, 0, 0, 0.3, 0, 0.5},
	            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0.6},
	            {0, 0, 0, 0, 0, 0, 0.3, 0, 0, 0},
	            {0, 0, 0.2, 0, 0, 0.3, 0, 0, 0, 0},
	            {0, 0.2, 0, 0.2, 0, 0, 0, 0, 0, 0},
	            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0.2},
	            {0, 0, 0, 0.1, 0.6, 0, 0, 0, 0.1, 0}};
		int result = 1;
		boolean [][] visit = new boolean[matrix.length][matrix[0].length];
		ArrayList<Double>lists = new ArrayList<Double>();
		getSum(matrix, 1, n, Float.valueOf(1), visit, 1.0, lists);
		double sum = 1;
		Iterator<Double>ite = lists.iterator();
		while(ite.hasNext()){
			sum += ite.next();
		}
		return sum;
	}
	
	public int getSum(double [][] matrix, int sum, int n, double result, boolean [][] visit, double final_result, ArrayList<Double>lists){
		if(sum == 10){
			return sum;
		}
		for(int i=0;i<matrix[n].length;i++){
			if(matrix[n][i] != 0 && !visit[n][i]){
				sum++;
				visit[n][i] = true;
				visit[i][n] = true;
				matrix[n][i] = result * matrix[n][i];
				lists.add(matrix[n][i]);
				final_result += matrix[n][i];
				sum = getSum(matrix, sum, i, matrix[n][i], visit, final_result, lists);
			}
		}
		return sum;
	}
}

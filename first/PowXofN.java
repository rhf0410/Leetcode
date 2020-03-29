package com.example.first;

public class PowXofN {
	/**
	 * Calculating pow(x, n).
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
        if(x == 0){
        	return 0.0;
        }
        if(n > 0){
        	return Pow(x, n);
        }else{
        	return 1 / Pow(x, -n);
        }
    }
	
	private double Pow(double x, int n){
		if(n == 0)
			return 1;
		double mid = Pow(x, n/2);
		if(n%2 == 0){
			return mid * mid;
		}else{
			return mid * mid * x;
		}
	}
}

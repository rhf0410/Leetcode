package com.example.first;

import java.util.ArrayList;

public class AddBinaries {
	/**
	 * Add two binaries
	 * @param a:num1
	 * @param b:num2
	 * @return
	 */
    public String addBinary(String a, String b) {
        if(a == null && b == null)
        	return null;
        ArrayList<Integer>lists = new ArrayList<Integer>();
        int length = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int n = 0;
        int i = a.length() - 1,j = b.length() - 1;
        for(;i>=0 && j>=0;i--,j--){
        	int num = (a.charAt(i) - '0') + (b.charAt(j) - '0') + n;
        	n = num/2;
        	sb.append(num%2);
        }
        while(i>=0){
        	int num = (a.charAt(i) - '0') + n;
        	n = num/2;
        	sb.append(num%2);
        	i--;
        }
        while(j>=0){
        	int num = (b.charAt(j) - '0') + n;
        	n = num/2;
        	sb.append(num%2);
        	j--;
        }
        if(n != 0)
            sb.append(n);
        String result = sb.reverse().toString();
        return result;
    }
}

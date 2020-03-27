package com.example.first;

import java.util.HashMap;

public class IntegertoRoman {
	/**
	 * Convert Integer into Roman Numeral
	 * @param num:target
	 * @return Roman Integer
	 */
    public String intToRoman(int num) {
    	if(num < 1 || num > 3999){
    		return null;
    	}
    	
        String result = new String("");
        //The foundamental roman integer.
        HashMap<Integer,String>hash = new HashMap<Integer,String>();
        hash.put(1, "I");
        hash.put(4, "IV");
        hash.put(5, "V");
        hash.put(9, "IX");
        hash.put(10, "X");
        hash.put(40, "XL");
        hash.put(50, "L");
        hash.put(90, "XC");
        hash.put(100, "C");
        hash.put(400, "CD");
        hash.put(500, "D");
        hash.put(900, "CM");
        hash.put(1000, "M");
        int [] ind = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int [] count = new int [1001];
        for(int i = 0;i<ind.length;i++){
        	if(num/ind[i] != 0){
        		count[ind[i]] = num/ind[i];
        		for(int j=0;j<count[ind[i]];j++){
        			result += hash.get(ind[i]);
        		}
        		num %= ind[i];
        	}
        }
        
        return result;
    }
}

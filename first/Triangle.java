package com.example.first;

import java.util.Iterator;
import java.util.List;

public class Triangle {
	/**
	 * Find the minimal path.
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null)
        	return 0;
        if(triangle.size() == 1)
        	return triangle.get(0).get(0);
        int result = Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++){
        	List<Integer>list1 = triangle.get(i-1);
        	for(int j=0;j<triangle.get(i).size();j++){
        		int num = triangle.get(i).get(j);
        		if(j>0 && j<triangle.get(i).size()-1){
        			triangle.get(i).set(j, Math.min(num + list1.get(j), num + list1.get(j - 1)));
        		}else if(j == 0){
        			triangle.get(i).set(j, num + list1.get(0));
        		}else if(j == triangle.get(i).size()-1){
        			triangle.get(i).set(j, num + list1.get(list1.size() - 1));
        		}
        	}
        	if(i == triangle.size()-1){
        		Iterator<Integer>ite = triangle.get(i).iterator();
        		while(ite.hasNext()){
        			result = Math.min(result, ite.next());
        		}
        	}
        }
        return result;
    }
}

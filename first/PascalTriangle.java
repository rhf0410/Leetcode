package com.example.first;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	/**
	 * Pascal Triangle.
	 * @param numRows
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
        List<List<Integer>>result = new ArrayList<List<Integer>>();
        ArrayList<Integer>list = new ArrayList<Integer>();
        list.add(1);
        result.add(list);
        for(int i=1;i<rowIndex+1;i++){
        	List<Integer>sublist = new ArrayList<Integer>();
        	List<Integer>priorList = result.get(result.size() - 1);
        	for(int j=0;j<priorList.size();j++){
        		if(j-1 < 0){
        			sublist.add(priorList.get(j));
        		}else{
        			sublist.add(priorList.get(j) + priorList.get(j-1));
        		}
        	}
        	sublist.add(priorList.get(priorList.size() - 1));
        	result.add(sublist);
        }
        return result.get(result.size()-1);
    }
}

package com.leetcode.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode406 {
	public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0)
        	return people;

        for(int i=0;i<people.length;i++){
        	for(int j=i+1;j<people.length;j++){
        		if(people[j][0] > people[i][0]){
        			int [] temp = people[j];
        			people[j] = people[i];
        			people[i] = temp;
        		}else if(people[j][0] == people[i][0] && people[j][1] < people[i][1]){
        			int [] temp = people[j];
        			people[j] = people[i];
        			people[i] = temp;
        		}
        	}
        }
        List<int []>order = new ArrayList<int []>();
        for(int i=0;i<people.length;i++){
        	int [] arr = people[i];
        	order.add(arr[1], arr);
        }
        
        for(int i=0;i<order.size();i++){
        	people[i] = order.get(i);
        }
        return people;
    }
}

package com.example.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
	/**
	 * Find prerequisites
	 * @param numCourses:the number of courses
	 * @param prerequisites:prerequisites
	 * @return
	 */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>>map = new HashMap<Integer, List<Integer>>();
        int [] in = new int [numCourses];
        for(int i=0;i<prerequisites.length;i++){
        	int first = prerequisites[i][1];
        	int second = prerequisites[i][0];
        	if(!map.containsKey(first)){
        		map.put(first, new ArrayList<Integer>());
        	}
        	map.get(first).add(second);
        	in[second]++;
        }
        
        Queue<Integer>queue = new LinkedList<Integer>();
        for(int i=0;i<in.length;i++){
        	if(in[i] == 0){
        		queue.add(i);
        	}
        }
        
        int num = 0;
        while(!queue.isEmpty()){
        	num++;
        	int node = queue.poll();
        	if(!map.containsKey(node))
        		continue;
        	List<Integer>list = map.get(node);
        	for(int i=0;i<list.size();i++){
        		int n = list.get(i);
        		in[n]--;
        		if(in[n] == 0){
        			queue.add(n);
        		}
        	}
        }
        return num == numCourses;
    }
}

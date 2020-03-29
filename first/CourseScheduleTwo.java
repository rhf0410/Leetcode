package com.example.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseScheduleTwo {
	/**
	 * Find the schedule of courses
	 * @param numCourses:the number of courses
	 * @param prerequisites:prior courses
	 * @return
	 */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	if(prerequisites == null || numCourses == 0)
    		return null;
        HashMap<Integer,List<Integer>>map = new HashMap<Integer,List<Integer>>();
        ArrayList<Integer>result = new ArrayList<Integer>();
        //Initializing
        for(int i=0;i<numCourses;i++){
        	List<Integer>list = new ArrayList<Integer>();
        	map.put(i, list);
        }
        int [] in = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
        	int x = prerequisites[i][1];
        	int y = prerequisites[i][0];
        	map.get(x).add(y);
        	in[y]++;
        }
        boolean [] visit = new boolean[numCourses];
        for(int i=0;i<in.length;i++){
        	if(in[i] == 0 && !visit[i]){
        		result.add(i);
        		List<Integer>list = map.get(i);
        		for(int j=0;j<list.size();j++){
        			in[list.get(j)]--;
        		}
        		visit[i] = true;
        		i=-1;
        	}
        }
        int [] results = new int[result.size()];
        for(int i=0;i<result.size();i++)
        	results[i] = result.get(i);
        return results.length == numCourses ? results : new int[0];
    }
}

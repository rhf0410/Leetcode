package com.example.second;

import java.util.Iterator;
import java.util.Stack;

public class Leetcode735 {
	/**
	 * Asteroid collision.
	 * @param asteroids
	 * @return
	 */
	public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0){
        	return null;
        }
        Stack<Integer>stack = new Stack<Integer>();
        stack.push(asteroids[0]);
        for(int i=1;i<asteroids.length;i++){
        	int num = asteroids[i];
        	if(stack.isEmpty() || num * stack.peek() > 0){
        		stack.push(num);
        	}else{
        		boolean flag = false;
        		while(!stack.isEmpty() && num<0 && stack.peek() > 0){
        			int num2 = stack.pop();
    				if(num + num2 == 0){
    					flag = true;
    					break;
    				}
    				num = Math.abs(num) > Math.abs(num2) ? num : num2;
        		}
        		if(!flag)
        			stack.push(num);
        	}
        }
        int [] result = new int [stack.size()];
        Iterator<Integer>ite = stack.iterator();
        int i=0;
        while(ite.hasNext()){
        	result[i++]=ite.next();
        }
        return result;
    }
}

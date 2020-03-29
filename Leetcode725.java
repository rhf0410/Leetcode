package com.example.second;

import java.util.ArrayList;
import java.util.List;

public class Leetcode725 {
	/**
	 * Split linked list into parts.
	 * @param root
	 * @param k
	 * @return
	 */
	public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode [] results = new ListNode [k];
        ListNode temp = root;
        int length = 0;
        while(temp != null){
        	length++;
        	temp = temp.next;
        }
        int [] nums = new int [length];
        for(int i=0;i<length;i++){
        	nums[i] = i+1;
        }
        int [] numsarray = this.newproblem(nums, k);
        ListNode node1 = root;
        for(int i=0;i<numsarray.length;i++){
        	ListNode node = new ListNode(0);
        	ListNode head = node;
        	for(int j=0;j<numsarray[i];j++){
        		ListNode rnode = new ListNode(node1.val);
        		node.next = rnode;
        		node = node.next;
        		node1 = node1.next;
        	}
        	node.next = null;
        	results[i] = head.next;
        }
        return results;
    }
	
	public int[] newproblem(int [] nums, int m){
    	List<List<Integer>>result =new ArrayList<List<Integer>>();
    	int [] numsizes = new int [m];
    	int n = nums.length;
    	int size = n%m;
    	for(int i=0;i<m;i++){
    		numsizes[i] = n/m;
    	}
    	int k = 0;
    	while(size > 0){
    		numsizes[k]++;
    		k++;
    		size--;
    	}
    	return numsizes;
    }
	
	public void addElement(ListNode head, int ele){
		ListNode node = head;
		while(node.next != null){
			node = node.next;
		}
		node.next = new ListNode(ele);
	}
	
	public void printList(ListNode head){
		ListNode ls = head;
		while(ls != null){
			System.out.print(ls.val + " ");
			ls = ls.next;
		}
	}
}

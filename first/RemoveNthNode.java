package com.example.first;

public class RemoveNthNode {
	
	  //Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null)
    		return null;
    	
    	int length = theLengthofLink(head);
    	int len = length - n;
    	ListNode l = head;
    	while(l != null && len - 1 != 0){
    		l = l.next;
    		len--;
    	}
    	//Remove operation.
    	ListNode t = l.next;
    	l.next = t.next;
    	t.next = null;
        return head;
    }
    
    /**
     * the length of linked list.
     * @param head
     * @return
     */
    public int theLengthofLink(ListNode head){
    	int size = 0;
    	ListNode l = head;
    	while(l != null){
    		size++;
    		l = l.next;
    	}
    	return size;
    }
}

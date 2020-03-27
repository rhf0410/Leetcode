package com.example.first;

public class InsertionSort {
	/**
	 * Insertion sort.
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList(ListNode head) {
        if(head == null)
        	return null;
        if(head.next == null)
        	return head;
        
        ListNode previous = new ListNode(0);
        previous.next = head;
        ListNode node2 = head.next;
        while(node2 != null){
        	ListNode node1 = previous;
        	while(node1.next != node2){
        		if(node2.val < node1.next.val){
            		ListNode newnode = new ListNode(node2.val);
            		newnode.next = node1.next;
            		node1.next = newnode;
            		deleteNode(head, node2);
            		break;
            	}
        		node1 = node1.next;
        	}
        	node2 = node2.next;
        }
        return previous.next;
    }
	
	private void deleteNode(ListNode head, ListNode node2){
		ListNode node = head;
		while(node.next != node2){
			node = node.next;
		}
		node.next = node2.next;
	}
	
	public void addElement(ListNode head, int ele){
		ListNode node = new ListNode(ele);
		node.next = null;
		ListNode ref = head;
		while(ref.next != null)
			ref = ref.next;
		ref.next = node;
	}
	
	public void print(ListNode head){
		ListNode node = head;
		while(node != null){
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}

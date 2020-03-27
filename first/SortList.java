package com.example.first;

public class SortList {
	/**
	 * Sort List.
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		int length = lengthList(head);
		ListNode list1 = head;
		ListNode list2 = head;
		ListNode node = head;
		ListNode previous = new ListNode(0);
		for(int i=0;i<length/2;i++){
			previous = node;
			node = node.next;
		}
		list2 = node;
		previous.next = null;
		
		ListNode new_list1 = sortList(list1);
		ListNode new_list2 = sortList(list2);
		ListNode t = Merge(new_list1, new_list2);
        return t;
    }
	
	public ListNode Merge(ListNode list1, ListNode list2){
		ListNode node1 = list1;
		ListNode node2 = list2;
		ListNode head = new ListNode(0);
		ListNode head1 = head;
		while(node1 != null && node2 != null){
			if(node1.val < node2.val){
				ListNode node = new ListNode(node1.val);
				head.next = node;
				head = node;
				node1 = node1.next;
			}else{
				ListNode node = new ListNode(node2.val);
				head.next = node;
				head = node;
				node2 = node2.next;
			}
		}
		while(node1 != null){
			ListNode node = new ListNode(node1.val);
			head.next = node;
			head = node;
			node1 = node1.next;
		}
		while(node2 != null){
			ListNode node = new ListNode(node2.val);
			head.next = node;
			head = node;
			node2 = node2.next;
		}
		return head1.next;
	}
	
	public int lengthList(ListNode head){
		int length = 0;
		if(head == null)
			return length;
		ListNode node = head;
		while(node != null){
			length++;
			node = node.next;
		}
		return length;
	}
	
	public void printList(ListNode head){
		ListNode node = head;
		while(node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}
	
	public void addElement(ListNode head, int ele){
		ListNode node = head;
		while(node.next != null){
			node = node.next;
		}
		node.next = new ListNode(ele);
	}
}

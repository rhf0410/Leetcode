package com.example.second;

public class Leetcode109 {
	/**
	 * Convert linklist to binary search tree.
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBST(ListNode head) {
        return findNode(head, null);
    }
	
	private TreeNode findNode(ListNode head, ListNode tail){
		if(head == tail)
        	return null;
		ListNode fast = head;
        ListNode slow = head;
        while(fast != tail){
        	fast = fast.next;
        	if(fast != tail){
        		fast = fast.next;
        		slow = slow.next;
        	}
        }
        TreeNode t = new TreeNode(slow.val);
        t.left = findNode(head, slow);
        t.right = findNode(slow.next, tail);
        return t;
	}
}

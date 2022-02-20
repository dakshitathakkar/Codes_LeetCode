/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode curr = middleNode(head);
        if(head.next == null){
            return null;
        }
        if(head.next.next == null){
            head.next = null;
            return head;
        }
        ListNode currN = curr.next;
        curr.val = currN.val;
        curr.next = currN.next;
        return head;
        
    }
    
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
}
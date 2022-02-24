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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeTwoSort(l1,l2);
    }
    
    // public ListNode midNode(ListNode head){
    //     if(head == null || head.next == null)
    //         return head;
    //     ListNode fast = head;
    //     ListNode slow = head;
    //     while(fast != null && fast.next != null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return slow;
    // }
    
    public ListNode mergeTwoSort(ListNode p1, ListNode p2){
        if(p1 == null || p2 == null)
            return p1==null?p1:p2;
        ListNode h3 = new ListNode(-1);
        ListNode p3 = h3;
        
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p3.next = p1;
                p1 = p1.next;
                p3 = p3.next;
            }
            else{
                p3.next = p2;
                p2 = p2.next;
                p3 = p3.next;
            }
        }
        while(p1 != null){
            p3.next = p1;
            p1 = p1.next;
            p3 = p3.next;
        }
        
        while(p2 != null){
            p3.next = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        
        return h3.next;
    }
}
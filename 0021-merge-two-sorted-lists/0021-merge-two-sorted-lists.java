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
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode h3 = new ListNode();
        ListNode p1 = h1;
        ListNode p2 = h2;
        ListNode p3 = h3;
        
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p3.next = p1;
                p1 = p1.next;
            }
            else{
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
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
        h3 = h3.next;
        return h3;
    }
}
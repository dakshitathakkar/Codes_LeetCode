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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode itr = new ListNode(-1);
        ListNode temp = itr;
        temp.next = head;
        ListNode curr = head.next;
        while(curr != null){
            boolean flag = false;
            while(curr != null && curr.val == temp.next.val){
                flag = true;
                curr = curr.next;
            }
            if(flag){
                temp.next = curr;
            }
            else{
                temp = temp.next;
            }
            if(curr!= null)
            curr = curr.next;
        }
        return itr.next;
    }
}
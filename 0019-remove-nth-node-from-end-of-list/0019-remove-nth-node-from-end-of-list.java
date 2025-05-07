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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        int x = count - n;
        
        if(x == 0){
            return head.next;
        }
        int i = 1;
        curr = head;
        while(curr != null && i!=x){
            i++;
            curr = curr.next;
        }
        // System.out.println(curr.val);
        //else
        curr.next = curr.next.next;
        return head;
    }
}
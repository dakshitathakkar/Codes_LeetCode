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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode curr1 = head;
        ListNode curr2 = head.next;
        ListNode temp = curr2;
        while(curr2!=null && curr2.next!=null){
            curr1.next = curr1.next.next;
            curr2.next = curr2.next.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        curr1.next = temp;
        // while(curr2 != null && curr2.next !=null){
        //      //System.out.println(curr1.val + " " + curr2.val);
        //     curr1.next = curr2;
        //     curr2 = curr2.next.next;
        //     curr1 = curr1.next;
        // }
        return head;

    }
}
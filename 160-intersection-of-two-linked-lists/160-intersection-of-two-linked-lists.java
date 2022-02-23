/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int c1 = getCount(headA);
        int c2 = getCount(headB);
        int d = Math.abs(c1-c2);
        ListNode curr1;
        ListNode curr2;
        if(c1 > c2){
            curr1 = headA;
            curr2 = headB;
        }
        else{
            curr1 = headB;
            curr2 = headA;
        }
        for(int i = 0; i<d; i++){
            curr1 = curr1.next;
        }
        while(curr1 != null && curr2 != null){
            if(curr1 == curr2)
                return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
            return null;
    }
    
    public int getCount(ListNode curr){
        int count = 0;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
    }
}
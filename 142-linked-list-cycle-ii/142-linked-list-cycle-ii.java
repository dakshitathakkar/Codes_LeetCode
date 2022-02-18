/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        boolean flag = false;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            
            if(s==f){
                flag = true;
                break;
            }
        }
        if(flag){
            ListNode sDash = head;
            while(true){
                if(s == sDash){
                    return s;
                }
                sDash = sDash.next;
                s = s.next;
            }
        }
        return null;
    }
}
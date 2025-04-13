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
    public ListNode middleNode(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int count = 0;
        ListNode curr = head;
        while(curr!=null){
            count++;
            map.put(count,curr);
            curr = curr.next;
        }
        return map.get((count/2)+1);
    }
}
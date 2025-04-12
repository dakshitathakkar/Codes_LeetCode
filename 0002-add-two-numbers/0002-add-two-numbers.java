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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        int carryOver = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryOver;
            if (sum >= 10) {
                carryOver = sum / 10;
                sum = sum % 10;

            } else {
                carryOver = 0;
            }
            ListNode curr = new ListNode(sum);
            prev.next = curr;
            prev = prev.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carryOver;
            if (sum >= 10) {
                carryOver = sum / 10;
                sum = sum % 10;

            } else {
                carryOver = 0;
            }
            ListNode curr = new ListNode(sum);
            prev.next = curr;
            prev = prev.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carryOver;
            if (sum >= 10) {
                carryOver = sum / 10;
                sum = sum % 10;
            } else {
                carryOver = 0;
            }
            ListNode curr = new ListNode(sum);
            prev.next = curr;
            prev = prev.next;
            l2 = l2.next;
        }
        if(carryOver != 0){
            ListNode carried = new ListNode(carryOver);
            prev.next= carried;
        }
        return dummyHead.next;
    }
}
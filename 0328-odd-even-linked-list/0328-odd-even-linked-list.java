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
        if(head==null)  return null;
        Queue<ListNode> odd = new LinkedList<>();
        Queue<ListNode> even = new LinkedList<>();
        ListNode curr = head;
        int pointer = 1;
        while(curr!=null){
            if(pointer%2!=0){
                odd.offer(curr);
            }
            else{
                even.offer(curr);
            }
            curr = curr.next;
            pointer++;
        }

        curr = head;
        while(!odd.isEmpty()){
            curr.next = odd.poll();
            curr = curr.next;
        }
        while(!even.isEmpty()){
            curr.next = even.poll();
            curr = curr.next;
        }
        curr.next = null;
        return head;

    }
}
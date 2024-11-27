/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                if (node2.val > node1.val) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                pq.add(curr);
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }
        ListNode root = pq.poll();
        ListNode curr = root;
        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;
        }
        return root;
    }
}
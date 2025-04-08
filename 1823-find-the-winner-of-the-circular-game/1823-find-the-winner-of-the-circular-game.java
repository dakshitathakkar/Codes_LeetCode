class Solution {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public int findTheWinner(int n, int k) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        for(int i=1;i<=n;i++){
            Node curr = new Node(i);
            temp.next = curr;
            temp = curr;
            if(i==n){
                curr.next = dummy.next;
            }
        }
        int count = n;
        Node curr = dummy;
        Node prev = dummy;
        while(count > 1){
            for(int i=0;i<k;i++){
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            count--;
            curr = prev;
            // dummy.next = curr;
        }
        return prev.next.val;
    }
}
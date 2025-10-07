class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

class MyHashSet {
    Node head;
    public MyHashSet() {
        head = null;
    }
    
    public void add(int key) {
        if(head == null){
            head = new Node(key);
            return;
        }

        if(!contains(key)){
            Node temp = head;
            while(temp.next != null){
            temp = temp.next;
            }
            temp.next = new Node(key);
        }
    }
    
    public void remove(int key) {
        if(head == null) return;
        if(head != null && head.val == key){
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            if(temp.next.val == key){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
    
    public boolean contains(int key) {
        Node temp = head;
        while(temp != null){
            if(temp.val == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Node clone = new Node(node.val);
        Node[] visited = new Node[101];
        dfs(node, clone, visited);
        return clone;
    }

    public void dfs(Node node, Node clone, Node[] visited) {
        visited[clone.val] = clone;
        for (Node n : node.neighbors) {
            if (visited[n.val] == null) {
                Node newNode = new Node(n.val);
                clone.neighbors.add(newNode);
                dfs(n, newNode, visited);
            } else {
                clone.neighbors.add(visited[n.val]);
            }
        }
    }

}
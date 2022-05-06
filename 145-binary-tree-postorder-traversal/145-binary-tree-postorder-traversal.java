/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root == null)    return res;
        TreeNode curr = root;
        s.push(curr);
        while(!s.isEmpty()){
            curr = s.pop();
            res.add(0,curr.val);
            
            if(curr.left!= null)    s.push(curr.left);
            if(curr.right != null)  s.push(curr.right);
        }
        return res;
    }
}
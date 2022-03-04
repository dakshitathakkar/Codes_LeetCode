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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(!s.isEmpty() || temp != null){
            if(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            else{
                temp = s.pop();
                res.add(temp.val);
                temp = temp.right;
            }
        }
        return res;
    }
}
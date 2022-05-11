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
    List<Integer> ls = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return ls;
        helper(root,0);
        return ls;
        
    }
    public void helper(TreeNode root, int level){
        if(root == null){
            return;  
        }
        if(level == ls.size()){
            ls.add(root.val);
        }
        helper(root.right,level+1);
        helper(root.left,level+1);
        
    }
}
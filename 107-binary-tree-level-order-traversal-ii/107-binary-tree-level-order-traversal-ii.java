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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<Integer>();
            int s = q.size();
            for(int i=0; i<s; i++){
                TreeNode curr = q.poll();
                l.add(curr.val);
                if(curr.left != null)   q.add(curr.left);
                if(curr.right != null)  q.add(curr.right);
            }
            res.add(0,l);
        }
        return res;
    }
}
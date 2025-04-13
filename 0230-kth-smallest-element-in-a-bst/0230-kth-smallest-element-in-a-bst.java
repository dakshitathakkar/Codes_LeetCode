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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[]{0};
        int[] ks = new int[]{Integer.MIN_VALUE};
        inorder(root,k,count,ks);
        return ks[0];
    }

    public void inorder(TreeNode root, int k, int[] count, int[] ks){
        if(root == null || count[0]>=k){
            return;
        }
        inorder(root.left,k,count,ks);
        count[0]++;
        if(count[0] == k){
            ks[0] = root.val;
            return;
        }
        inorder(root.right,k,count,ks);
    }
}
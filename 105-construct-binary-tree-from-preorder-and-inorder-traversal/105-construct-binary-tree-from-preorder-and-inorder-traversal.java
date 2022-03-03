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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int is = 0;
        int ie = preorder.length - 1;
        TreeNode root = buildTreeUtil(preorder, inorder, is, ie);
        return root;
    }
    
    public TreeNode buildTreeUtil(int[] pre, int[] in, int is, int ie){
        if(is > ie){
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex++]);
        int inIndex = 0;
        for(int i = is; i<=ie; i++){
            if(in[i] == root.val){
                inIndex = i;
                break;
            }
        }
        
        root.left = buildTreeUtil(pre,in,is,inIndex-1);
        root.right = buildTreeUtil(pre,in,inIndex+1,ie);
        return root;
    }
}
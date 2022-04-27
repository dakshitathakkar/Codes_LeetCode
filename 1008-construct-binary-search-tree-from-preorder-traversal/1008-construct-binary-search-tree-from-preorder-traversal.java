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
    int nodeIdx;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0)
            return null;
        nodeIdx = 0;
        TreeNode head = helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return head;
        
    }
    
    public TreeNode helper(int[] preorder, int min, int max){
        if(nodeIdx == preorder.length || preorder[nodeIdx] < min || preorder[nodeIdx] > max)
            return null;
        
        int val = preorder[nodeIdx++];
        TreeNode node = new TreeNode(val);
        node.left = helper(preorder,min,val);
        node.right = helper(preorder,val,max);
        
        return node;
    }
}
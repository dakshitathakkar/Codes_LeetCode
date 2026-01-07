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
    public int maxProduct(TreeNode root) {
        long[] sum = new long[1];
        long[] max = new long[1];
        long totalSum = findSubTrees(root, 0, max, sum);
        findSubTrees(root, totalSum, max, sum);
        return (int) (max[0] % (1e9+7));
        
    }

    public long findSubTrees(TreeNode root, long totalSum, long[] max, long[] currSum){
        if(root==null){
            return 0;
        }
        currSum[0] = findSubTrees(root.left,totalSum,max,currSum) + findSubTrees(root.right,totalSum,max,currSum) + root.val;
        long prod = currSum[0] * (totalSum - currSum[0]);
        max[0] = Math.max(max[0],prod);
        return currSum[0];

    }
}
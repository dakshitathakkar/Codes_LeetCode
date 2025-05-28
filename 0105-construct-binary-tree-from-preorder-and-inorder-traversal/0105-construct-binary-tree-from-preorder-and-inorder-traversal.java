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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildPreTree(preorder,inorder,map,0,inorder.length-1,0,preorder.length-1);
    }
    public TreeNode buildPreTree(int[] preorder, int[] inorder, Map<Integer,Integer> map, int is, int ie, int ps, int pe){
        if(ps>pe || is>ie){
            return null;
        }
        TreeNode node = new TreeNode(preorder[ps]);
        int inR = map.get(node.val);
        int numsLeft = inR-is;
        node.left = buildPreTree(preorder,inorder,map,is,inR-1,ps+1,ps+numsLeft);
        node.right = buildPreTree(preorder,inorder,map,inR+1,ie,ps+numsLeft+1,pe);
        return node;
    }
}
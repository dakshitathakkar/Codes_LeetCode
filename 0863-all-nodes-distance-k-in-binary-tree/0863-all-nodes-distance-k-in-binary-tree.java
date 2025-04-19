/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        Map<TreeNode,Integer> visited = new HashMap<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left != null){
                queue.offer(curr.left);
                parentMap.put(curr.left,curr);
            }
            if(curr.right != null){
                queue.offer(curr.right);
                parentMap.put(curr.right,curr);
            }
        }

        queue.offer(target);
        while(k>0 && !queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                visited.put(curr,1);
                if(curr.left != null && !visited.containsKey(curr.left)){
                    queue.offer(curr.left);
                }
                if(curr.right != null && !visited.containsKey(curr.right)){
                    queue.offer(curr.right);
                }
                if(parentMap.containsKey(curr) && !visited.containsKey(parentMap.get(curr))){
                    queue.offer(parentMap.get(curr));
                }
            }
            k--; 
        }

        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }
        return result;
    }
}
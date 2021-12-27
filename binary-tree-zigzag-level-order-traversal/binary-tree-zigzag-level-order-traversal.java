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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root != null)
            q.offer(root);
        
        int level = 0;
        
        List<List<Integer>> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            
            LinkedList<Integer> levelItems = new LinkedList<>();
            for(int i = 0 ; i < size ; i++) {
                TreeNode curr = q.poll();
                if(level % 2 == 0)
                    levelItems.addLast(curr.val);
                else
                    levelItems.addFirst(curr.val);
                
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            
            res.add(levelItems);
            level++;
        }
        
        return res;
    }
}
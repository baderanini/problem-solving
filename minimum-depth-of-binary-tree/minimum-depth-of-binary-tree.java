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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root != null)
            q.offer(root);
        
        int level = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0 ; i < size ; i++) {
                TreeNode curr = q.poll();
                if(curr.left == null && curr.right == null)
                    return level;
                
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            
            level++;
        }
        
        return 0;
    }
}
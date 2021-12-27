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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode root, int runningSum) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 10 * runningSum + root.val; 
        
        return dfs(root.left, 10 * runningSum + root.val) + dfs(root.right, 10 * runningSum + root.val);
    }
}
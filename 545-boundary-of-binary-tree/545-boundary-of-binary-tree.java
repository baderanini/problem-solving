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
    
    final int LEFT = 1;
    final int RIGHT = 2;
    final int NONE = 3;
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root != null) {
             result.add(root.val);
            dfs(root.left, LEFT, result);
            dfs(root.right, RIGHT, result);
        }
        
        return result;
    }
    
    
    public void dfs(TreeNode root, int type, List<Integer> result) {
        if(root == null)
            return;
        
        if(type == LEFT || isLeaf(root))
            result.add(root.val);
        if(root.left == null)
            dfs(root.right, type == LEFT || type == RIGHT ? type : NONE, result);
        else if(root.right == null)
            dfs(root.left, type == LEFT || type == RIGHT ? type : NONE, result);
        else {
            dfs(root.left, type == LEFT ? type : NONE, result);
            dfs(root.right, type == RIGHT ? type : NONE, result);
        }
        if(type == RIGHT && !isLeaf(root))
            result.add(root.val);
    }
    
    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
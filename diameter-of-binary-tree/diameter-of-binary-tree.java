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

class Pair {
    int maxLength;
    int maxDiameter;
    
    Pair(int maxLength, int maxDiameter) {
        this.maxLength = maxLength;
        this.maxDiameter = maxDiameter;
    }
}
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root).maxDiameter;
    }
    
    Pair dfs(TreeNode root) {
        
        if(root == null)
            return new Pair(0, 0);
        Pair leftRes = dfs(root.left);
        Pair rightRes = dfs(root.right);
        
        int myDiameter = leftRes.maxLength + rightRes.maxLength;
        
        return new Pair(1 + Math.max(leftRes.maxLength, rightRes.maxLength), Math.max(myDiameter, Math.max(leftRes.maxDiameter, rightRes.maxDiameter)));
    }
}
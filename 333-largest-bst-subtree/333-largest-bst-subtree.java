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

class Result {
    int max;
    int min;
    int size;
    int maxSize;
    boolean isBST;
    Result(int min, int max, int size, int maxSize, boolean isBST) {
        this.max = max;
        this.min = min;
        this.size = size;
        this.maxSize = maxSize;
        this.isBST = isBST;
    }
}
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root, -1).maxSize;
    }
    
    Result dfs(TreeNode root, int parentVal) {
        if(root == null)
            return null;
                
        Result leftRes = dfs(root.left, root.val);
        Result rightRes = dfs(root.right, root.val);
        
        boolean isRightValid =  rightRes == null || (rightRes.min > root.val && rightRes.isBST);
        boolean isLeftValid  =  leftRes == null  || (leftRes.max  < root.val && leftRes.isBST);
                
        leftRes = leftRes != null ? leftRes : new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0, true);
        rightRes = rightRes != null ? rightRes : new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0, true);
        
        boolean isBST = isRightValid && isLeftValid;
        
        int currSize = 1 + leftRes.size + rightRes.size;
        
        
        return new Result(Math.min(root.val, Math.min(leftRes.min, rightRes.min)), Math.max(root.val, Math.max(leftRes.max, rightRes.max)), currSize, isBST ? currSize : Math.max(leftRes.maxSize, rightRes.maxSize), isBST);
    }
}
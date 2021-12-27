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

// named treeTrainRec to mark questions solved before intreviews.

class Result {
    int maxSumDeep;
    int maxSum;
    
    Result(int maxSumDeep, int maxSum) {
        this.maxSumDeep = maxSumDeep;
        this.maxSum = maxSum;
    }
}
class Solution {
    public int maxPathSum(TreeNode root) {
        Result res = dfs(root);
        return res.maxSum;
    }
    
    Result dfs(TreeNode root) {
        if(root == null)
            return new Result(0, Integer.MIN_VALUE);
        
        Result leftRes = dfs(root.left);
        Result rightRes = dfs(root.right);
        
        int sumOfCurrAndLeft =  root.val + leftRes.maxSumDeep;
        int sumOfCurrAndRight = root.val + rightRes.maxSumDeep;
        int sumOfCurrAndRightLeft = root.val + leftRes.maxSumDeep + rightRes.maxSumDeep;
        int maxSumPassingCurrNode = Math.max(root.val, Math.max(sumOfCurrAndRightLeft, Math.max(sumOfCurrAndLeft, sumOfCurrAndRight)));
        
        return new Result(Math.max(root.val,(Math.max(sumOfCurrAndLeft, sumOfCurrAndRight))), Math.max(maxSumPassingCurrNode, Math.max(leftRes.maxSum, rightRes.maxSum)));
    }
}
    
    

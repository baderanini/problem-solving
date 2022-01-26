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
    int longestFromMe;
    
    Result(int max, int longestFromMe) {
        this.max = max;
        this.longestFromMe = longestFromMe;
    }
}

class Solution {
    public int longestConsecutive(TreeNode root) {
        return dfs(root).max;
    }
    
    Result dfs(TreeNode root) {
        if(root == null)
            return new Result(0, 0);
        
        
        Result res = new Result(1, 1);
        if(root.left == null && root.right == null)
            return res;
        
        if(root.left != null) {
            Result leftRes = dfs(root.left);
            if(root.left.val == root.val + 1) {
                res.longestFromMe = 1 + leftRes.longestFromMe;
            }
            res.max = Math.max(res.longestFromMe, leftRes.max);
        }
        if(root.right != null) {
            Result rightRes = dfs(root.right);
            if(root.right.val == root.val + 1) {
                res.longestFromMe = Math.max(res.longestFromMe, 1 + rightRes.longestFromMe);
            }
            res.max = Math.max(res.max, Math.max(res.longestFromMe, rightRes.max));
        }
        
        return res;
    }
    
}
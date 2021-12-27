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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> sumFreqs = new HashMap<>();
        return dfs(root, targetSum, sumFreqs, 0);
        
        
    }
    
    int dfs(TreeNode root, int targetSum, Map<Integer, Integer> sumFreqs, int runningSum) {
        if(root == null)
            return 0;
        
        runningSum += root.val;
        
        sumFreqs.put(runningSum, sumFreqs.getOrDefault(runningSum, 0) + 1);
        
        int needed = runningSum - targetSum;
        int neededFreq = sumFreqs.getOrDefault(needed, 0);
        int myResult = neededFreq;
        if(runningSum == targetSum)
            myResult++;
        if(targetSum == 0)
            myResult--;
        
        int res = myResult + dfs(root.left, targetSum, sumFreqs, runningSum) + dfs(root.right, targetSum, sumFreqs, runningSum);
            
        sumFreqs.put(runningSum, sumFreqs.getOrDefault(runningSum, 0) - 1);
        return res;
    }    
}
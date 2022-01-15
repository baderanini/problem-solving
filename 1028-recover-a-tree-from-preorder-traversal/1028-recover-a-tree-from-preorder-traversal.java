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

class TraversalIndex {
    int index;
    
    TraversalIndex(int index) {
        this.index = index;
    }
}
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        return dfs(traversal, new TraversalIndex(0), 0);
    }
    
    TreeNode dfs(String traversal, TraversalIndex ti, int level) {
        if(ti.index >= traversal.length())
            return null;
        char curr = traversal.charAt(ti.index);
        
        int checkingIndex = ti.index;
        int num = 0;
        while(checkingIndex < traversal.length() && Character.isDigit(traversal.charAt(checkingIndex)))
            num = num * 10 + (traversal.charAt(checkingIndex++) - '0');
        
        
        if(num > 0) {
            ti.index = checkingIndex;
            TreeNode currNode = new TreeNode(num);
            currNode.left = dfs(traversal, ti, level);
            currNode.right = dfs(traversal, ti, level);
            return currNode;
        }
        
        checkingIndex = ti.index;
        int dashCount = 0;
        while(traversal.charAt(checkingIndex) == '-') {
            dashCount++;
            checkingIndex++;
        }
                
        if(dashCount > level) {
            ti.index = checkingIndex;
            return dfs(traversal, ti, dashCount);
        }
        
        return null;
    }
}
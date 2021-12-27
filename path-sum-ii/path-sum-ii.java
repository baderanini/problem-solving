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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        else if(root.left == null && root.right == null) {
            if(root.val == targetSum) {
                List<Integer> subRes = new ArrayList<>();
                subRes.add(root.val);
                res.add(subRes);
            }
        } else {
            List<List<Integer>> leftRes = pathSum(root.left, targetSum - root.val);
            List<List<Integer>> rightRes = pathSum(root.right, targetSum - root.val);
            
            for(List<Integer> list: leftRes) {
                list.add(0, root.val);
                res.add(list);
            }
            
            for(List<Integer> list: rightRes) {
                list.add(0, root.val);
                res.add(list);
            }
        }
        
        return res;
    }
}
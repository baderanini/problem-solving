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
    public List<List<Integer>> findLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Map<TreeNode, Integer> inDegrees = new HashMap<>();
        dfs(root, null, parents, inDegrees);
        
        Queue<TreeNode> q = new LinkedList<>();
        
        for(Map.Entry<TreeNode, Integer> entry: inDegrees.entrySet()) {
            if(entry.getValue() == 0)
                q.offer(entry.getKey());
        }
        
        
        List<List<Integer>> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> subResult = new ArrayList<>();
            for(int i = 0 ; i < size ; i++) {
                TreeNode curr = q.poll();
                subResult.add(curr.val);
                
                TreeNode parent = parents.get(curr);
                if(parent != null) {
                    inDegrees.put(parent, inDegrees.get(parent) - 1);
                    if(inDegrees.get(parent) == 0)
                        q.offer(parent);
                }
            }
            result.add(subResult);
        }
        
        return result;
        
    }
    
    void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parents, Map<TreeNode, Integer> inDegrees) {
        if(root == null)
            return;
        
        parents.put(root, parent);
        int inDegree = 0;
        if(root.left != null)
            inDegree++;
        if(root.right != null)
            inDegree++;
        
        inDegrees.put(root, inDegree);
        dfs(root.left, root, parents, inDegrees);
        dfs(root.right, root, parents, inDegrees);
    }
}
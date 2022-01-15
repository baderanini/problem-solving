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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int treeSize = postorder.length;
        Map<Integer, Integer> inorderIndices = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++) {
            inorderIndices.put(inorder[i], i);
        }
                
        return helper(postorder, inorder, inorderIndices, 0, treeSize - 1, 0, treeSize - 1);
    }
    
    TreeNode helper(int[] postorder, int[] inorder, Map<Integer, Integer> inorderIndices, int inSt, int inEnd, int pSt, int pEnd) {
        if(inSt > inEnd || pSt > pEnd)
            return null;
        int rootVal = postorder[pEnd];
        int rootInorderIndex = inorderIndices.get(rootVal);
        int leftTreeSize = rootInorderIndex - inSt;
        int rightTreeSize = inEnd - rootInorderIndex;
        
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(postorder, inorder, inorderIndices, inSt, rootInorderIndex - 1, pSt, pSt + leftTreeSize - 1);
        root.right = helper(postorder, inorder, inorderIndices, rootInorderIndex + 1, inEnd, pSt + leftTreeSize, pEnd - 1);
        
        return root;
    }
}
    
// inoder	    [left, root, right]
// postorder   	[left, right, root]
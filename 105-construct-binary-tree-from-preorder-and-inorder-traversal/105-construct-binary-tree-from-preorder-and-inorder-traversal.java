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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int treeSize = preorder.length;
        Map<Integer, Integer> inorderIndices = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++) {
            inorderIndices.put(inorder[i], i);
        }
                
        return helper(preorder, inorder, inorderIndices, 0, treeSize - 1, 0, treeSize - 1);
    }
    
    TreeNode helper(int[] preorder, int[] inorder, Map<Integer, Integer> inorderIndices, int inSt, int inEnd, int pSt, int pEnd) {
        if(inSt > inEnd || pSt > pEnd)
            return null;
        int rootVal = preorder[pSt];
        int rootInorderIndex = inorderIndices.get(rootVal);
        int leftTreeSize = rootInorderIndex - inSt;
        int rightTreeSize = inEnd - rootInorderIndex;
        
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, inorder, inorderIndices, inSt, rootInorderIndex - 1, 1 + pSt, pSt + leftTreeSize);
        root.right = helper(preorder, inorder, inorderIndices, rootInorderIndex + 1, inEnd, pSt + leftTreeSize + 1, pEnd);
        
        return root;
    }
}



// inoder		[left, root, right]
// preorder	    [root, left, right]
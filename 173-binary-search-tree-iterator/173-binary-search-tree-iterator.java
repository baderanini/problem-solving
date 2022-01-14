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
class BSTIterator {
    
    TreeNode curr = null;
    Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        curr = root;
    }

    
    public int next() {
        while(hasNext()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode toBeReturned = stack.pop();
                curr = toBeReturned.right;
                return toBeReturned.val;
            }
        }
        return -1;
    }
    
    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
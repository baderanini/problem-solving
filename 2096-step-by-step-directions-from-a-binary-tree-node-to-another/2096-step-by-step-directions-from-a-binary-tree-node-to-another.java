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
    StringBuilder dirs = new StringBuilder();
    boolean constructed = false;
    boolean start = true;
    Result() {}

    Result(StringBuilder dirs) {
        this.dirs = dirs;
    }
}

class Solution {
    final char LEFT = 'L', RIGHT = 'R', UP = 'U';
    public String getDirections(TreeNode root, int startValue, int destValue) {
        return getDirections(root, startValue, destValue, '-').dirs.toString();
    }

    public Result getDirections(TreeNode root, int startValue, int destValue, char direction) {
        if (root == null)
            return null;
        Result leftRes = getDirections(root.left, startValue, destValue, LEFT);
        Result rightRes = getDirections(root.right, startValue, destValue, RIGHT);

        Result nodeRes = new Result();

        if (leftRes != null && rightRes != null)
            return processWithLeftAndRight(leftRes, rightRes);
        else if (leftRes != null || rightRes != null) {
            Result nonNullRes = leftRes != null ? leftRes : rightRes;
            return processWithLeftOrRight(root, nonNullRes, startValue, destValue, direction);
        } else if (root.val == startValue || root.val == destValue) {
            Result res = new Result(new StringBuilder(String.valueOf(direction)));
            if (root.val == destValue)
                res.start = false;
            return res;
        }
        return null;
    }

    Result processWithLeftAndRight(Result leftRes, Result rightRes) {
        Result startRes = leftRes.start ? leftRes : rightRes;
        Result destRes = leftRes.start ? rightRes : leftRes;

        destRes.dirs.reverse();
        Result nodeRes = new Result(allUps(startRes.dirs.length()).append(destRes.dirs));
        nodeRes.constructed = true;
        return nodeRes;
    }

    Result processWithLeftOrRight(TreeNode root, Result leftOrRightRes, int startValue, int destValue, char direction) {
        if (leftOrRightRes.constructed) {
            return leftOrRightRes;
        } else if (root.val == startValue) {
            leftOrRightRes.constructed = true;
            leftOrRightRes.dirs.reverse();
            return leftOrRightRes;
        } else if (root.val == destValue) {
            Result nodeRes = new Result(allUps(leftOrRightRes.dirs.length()));
            nodeRes.constructed = true;
            return nodeRes;
        } else {
            leftOrRightRes.dirs.append(direction);
            return leftOrRightRes;
        }
    }

    StringBuilder allUps(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++)
            sb.append(UP);

        return sb;
    }
}
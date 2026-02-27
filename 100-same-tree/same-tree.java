// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Case 1: Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // Case 2: One is null, one is not
        if (p == null || q == null) {
            return false;
        }

        // Case 3: Values are different
        if (p.val != q.val) {
            return false;
        }

        // Case 4: Check left and right subtree
        return isSameTree(p.left, q.left) && 
               isSameTree(p.right, q.right);
    }
}
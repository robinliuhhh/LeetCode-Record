/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return dfs(pRoot.left, pRoot.right);
    }

    boolean dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;

        if (t1 != null && t2 != null)
            // 利用短路特性 值不同直接返回false 不用再递归
            return t1.val == t2.val && dfs(t1.left, t2.right) && dfs(t1.right, t2.left);

        return false;
    }
}
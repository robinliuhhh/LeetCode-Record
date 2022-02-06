// 剪枝 从下往上遍历
// 如果发现子树不是平衡二叉树 则直接停止 这样至多只对每个结点访问一次
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }
    
    public int getDepth(TreeNode root) {
        
        if(root == null) return 0;
        if(getDepth(root.left) == -1) return -1;
        if(getDepth(root.right) == -1) return -1;
        
        return Math.abs(getDepth(root.left) - getDepth(root.right)) > 1 ? -1
            : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}

/*
// 未剪枝
import java.lang.Math;
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        // 判断左右两个子树的高度差 && 左右两个子树都是一棵平衡二叉树
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <=1 && IsBalanced_Solution(root.left) &&IsBalanced_Solution(root.right);
    }
    
    
    // 获取左右两个子树的最大高度
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
*/
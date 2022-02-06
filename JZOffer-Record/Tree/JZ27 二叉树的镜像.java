/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */
import java.util.*;
public class Solution {
    public TreeNode Mirror (TreeNode pRoot) {
        
        if(pRoot == null) return null;
        
		// 后序遍历思想 先处理根 再递归左右子树
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        
        return pRoot;
    }
}

/**
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
	// 初始为null
    TreeNode pre;
	
    public TreeNode Convert(TreeNode pRootOfTree) {
        
        if(pRootOfTree == null) return null;
        // 中序遍历 构造链表
        inOrder(pRootOfTree);
        
		// 找到结果链表的头结点
        TreeNode res = pRootOfTree;
        while(res.left != null)
            res = res.left;
        return res;
    }
    
    // BST中序遍历结果是排序的
    public void inOrder(TreeNode cur) {
        
        if(cur == null) return;
        
        inOrder(cur.left);
        
        cur.left = pre;
        if(pre != null) pre.right = cur;
        pre = cur;
        
        inOrder(cur.right);
    }
}
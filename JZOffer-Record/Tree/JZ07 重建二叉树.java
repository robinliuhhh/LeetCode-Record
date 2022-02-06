/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	TreeNode root = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    	return root;
    }
    
    private TreeNode reConstructBinaryTree(int [] pre, int startPre, int endPre, int [] in, int startIn, int endIn) {
		
    	// 根据索引判断是否结束
    	if(startPre > endPre || startIn > endIn) return null;
		
		// 每颗子树的根节点肯定是pre子数组的首元素 所以每次新建一个子树的根节点
    	TreeNode root = new TreeNode(pre[startPre]);
    	
    	for(int i = startIn; i <= endIn; i++) {
			// 根节点的值 即为pre[]中第一个数
			// 确定根节点在in[]中的位置 以此判断左子树和右子树的范围
    		if(in[i] == pre[startPre]) {
				// 前序的开始结束索引通过计算中序左右子树的大小来计算
				// startPre+1 跳过根节点
				// startPre+i-startIn 从startPre位置越过左孩子及其子节点的偏移量（即i-startIn，因为startIn和i之间全是i这个元素的左孩子及其子节点）
				// i-startIn+startPre+1 从startPre位置越过左孩子及其子节点的偏移量 再往下一个节点走（即右孩子起始点）
				// endPre 结束
    			root.left = reConstructBinaryTree(pre, startPre+1, startPre+(i-startIn), in, startIn, i-1);
    			root.right = reConstructBinaryTree(pre, startPre+(i-startIn)+1, endPre, in, i+1, endIn);
                break;
    		}
    	}
		// 每次返回左子树或右子树的根节点
    	return root;
    }
}

/*
import java.util.Arrays;
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // base case
        if(pre.length == 0) return null;
        
        // 根节点的值，即为前序遍历数组中第一个数
        int rootVal = pre[0];
        
        // 只有根节点
        if(pre.length == 1) return new TreeNode(rootVal);
        
        // 确定根节点在中序遍历数组中的位置，记录下标
        // 以此判断左子树和右子树的范围
        int rootIndex = 0;
        for(int i = 0; i < in.length; i++) {
            if(rootVal == in[i]) {
                rootIndex = i;
                break;
            }
        }
        
        // 构造根节点
        TreeNode root = new TreeNode(rootVal);
        
        //递归，假设root的左右子树都已经构建完毕，那么只要将左右子树安到root左右即可
        //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1),Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex+1,pre.length),Arrays.copyOfRange(in,rootIndex+1,in.length));
        
        return root;
    }
}
*/
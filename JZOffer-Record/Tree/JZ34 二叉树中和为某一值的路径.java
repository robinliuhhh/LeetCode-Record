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
import java.util.ArrayList;
public class Solution {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>(); // 输出结果
    ArrayList<Integer> path = new ArrayList<>(); // 暂存路径
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        // 注意：路径为 根结点一直到叶结点 所经过的结点
        if(root == null || root.val > target) return res;
        path.add(root.val);
        target -= root.val;
        
        // 到叶结点且和为target
        if(target == 0 && root.left == null && root.right == null)
            // 把path列表复制到结果列表
			// add添加的是引用 如果不new一个的话 后面的操作会更改这个path
            res.add(new ArrayList<Integer>(path));
        
        // 左右子树递归查找
        FindPath(root.left,target);
        FindPath(root.right,target);
        // 到叶子节点仍不满足条件 退回上一节点
        path.remove(path.size() - 1);
        return res;
    }
}
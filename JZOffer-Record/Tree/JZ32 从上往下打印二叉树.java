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
// import java.util.*; 报错 cannot use <> with non-generic class LinkedList (etc
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        
        // 结果链表
        ArrayList<Integer> res = new ArrayList<>();
        // 辅助队列 利用FIFO特性
        Queue<TreeNode> queue = new LinkedList<>();
        
        // 空结点 直接返回空结果链表
        if(root == null) return res;
        // 根结点入队
        queue.add(root);
        while(!queue.isEmpty()) {
            // 根结点先出队 后面按顺序出队
            TreeNode temp = queue.poll();
            // 每出队一个 就加入结果链表
            res.add(temp.val);
            // 同一层 从左至右加入
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
        return res;
    }
}
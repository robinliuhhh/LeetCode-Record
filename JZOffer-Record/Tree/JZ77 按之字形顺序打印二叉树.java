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
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Deque;

public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        
        if(pRoot == null) return res;
        deque.add(pRoot);
        while(!deque.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 奇数层 从左到右打印
                TreeNode node = deque.removeFirst();
                temp.add(node.val);
                // addLast 从左到右添加偶数层结点
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
            res.add(temp);
            
            // 没有下一层 提前跳出
            if(deque.isEmpty()) break;
            
            temp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 偶数层 从右到左打印
                TreeNode node = deque.removeLast();
                temp.add(node.val);
                // addFirst 从右到左添加奇数层结点
                if(node.right != null) deque.addFirst(node.right);
                if(node.left != null) deque.addFirst(node.left);
            }
            res.add(temp);
        }
        return res;
    }
}
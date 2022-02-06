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
import java.util.Queue;

public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(pRoot == null) return res;
        queue.add(pRoot);
        while(!queue.isEmpty()) {
            // 每层都存在一个ArrayList里
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
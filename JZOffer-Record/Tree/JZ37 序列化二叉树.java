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
import java.util.LinkedList;
public class Solution {

    String SEP = ",";
    String NULL = "#";
    StringBuffer sb = new StringBuffer();

    // 采用前序遍历
    String Serialize(TreeNode root) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return sb.toString();
        }
        sb.append(root.val).append(SEP);
        Serialize(root.left);
        Serialize(root.right);
        return sb.toString();
    }

    int index = -1; // 数组下标

    TreeNode Deserialize(String str) {
        index++; // 手动“出栈” 每个结点访问一次
        if (index >= str.length()) return null;

        String[] nodes = str.split(SEP);
        TreeNode root = null;
        if (!nodes[index].equals(NULL)) {
            root = new TreeNode(Integer.parseInt(nodes[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }
}
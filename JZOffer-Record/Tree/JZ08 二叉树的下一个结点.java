/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) return null;
        // 如果有右子树 则找右子树的最左节点
        if (node.right != null) {
            node = node.right;
            while (node.left != null) 
                node = node.left;
            return node;
        }
        // 没右子树 则找第一个当前节点是父节点左孩子的节点
        while (node.next != null) {
            if (node.next.left == node) 
                return node.next;
            node = node.next;
        }
        return null; // 退到了根节点仍没找到 则返回null
    }
}
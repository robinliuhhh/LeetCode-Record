public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
		// 约定空树不是二叉搜索树
        // Java中数组可以为null 也可以为[]
        if(sequence == null || sequence.length == 0) return false;
        return judge(sequence, 0, sequence.length - 1);
    }
    
    // BST 后序遍历最后一个元素为root 数组中前半段小于root 后半段大于root
    public boolean judge(int [] sequence, int start, int root) {
		// start == root对应的是叶子结点 start > root对应的是空树 这两种情况都是true
		// root == end
        if(start >= root) return true;
        // 左右子树分界值
        int key = sequence[root];
        // 找到分界点 此时右子树未扫描
        int i;
        for(i = start; i < root; i++) {
            if(sequence[i] > key)
                break;
        }
        // 扫描右子树 判断是否合法（即右子树中的值都大于root）
        for(int j = i; j < root; j++) {
            if(sequence[j] < key)
                return false;
        }
        // 递归判断左右子树
        return judge(sequence, start, i - 1) && judge(sequence, i, root - 1);
    }
}

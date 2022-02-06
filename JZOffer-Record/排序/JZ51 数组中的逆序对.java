public class Solution {
    public int InversePairs(int [] array) {
        // 分治思想：归并排序
        int len = array.length;
        int[] copy = new int[len];
        for(int i = 0; i < len; i++) {
            copy[i] = array[i];
        }
        int[] temp = new int[len];
        return mergeSort(copy, 0, len - 1, temp);
    }
    public int mergeSort(int [] copy, int l, int r, int[] temp) {
        // 终止条件 子数组长度为 1
        if (l >= r) return 0;
        // 递归划分
        int m = l + (r - l) / 2;
        long res = mergeSort(copy, l, m, temp) + mergeSort(copy, m + 1, r, temp);
        // 合并计数阶段
        int i = l, j = m + 1;
        for(int k = l; k <= r; k++) {
            temp[k] = copy[k];
        }
        for(int k = l; k <= r; k++) {
            // 左子数组已合并完，因此添加右子数组当前元素，并执行 j = j + 1
            if(i == m + 1)
                copy[k] = temp[j++];
                // copy[k] = temp[j];
                // j = j + 1;
            // 右子数组已合并完
            else if(j == r + 1)
                copy[k] = temp[i++];
            else if(temp[i] <= temp[j])
                copy[k] = temp[i++];
            else {
                copy[k] = temp[j++];
                res += m -i + 1; // 统计逆序对
            }
        }
        return (int)(res % 1000000007);
    }
}
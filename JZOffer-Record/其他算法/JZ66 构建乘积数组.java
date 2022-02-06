import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        // b[i]的值是数组a中除了下标i以外的元素的积
        int[] B = new int[A.length];
        int temp = 0;
        for(int i = 0; i < A.length; i++) {
            temp = A[i];
            A[i] = 1; // 下标i对应的值变为1 相当于没乘
            B[i] = 1; // 做乘法 赋初值1
            for (int j = 0; j < A.length; j++) {
                B[i] *= A[j];
            }
            A[i] = temp; // 还原
        }
        return B;
    }
}
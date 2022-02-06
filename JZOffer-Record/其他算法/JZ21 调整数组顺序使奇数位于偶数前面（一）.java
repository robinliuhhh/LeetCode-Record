import java.util.*;
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param array int整型一维数组 
     * @return int整型一维数组
     */
    public int[] reOrderArray(int[] array) {
        // base case
        if (array.length == 0 || array.length == 1) return array;

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // 要维持原来的顺序可以借鉴冒泡排序 将相邻的偶数和奇数交换 
                // 每一轮j循环 把最右端偶数移到最后面
                if ((array[j] & 1) == 0 && (array[j + 1] & 1) != 0) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
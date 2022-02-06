import java.util.*;
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param array int整型一维数组 
     * @return int整型一维数组
     */
    public int[] reOrderArrayTwo(int[] array) {
        // 双指针
        int left = 0, right = array.length - 1;
        while (left < right) {
            // 左奇右偶 交换 左右位置各移动一位
            if ((array[left] & 1) == 0 && (array[right] & 1) != 0) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            } else if ((array[left] & 1) == 0 && (array[right] & 1) == 0) {
                // 左右都偶 right左移一位
                right--;
            } else {
                // 左右都奇 left右移一位
                left++;
            }
        }
        return array;
    }
}
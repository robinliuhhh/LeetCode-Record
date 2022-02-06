import java.util.*;
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param array int整型一维数组 
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] array) {
        // 设这两个数为x y
        int x = 0, y = 0;
        int n = 0; 
        for(int num : array) // 全组异或
            n ^= num; // 最终结果为x异或y
        
        // 若整数 x ⊕ y 某二进制位为 1, 则 x 和 y 的此二进制位一定不同
        int m = 1;
        while((n & m) == 0)
            m <<= 1; // 通过与运算从右向左循环判断，可获取整数 x⊕y 首位1, 记录于 m 中
        
        for(int num : array) { // 分组异或
            if((m & num) != 0) { // 这一组得出 与flag有相同二进制位最低位（为1）的那个数
                x ^= num; // 分组1 逐个异或得到x
            } else {
                y ^= num; // 分组2
            }
        }
        
        if(x > y) {
            int temp = y;
            y = x;
            x = temp;
        }
        
        return new int[] {x, y};
    }
}
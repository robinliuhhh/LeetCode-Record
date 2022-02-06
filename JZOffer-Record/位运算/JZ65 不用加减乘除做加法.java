public class Solution {
    public int Add(int num1, int num2) {
        // 位运算
        // 无进位：两个数异或
        // 有进位：两个数相与 并左移一位 （二进制进位 <<1 等于 *2）
        
        // num2 == 0 无进位 返回sum
        if(num2 == 0) return num1;
        // num1代表sum num2代表carry(进位)
        return Add(num1 ^ num2, (num1 & num2) << 1);
    }
}
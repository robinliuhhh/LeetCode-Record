public class Solution {
    public int NumberOf1(int n) {
        // 巧用n&(n−1)
        //     n   = 001100
        //     n-1 = 001011
        // n&(n−1) = 001000 消掉了最右边的1
		// 那么一个整数的二进制有多少个1 就可以进行多少次这样的操作
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
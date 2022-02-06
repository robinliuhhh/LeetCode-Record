public class Solution {
    public int Sum_Solution(int n) {
        /* 递归
            if(n == 1) return 1;
            n += sumNums(n - 1);
            return n;
        */
        
        // 用&&代替if判断 利用 逻辑与 的短路特性实现递归终止
        // 为构成语句 需加一个辅助布尔量 目的是进入Sum_Solution()
        int res = n;
        boolean b = (n > 0) && ((res += Sum_Solution(n - 1)) > 0);
        return res;
    }
}
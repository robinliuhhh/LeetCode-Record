/*
 * 举几个例子 可以看出规律来
 * 1 ： 0
 * 2 ： 1*1
 * 3 ： 1*2
 * 4 ： 2*2
 * 5 ： 2*3
 * 6 ： 3*3
 * 7 ： 2*2*3 或者4*3
 * 8 ： 2*3*3
 * 9 ： 3*3*3
 * 10：2*2*3*3 或者4*3*3
*/
public class Solution {
    public int cutRope(int target) {
        // <=4直接返回结果 >4时优先切成3
        int max = 1;
        if (target <= 3 && target > 0) {
            return target - 1;
        }
        while (target > 4) {
            target -= 3;
            max *= 3;
        }
        return max * target;
    }
}

/*
public class Solution {
    public int cutRope(int n) {
        // n<=3的情况 记录最大分段乘积
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int[] dp = new int[n + 1];
        // 跟n<=3不同 4可以分很多段
        // 这里的3可以不需要再分了 因为3分段最大才2 不分就是3 记录最大的
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int res = 0;// 记录最大的 达到最大就不用再分了
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                res = Math.max(res, dp[j] * dp[i - j]);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
*/
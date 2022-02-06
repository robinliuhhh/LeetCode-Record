import java.util.*;
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        // 动态规划
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for(int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
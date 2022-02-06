import java.util.*;
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串 
     * @param pattern string字符串 
     * @return bool布尔型
     */
    public boolean match (String str, String pattern) {
        
        int m = str.length() + 1, n = pattern.length() + 1;
        
        // 1.定义状态：dp[i][j]用于表示s的前i个字符和p的前j个字符是否匹配
        boolean[][] dp = new boolean[m][n];
        
        // 2.初始化dp数组
        // 2.1两个空字符串是可以匹配的
        dp[0][0] = true;
        
        // 2.2初始化首行
        for(int j = 2; j < n; j += 2)
            // str为空的情况下，pattern的偶数位为'*'的话是可以匹配上的（即让 p 的奇数位出现 0 次，保持 p 是空字符串）
            // 因为可以让'*'之前的字符出现次数为0
            // 因此，循环遍历字符串 p ，步长为 2（即只看偶数位）
            dp[0][j] = dp[0][j - 2] && pattern.charAt(j - 1) == '*';
        
        // 3.状态转移：因为已经初始化了首行，str和pattern都从索引1开始匹配
        for(int i = 1; i < m; i++) { 
            for(int j = 1; j < n; j++) {
                // 3.1 p的第j个字符为'*'
                if(pattern.charAt(j - 1) == '*') {
                    // 3.1.1如果s的前i个字符和p的前j - 2个字符匹配，这时p的第j个字符为'*'
                    // 那么无论p的第j-1个字符是什么，令它出现0次，dp[i][j]就可以为true
                    if(dp[i][j - 2]) 
                        dp[i][j] = true;
                    // 3.1.2
                    else if(dp[i - 1][j] && str.charAt(i - 1) == pattern.charAt(j - 2)) 
                        dp[i][j] = true;
                    // 3.1.3
                    else if(dp[i - 1][j] && pattern.charAt(j - 2) == '.') 
                        dp[i][j] = true;
                } else { // 3.2p的第j个字符不为'*'
                    // 3.2.1 s的前i - 1个字符和p的前j - 1个字符匹配，且s的第i个字符和p的第j个字符相等
                    if(dp[i - 1][j - 1] && str.charAt(i - 1) == pattern.charAt(j - 1)) 
                        dp[i][j] = true;
                    // 3.2.2
                    else if(dp[i - 1][j - 1] && pattern.charAt(j - 1) == '.') 
                        dp[i][j] = true;
                }
            }
        }
        // dp 矩阵右下角字符，代表字符串 s 和 p 能否匹配
        return dp[m - 1][n - 1];
    }
}
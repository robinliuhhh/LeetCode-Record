import java.util.*;
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param matrix char字符型二维数组 
     * @param word string字符串 
     * @return bool布尔型
     */
    public boolean hasPath (char[][] matrix, String word) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length ; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
               if( dfs(matrix, word, i , j , 0, visited)) {
                   return true;
               }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] matrix, String word, int i, int j, int k, boolean[][] visited) {
        // 先判断失败条件
        // 1.当前节点越界
        // 2.当前节点已经走过了
        // 3.当前节点的字符不是我们要找的
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length ||
           visited[i][j] ||
           k >= word.length() || matrix[i][j] != word.charAt(k)) {
            return false;
        }
        
        // 成功：遍历到最后一个
        if( k == word.length()-1) {
            return true;
        }
        
        // 覆盖 防止重复
        visited[i][j] = true;
        // 递归 判断上下左右
        boolean res = 
            dfs(matrix , word , i , j - 1, k + 1, visited) || 
            dfs(matrix , word , i , j + 1, k + 1, visited) || 
            dfs(matrix , word , i - 1 , j, k + 1, visited) || 
            dfs(matrix , word , i + 1, j, k + 1, visited);
        // 回溯
        visited[i][j] = false;
        return res;
    }
}
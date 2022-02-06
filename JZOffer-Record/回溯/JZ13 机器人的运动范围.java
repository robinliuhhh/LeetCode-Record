public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        // 从(0, 0)开始走
        return countingSteps(threshold, rows, cols, 0, 0, visited);
    }

    public int countingSteps(int limit, int rows, int cols, int r, int c, boolean[][] visited) {
        // 先判断失败条件
        // 1.当前节点越界
        // 2.当前节点已经走过了
        // 3.当前节点不满足limit限制
        if (r < 0 || r >= rows || c < 0 || c >= cols || 
            visited[r][c] || 
            bitSum(r) + bitSum(c) > limit) {
            return 0;
        }
        
        // 覆盖 防止重复
        visited[r][c] = true;
        // 递归 判断上下左右
        // 每次循环能够达到格子数 = 上下左右 + 本身
        return countingSteps(limit, rows, cols, r - 1, c, visited)
                + countingSteps(limit, rows, cols, r, c - 1, visited)
                + countingSteps(limit, rows, cols, r + 1, c, visited)
                + countingSteps(limit, rows, cols, r, c + 1, visited)
                + 1;
    }

    public int bitSum(int t) {
        int count = 0;
        while (t != 0) {
            count += t % 10;
            t /= 10;
        }
        return count;
    }
}
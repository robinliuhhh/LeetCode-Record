import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length == 0) return list;
        
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        
        // 用if条件句不断地收缩矩阵的边界
        while(true) {
            // 向右走存入整行的值
            for(int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            // 上边界加一 并判断是否超出下边界
            if(++up > down) {
                break;
            }
            
            // 上边界up从1开始（第二行）
            for(int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if(--right < left) {
                break;
            }
            
            for(int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            if(--down < up) {
                break;
            }
            
            for(int i = down; i>= up; i--) {
                 list.add(matrix[i][left]);
            }
            if(++left > right) {
                break;
            }
        }
        return list;
    }
}
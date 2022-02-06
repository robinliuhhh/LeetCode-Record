/**
* 要求时间复杂度 O(n+m)
* 所以从左下/右上开始找 一次排除一行或一列
*/
public class Solution {
    public boolean Find(int target, int [][] array) { 
		// 从右上找 向左下移动
        int row = 0;
        int col = array[0].length - 1;
		// row col范围 [0, array.length)
        while(row < array.length && col >= 0) {
            if(array[row][col] == target) {
                return true;
            } else if(target > array[row][col]) {
				// 若target > 当前节点 则下移一行
                row++;
            } else {
				// 若target < 当前节点 则左移一行
                col--;
            }
        }
        return false;
    }
}
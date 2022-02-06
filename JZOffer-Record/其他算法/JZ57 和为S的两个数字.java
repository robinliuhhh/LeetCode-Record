import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        // 对撞双指针
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // 如果有多对数字的和等于S 输出两个数的乘积最小的
        // 递增排序数组 从最左侧开始最小
        int left = 0, right = array.length - 1;
        while(left < right) {
            int s = array[left] + array[right];
            if(s == sum) {
                // 输出两个数 小的先输出
                result.add(array[left]);
                result.add(array[right]);
                break;
            }
            if(s > sum) {
                right--;
            } else {
                left++;
            }
        }
        
        return result;
    }
}
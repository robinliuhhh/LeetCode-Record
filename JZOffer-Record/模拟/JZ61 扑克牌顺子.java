import java.util.*;
public class Solution {
    public boolean IsContinuous(int [] numbers) {
        // 构成顺子判断条件 max - min < 5
        Set<Integer> set = new HashSet<>(); // Set 无序 不包含重复元素
        int min = 13, max = 0; // 数组的数取值为[0, 13] 初值反向赋值
        
        for(int num : numbers) {
            if(num == 0) continue; // 0可以看作任意牌 跳过0
            max = Math.max(num, max);
            min = Math.min(num, min); // 更新最值
            if(set.contains(num)) // 顺子 即这五张牌是连续的(0除外)
                return false; // 若有重复 则不连续
            set.add(num); // 把牌添加到set
        }        
        return max - min < 5; // 构成顺子判断条件
    }
}
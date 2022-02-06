/**
    用一个双端队列 队列第一个位置保存当前窗口的最大值下标 当窗口滑动一次
    1.判断当前最大值是否过期
    2.新增加的值从队尾开始比较 把所有比它小的值丢掉
*/
import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        if(size > num.length || size == 0) return res;
        
        Deque<Integer> max = new LinkedList<>();
        for(int i = 0; i < num.length; i++) {
            // 2.新增加的值从队尾开始比较 把所有比它小的值丢掉
            while(!max.isEmpty() && num[max.peekLast()] < num[i]) {
                max.pollLast();
            }
            // 比较后加入deque
            max.addLast(i);
            
            // 1.判断队首元素是否过期 维持窗口内数字数量
            if(max.peekFirst() == i -size) max.pollFirst();
            
            // 当滑动窗口首地址i大于等于size时才开始写入窗口最大值
            // 保证小于size的数字被扫描到
            if (i >= size - 1) res.add(num[max.peekFirst()]);
        }
        return res;
    }
}
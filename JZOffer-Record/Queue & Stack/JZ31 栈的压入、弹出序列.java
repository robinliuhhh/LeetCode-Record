import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        // 辅助栈 按题目入栈顺序压栈
        Stack<Integer> s = new Stack();
        
        // 辅助栈长度
        int index = 0;
        
        for(int i : pushA) {
            s.push(i);
            // 辅助栈和题目弹出序列相同时 开始出栈
            while(!s.empty() && s.peek() == popA[index]) {
                s.pop();
                // 更新辅助栈长度
                index++;
            }
        }
        // 如果辅助栈长度和题目压入栈长度不同 说明弹出顺序不对
        // 正确弹出顺序只有一种
        return index == pushA.length;
    }
}

import java.util.Stack;

public class Solution {

	// 所有元素栈
    Stack<Integer> s1 = new Stack();
	// 最小元素栈 始终保持peek是最小值 便于实现min函数
    Stack<Integer> s2 = new Stack();
    
    public void push(int node) {
        s1.push(node);
        
        if(s2.isEmpty() || node <= s2.peek()) {
            s2.push(node);
        }
    }
    
    public void pop() {
        // 如果最小元素被弹出 辅助栈s2也要更新
        if(s1.peek() == s2.peek()) {
            s1.pop();
            s2.pop();
        } else {
            s1.pop();
        }
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int min() {
        return s2.peek();
    }
}

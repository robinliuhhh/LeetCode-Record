import java.util.Stack;

public class Solution {
	
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        // 数据先装到第一个栈里
        stack1.push(node);
    }
    
    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                // 把第一个栈里的数据倒到第二个栈
                stack2.push(stack1.pop());
            }
        }
        
        // 第二个栈出栈顺序和数据加入顺序相同
        return stack2.pop();
    }
}

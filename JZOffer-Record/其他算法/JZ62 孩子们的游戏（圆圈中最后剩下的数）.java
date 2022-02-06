import java.util.LinkedList;
public class Solution {
	// 用链表模拟游戏过程
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }
        
        int pre = 0; // 当前开始的人的序号
       	while (list.size() > 1) {
			// 从pre开始往后数m-1个人 就是该淘汰的人
			// %list.size()表示最后一个小朋友报完数了 再从第一个小朋友开始报数
           	int cur = (pre + (m - 1)) % list.size();
            list.remove(cur);
			pre = cur;
        }
        
        return list.size() == 1 ? list.get(0) : -1;
    }
}
/*
// 约瑟夫环
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0 || m <= 0) 
            return -1;
        
        int ans = 0;
        for(int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        
        return ans;
    }
}
*/
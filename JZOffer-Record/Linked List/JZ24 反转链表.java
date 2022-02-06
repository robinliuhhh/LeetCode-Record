/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
// 递归
public class Solution {
    public ListNode ReverseList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        // 结果链表 走到链表的末端结点作为头节点
        ListNode newNode = ReverseList(head.next);
        
		// 1	2	3->null		4->3
		//          head		head.next
        head.next.next = head; 
        head.next = null; // 尾节点后续节点为空
        
        return newNode; // 进入上层递归嵌套(跳回 head.next.next = head;)
    }
}

/*
方法二：调整链表指针

public class Solution {
    public ListNode ReverseList(ListNode head) {
        // 结果链表
        ListNode newNode = null;
        
        while(head != null) {
            // 留作下一步访问开始节点
            ListNode temp = head.next;
            // 每次访问的原链表节点都会成为新链表的头结点
            head.next = newNode; // 其实就是把newNode挂到访问的原链表节点的后面
            // 更新新链表 第一次操作后 newNode为 head->null
            newNode = head;
            // 重新赋值 head回到原链表 继续访问
            head = temp;
        }
        return newNode;
    }
}
*/

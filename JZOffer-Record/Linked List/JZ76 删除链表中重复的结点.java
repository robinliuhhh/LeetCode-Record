/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
import java.util.*;
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        
        if(pHead == null || pHead.next == null) return pHead;
        
        ListNode curNode = pHead;
        if(curNode.val == curNode.next.val) {
            ListNode nextNode = curNode.next;
            while(nextNode != null && nextNode.val == curNode.val) {
                // 跳过所有重复结点 结束时nextNode为重复结点后的第一个新结点
                nextNode = nextNode.next;
            }
            return deleteDuplication(nextNode);
        } else {
			// 每个结点都要经历deleteDuplication()
            curNode.next = deleteDuplication(curNode.next);
            return curNode;
        }
    }
}

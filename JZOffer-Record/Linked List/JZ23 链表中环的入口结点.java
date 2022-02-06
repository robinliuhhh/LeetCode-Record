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

    public ListNode EntryNodeOfLoop(ListNode pHead) {
		
        Set<ListNode> set = new HashSet<>(); // 无序 不重复
		
        while(pHead != null) {
            if(set.contains(pHead)) {
                return pHead; // 有环 即重复访问
            } else {
                set.add(pHead);
                pHead = pHead.next;
            }
        }
        return null; // 无环
    }
}
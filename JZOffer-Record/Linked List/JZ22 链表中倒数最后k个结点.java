/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */
import java.util.*;
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pHead ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {

    // 快慢指针  一根指针先走k步（边走边判断是否为空 因为链表长可能小于k）
	// 最后两根指针一起走 前面那根指针为空时后面的指针所指即为所求
        
	ListNode fast = pHead, slow = pHead;
        // 先让快指针走k步
        while(fast != null && k > 0) {
			k--;
			fast = fast.next;
        }
        // 此时链表长度小于k 返回null
        if(k > 0) return null;
        
        // 链表长度大于k 两个指针同步走
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 当快指针走到头时 慢指针就是链表倒数第k个节点
        return slow;
    } 
}

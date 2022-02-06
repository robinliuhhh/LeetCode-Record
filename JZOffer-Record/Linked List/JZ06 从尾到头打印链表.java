/*
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    
    ArrayList<Integer> list = new ArrayList<>(); // 空list
    
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null) {
            list.add(0, listNode.val); // 头插法
            printListFromTailToHead(listNode.next); // 原链表向后移一个
        }
        return list; // 若原链表为空 直接返回空list
    }
}



import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        while(listNode != null) {
            // 如果 index 没有传入实际参数 元素将追加至数组的最末尾
            res.add(0, listNode.val); // 头插法
            listNode = listNode.next;
        }
        return res;
    }
}
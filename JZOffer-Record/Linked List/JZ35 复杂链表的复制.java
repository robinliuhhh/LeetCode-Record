/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/

/*
*解题思路：
* 1.遍历链表复制每个结点 将复制结点插到原结点后面；
* 2.重新遍历链表 复制随机指针 new.random = old.random.next;
* 3.拆分链表 将链表拆分为原链表和复制链表
*
* 画图易理解！
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
		
        if(pHead == null) return null;
        
        RandomListNode curNode = pHead;
        while(curNode != null) {
            RandomListNode cloneNode = new RandomListNode(curNode.label);
            cloneNode.next = curNode.next; // 交接指向
            curNode.next = cloneNode;
            curNode = cloneNode.next; // curNode = curNode.next.next;
        }
        
        curNode = pHead;
        while(curNode != null) {
            // 注意判空
            curNode.next.random = curNode.random == null ? null : curNode.random.next;
            curNode = curNode.next.next;
        }
        
        curNode = pHead;
        RandomListNode cloneHead = pHead.next;
        while(curNode != null) {
            RandomListNode cloneNode = curNode.next;
            curNode.next = cloneNode.next; // 归还指向
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            curNode = curNode.next;
        }
        
        return cloneHead;
    }
}
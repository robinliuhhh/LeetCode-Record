/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		
		// 用两个指针扫描两个链表 最终两个指针到达 null 或者到达公共结点
		// 长度相同有公共结点 第一次就遍历到；没有公共结点 走到尾部NULL相遇 返回NULL
		// 长度不同有公共结点 第一遍差值就出来了 第二遍一起到公共结点；没有公共结点 一起到结尾NULL

		/*
			假定 List1长度 a+n  List2长度 b+n 且a<b
			那么 p1 会先到链表尾部 这时p2走到a+n位置 将p1换成List2头部
			接着p2再走b+n-(n+a)=b-a 步到链表尾部 这时p1也走到List2的b-a位置 还差a步就到可能的第一个公共节点
			将p2换成 List1头部 p2走a步也到可能的第一个公共节点
				如果恰好p1==p2 那么p1就是第一个公共节点 
				或者p1和p2一起走n步到达列表尾部 二者没有公共节点 返回NULL
			时间复杂度O(n+a+b)         
		*/
        if(pHead1 == null || pHead2 == null) return null;
		
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != p2) {            
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }
}

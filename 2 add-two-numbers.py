# https://leetcode.com/problems/add-two-numbers/

from typing import Optional

# Definition for singly-linked list.
class ListNode:
 def __init__(self, val=0, next=None):
     self.val = val
     self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head = cur = ListNode(0) # cur用来变化 否则return head.next始终是链表的最后一个值
        sum = 0
        while l1 or l2 or sum: # or sum 注意连续进位的情况
            if l1:
                sum += l1.val
                l1 = l1.next
            if l2:
                sum += l2.val
                l2 = l2.next
            cur.next = ListNode(sum % 10)
            cur = cur.next
            sum //= 10 # 神来之笔
            # Handled both cases where carry = 0 and where carry is not 0. 
            # Very cool solution.
        return head.next

if __name__ == '__main__':
    solution = Solution()
    l1 = ListNode(2, ListNode(4, ListNode(3, None)))
    l2 = ListNode(5, ListNode(6, ListNode(4, None)))
    res = solution.addTwoNumbers(l1, l2)
    while res != None:
        print(res.val, end = ' ')
        res = res.next

    print('\n------')
    
    l1 = ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, None)))))
    l2 = ListNode(9, ListNode(9, None))
    res = solution.addTwoNumbers(l1, l2)
    while res != None:
        print(res.val, end = ' ')
        res = res.next

# 7 0 8 
# ------
# 8 9 0 0 0 1

# 时间复杂度： O(max(m,n)) 其中 m 和 n 分别为两个链表的长度
# 空间复杂度： O(1) 返回值不计入空间复杂度 此处仅考虑sum所占空间
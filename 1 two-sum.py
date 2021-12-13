# https://leetcode.com/problems/two-sum/

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = dict() # map
        for i, num in enumerate(nums): # enumerate 同时遍历 key 和 value
            # print(i, num) key在前 value在后
            cur = target - num
            if cur not in dic:
                dic[num] = i
            else:
                return [dic[cur], i]

if __name__ == '__main__':
    solution = Solution()
    nums = [3, 3, 2, 4]
    target = 6
    res = solution.twoSum(nums, target)
    print(res)

# [0, 1]

# 时间复杂度： O(n)
# 空间复杂度： O(n)
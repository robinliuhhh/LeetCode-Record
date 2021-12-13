# https://leetcode.com/problems/two-sum/

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = dict() # map
        for i, num in enumerate(nums): # enumerate 同时遍历 key 和 value
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
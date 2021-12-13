# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        usedDic = {}
        maxLen = pointer = 0
        for i, ch in enumerate(s):
            if ch in usedDic and usedDic[ch] >= pointer: 
                # and usedDic[ch] >= i 重复值在窗口内部才右移指针
                # 测试用例 tmmabct 可以检测这种情况
                pointer = usedDic[ch] + 1
            else:
                maxLen = max(maxLen, i - pointer + 1)
            usedDic[ch] = i
        return maxLen

if __name__ == '__main__':
    solution = Solution()
    res = solution.lengthOfLongestSubstring("tmmabct")
    print(res)

# 5
# 没有 and usedDic[ch] >= i 则为4

# 时间复杂度： O(n) n is the length of the input string.
# 空间复杂度： O(n) m is the number of unique characters of the input.
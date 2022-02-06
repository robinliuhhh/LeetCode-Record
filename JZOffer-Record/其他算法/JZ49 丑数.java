import java.lang.Math;
public class Solution {
	public int GetUglyNumber_Solution(int index) {
		
		if (index <= 0) return 0;
		
		int[] dp = new int[index];
		dp[0] = 1; // 习惯上我们把1当做是第一个丑数
		int id2 = 0, id3 = 0, id5 = 0; // 相当于指针，初始指向三个链表中第一个元素
		for (int i = 1; i < index; i++) {
			// 获取最小值加入排序数组
			dp[i] = Math.min(dp[id2] * 2, Math.min(dp[id3] * 3, dp[id5] * 5));
			// 这里不用else if 因为三个链表可能有相同元素
			// 此时三个链表指针都要移动
			if (dp[id2] * 2 == dp[i]) id2 += 1;
			if (dp[id3] * 3 == dp[i]) id3 += 1;
			if (dp[id5] * 5 == dp[i]) id5 += 1;
		}
		return dp[index - 1];
	}
}
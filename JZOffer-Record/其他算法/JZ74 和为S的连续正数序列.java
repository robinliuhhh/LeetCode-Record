import java.util.ArrayList;
public class Solution {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		// 滑动窗口（双指针）
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		int i = 1, j = 2, s = 3;
		while (i < j) {
			if (s == sum) {
				ArrayList<Integer> res = new ArrayList<Integer>();
				for (int k = i; k <= j; k++) {
					res.add(k);
				}
				result.add(res);
			}
			if (s >= sum) {
				s -= i;
				i++;
			} else {
				j++;
				s += j;
			}
		}

		return result;
	}
}
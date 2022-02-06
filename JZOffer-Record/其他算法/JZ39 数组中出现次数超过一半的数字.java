public class Solution {
	public int MoreThanHalfNum_Solution(int[] array) {
		int len = array.length;
		int res = 0;
		int count = 0;
		for (int i = 0; i < len; i++) {
			int temp = array[i];
			// 每次移到array的下一个值时 需要重新计数
			count = 0;
			for (int j = 0; j < len; j++) {
				if (temp == array[j]) count++;
			}
			if (count > len / 2) {
				res = temp;
				break;
			}
		}
		return res;
	}
}
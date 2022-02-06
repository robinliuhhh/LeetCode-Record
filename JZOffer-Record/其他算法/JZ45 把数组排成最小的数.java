import java.util.ArrayList;
public class Solution {
	public String PrintMinNumber(int[] numbers) {
		// 若拼接字符串 x + y > y + x 则 x “大于” y
		// 332 > 323  3 “大于” 32 3排在32后面
		ArrayList<String> list = new ArrayList<>();
		for (int num : numbers) {
			list.add(String.valueOf(num));// 转为String类型
		}
		list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
		return String.join("", list); // 无空格拼接（每个数贴在一起）
	}
}
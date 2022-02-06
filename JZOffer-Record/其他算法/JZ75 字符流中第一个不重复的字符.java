import java.util .*;
public class Solution {

	// 无序 可重复
	// Map<Character, Integer> map = new HashMap<>(); // HashMap 数据位置会变化
	Map<Character, Integer> map = new LinkedHashMap<>(); // LinkedHashMap 数据顺序不变

	//Insert one char from stringstream
	public void Insert(char ch) {
		// getOrDefault(ch,0) 若map中存在该ch则返回对应值 否则返回0
		// ch数量+1 返回值+1
		map.put(ch, map.getOrDefault(ch, 0) + 1);
	}

	//return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		// map.keySet() 返回map所有的键
		for (char c : map.keySet()) {
			// 寻找值为1的键 即为第一个不重复字符
			if (map.get(c) == 1)
				return c;
		}
		// 找不到
		return '#';
	}
}
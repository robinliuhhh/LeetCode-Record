public class Solution {
    public int jumpFloor(int target) {
        // 多列几项找规律 发现是类斐波那契数列
		// f(n) = f(n-1) + f(n-2) 0 1 2 3 5
        if(target <= 2) {
            return target;
        }
        int f1 = 1, f2 = 2, cur = 0;
        for(int i = 2; i < target; i++) {
            cur = f1 + f2;
            f1 = f2;
            f2 = cur;
        }
        return cur;
    }
}

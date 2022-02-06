public class Solution {
    public int rectCover(int target) {
        // 和跳台阶同理
        // 横放 竖放 可看作一次跳 一阶 两阶
        if(target <= 2) {
            return target;
        }
        int f1 = 1, f2 = 2, cur = 0;
        for(int i = 3; i <= target; i++) {
            cur = f1 + f2;
            f1 = f2;
            f2 = cur;
        }
        return cur;
    }
}

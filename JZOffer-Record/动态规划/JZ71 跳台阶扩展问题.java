public class Solution {
    public int JumpFloorII(int target) {
        // 跳到n层 可以从它下一层至地面开始跳（一次性跳1层 2层...n层）
        // 从n-1层起跳 一次性跳1层 而跳到n-1有f(n-1)种跳法
        // 从n-2层起跳 一次性跳2层 而跳到n-2有f(n-2)种跳法
        // f(n)    = f(n-1)+f(n-2)+...+f(0)
        // f(n-1)  = f(n-2)+f(n-3)+...+f(0)
        // f(n)    = 2*f(n-1)
        if(target == 0 || target == 1) return 1;
        else return 2*JumpFloorII(target - 1);
    }
}

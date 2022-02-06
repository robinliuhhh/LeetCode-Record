public class Solution {
    public int Fibonacci(int n) {
        
        if(n == 1 || n == 2) return 1;
        
        int first = 1; // fib(1) = 1
        int second = 1; // fib(2) = 1
        int current = 0;
        for(int i = 2; i < n; i++) {
            current = first + second;
            first = second;
            second = current;
        }
        return current;
    }
}
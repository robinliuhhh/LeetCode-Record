import java.util.PriorityQueue;
/*
    中位数：所有数值排序之后再计算
    两个堆中的数据数目差不能超过1 这样可以使中位数只会出现在两个堆的交接处
    大顶堆的所有数据都<小顶堆 这样就满足了排序要求
*/
public class Solution {
    // 记录奇偶
    int count;
    // 小顶堆存较大的数 从小到大排序
    // 偶数时 minHeap.peek()即为中间两个数的右值
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // 大顶堆存较小的数 从大到小排序
    // 偶数时 maxHeap.peek()即为中间两个数的左值
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public void Insert(Integer num) {
        // 从1开始计数
        count++;
        if ((count & 1) == 0) { // 判断偶数的高效写法
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                // 偶数放大顶堆
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            // 保证小顶堆中的数永远>=大顶堆中的数
            // 再将大顶堆中最大值插入到小顶堆中
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                // 奇数放小顶堆
                minHeap.offer(num);
                num = minHeap.poll();
            }
            // 再将小顶堆中最小值插入到大顶堆中
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if (count == 0) return 0.0;

        double result;
        //总数为奇数时，大顶堆堆顶就是中位数
        if ((count & 1) == 1)
            result = maxHeap.peek();
        else
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        return result;
    }
}